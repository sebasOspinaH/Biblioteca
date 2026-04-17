import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Persistencia {

    private static final String DATA_DIR = "data/";
    private static final String CLIENTES_FILE  = DATA_DIR + "clientes.json";
    private static final String LIBROS_FILE    = DATA_DIR + "libros.json";
    private static final String PRESTAMOS_FILE = DATA_DIR + "prestamos.json";


    private static String esc(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static void escribir(String ruta, String contenido) {
        try {
            new File(DATA_DIR).mkdirs();
            PrintWriter pw = new PrintWriter(new FileWriter(ruta));
            pw.print(contenido);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error guardando " + ruta + ": " + e.getMessage());
        }
    }

    private static String leer(String ruta) {
        File f = new File(ruta);
        if (!f.exists()) return null;
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) sb.append(line).append('\n');
            br.close();
            return sb.toString().trim();
        } catch (IOException e) {
            System.out.println("Error leyendo " + ruta + ": " + e.getMessage());
            return null;
        }
    }

    public static void guardarClientes(ArrayList<Cliente> clientes) {
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            sb.append("  {\n");
            sb.append("    \"id\": ").append(c.getId()).append(",\n");
            sb.append("    \"nombre\": \"").append(esc(c.getNombre())).append("\",\n");
            sb.append("    \"telefono\": ").append(c.getTelefono()).append(",\n");
            sb.append("    \"direccion\": \"").append(esc(c.getDireccion())).append("\",\n");
            sb.append("    \"presentalibro\": \"").append(esc(c.getPresentalibro())).append("\",\n");
            sb.append("    \"multaPendiente\": ").append(c.getMultaPendiente()).append(",\n");
            sb.append("    \"historial\": [");
            ArrayList<String> hist = c.getHistorialPrestamos();
            for (int j = 0; j < hist.size(); j++) {
                sb.append("\"").append(esc(hist.get(j))).append("\"");
                if (j < hist.size() - 1) sb.append(", ");
            }
            sb.append("]\n  }");
            if (i < clientes.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        escribir(CLIENTES_FILE, sb.toString());
    }

    public static ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String raw = leer(CLIENTES_FILE);
        if (raw == null || raw.isBlank()) return lista;
        // parse simple: split by objects
        String[] objetos = raw.split("\\{");
        for (String bloque : objetos) {
            if (!bloque.contains("\"id\"")) continue;
            int id = parseInt(getVal(bloque, "id"));
            String nombre = getStr(bloque, "nombre");
            long telefono = parseLong(getVal(bloque, "telefono"));
            String direccion = getStr(bloque, "direccion");
            String presentalibro = getStr(bloque, "presentalibro");
            double multa = parseDouble(getVal(bloque, "multaPendiente"));
            Cliente c = new Cliente(id, telefono, presentalibro, nombre, direccion);
            c.setMultaPendiente(multa);
            ArrayList<String> hist = parseStringArray(bloque, "historial");
            c.setHistorialPrestamos(hist);
            lista.add(c);
        }
        return lista;
    }


    public static void guardarLibros(ArrayList<Libro> libros) {
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < libros.size(); i++) {
            Libro l = libros.get(i);
            sb.append("  {\n");
            sb.append("    \"identificador\": \"").append(esc(l.getIdentificador())).append("\",\n");
            sb.append("    \"nombre\": \"").append(esc(l.getNombre())).append("\",\n");
            sb.append("    \"autor\": \"").append(esc(l.getAutor())).append("\",\n");
            sb.append("    \"editorial\": \"").append(esc(l.getEditorial())).append("\",\n");
            sb.append("    \"anhoP\": ").append(l.getAnhoP()).append(",\n");
            sb.append("    \"estado\": \"").append(esc(l.getEstado())).append("\",\n");
            sb.append("    \"contadorPrestamos\": ").append(l.getContadorPrestamos()).append(",\n");
            sb.append("    \"reservas\": [");
            List<Integer> reservas = new ArrayList<>(l.getListaReservas());
            for (int j = 0; j < reservas.size(); j++) {
                sb.append(reservas.get(j));
                if (j < reservas.size() - 1) sb.append(", ");
            }
            sb.append("]\n  }");
            if (i < libros.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        escribir(LIBROS_FILE, sb.toString());
    }

    public static ArrayList<Libro> cargarLibros() {
        ArrayList<Libro> lista = new ArrayList<>();
        String raw = leer(LIBROS_FILE);
        if (raw == null || raw.isBlank()) return lista;
        String[] objetos = raw.split("\\{");
        for (String bloque : objetos) {
            if (!bloque.contains("\"identificador\"")) continue;
            String id = getStr(bloque, "identificador");
            String nombre = getStr(bloque, "nombre");
            String autor = getStr(bloque, "autor");
            String editorial = getStr(bloque, "editorial");
            int anhoP = parseInt(getVal(bloque, "anhoP"));
            String estado = getStr(bloque, "estado");
            int contador = parseInt(getVal(bloque, "contadorPrestamos"));
            Libro l = new Libro(autor, nombre, editorial, anhoP, estado, id);
            l.setContadorPrestamos(contador);
            List<Integer> reservas = parseIntArray(bloque, "reservas");
            Queue<Integer> q = new LinkedList<>(reservas);
            l.setListaReservas(q);
            lista.add(l);
        }
        return lista;
    }


    public static void guardarPrestamos(ArrayList<Prestamo> prestamos) {
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo p = prestamos.get(i);
            sb.append("  {\n");
            sb.append("    \"idCliente\": ").append(p.getIdCliente()).append(",\n");
            sb.append("    \"idLibro\": \"").append(esc(p.getIdLibro())).append("\",\n");
            sb.append("    \"fechaPrestamo\": \"").append(p.getFechaPrestamo()).append("\",\n");
            sb.append("    \"fechaLimite\": \"").append(p.getFechaLimite()).append("\",\n");
            sb.append("    \"devuelto\": ").append(p.isDevuelto()).append("\n  }");
            if (i < prestamos.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        escribir(PRESTAMOS_FILE, sb.toString());
    }

    public static ArrayList<Prestamo> cargarPrestamos() {
        ArrayList<Prestamo> lista = new ArrayList<>();
        String raw = leer(PRESTAMOS_FILE);
        if (raw == null || raw.isBlank()) return lista;
        String[] objetos = raw.split("\\{");
        for (String bloque : objetos) {
            if (!bloque.contains("\"idCliente\"")) continue;
            int idCliente = parseInt(getVal(bloque, "idCliente"));
            String idLibro = getStr(bloque, "idLibro");
            LocalDate fp = LocalDate.parse(getStr(bloque, "fechaPrestamo"));
            LocalDate fl = LocalDate.parse(getStr(bloque, "fechaLimite"));
            boolean devuelto = "true".equalsIgnoreCase(getVal(bloque, "devuelto").trim());
            Prestamo p = new Prestamo(idCliente, idLibro, fp, fl);
            p.setDevuelto(devuelto);
            lista.add(p);
        }
        return lista;
    }

    private static String getVal(String bloque, String key) {
        String pattern = "\"" + key + "\"";
        int idx = bloque.indexOf(pattern);
        if (idx < 0) return "";
        idx = bloque.indexOf(":", idx) + 1;
        int end = bloque.indexOf("\n", idx);
        if (end < 0) end = bloque.length();
        return bloque.substring(idx, end).trim().replace(",", "").trim();
    }

    private static String getStr(String bloque, String key) {
        String v = getVal(bloque, key);
        if (v.startsWith("\"")) v = v.substring(1);
        if (v.endsWith("\"")) v = v.substring(0, v.length() - 1);
        return v;
    }

    private static int parseInt(String s) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return 0; }
    }

    private static long parseLong(String s) {
        try { return Long.parseLong(s.trim()); } catch (Exception e) { return 0L; }
    }

    private static double parseDouble(String s) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { return 0.0; }
    }

    private static ArrayList<String> parseStringArray(String bloque, String key) {
        ArrayList<String> result = new ArrayList<>();
        int idx = bloque.indexOf("\"" + key + "\"");
        if (idx < 0) return result;
        int start = bloque.indexOf("[", idx);
        int end   = bloque.indexOf("]", start);
        if (start < 0 || end < 0) return result;
        String inner = bloque.substring(start + 1, end).trim();
        if (inner.isEmpty()) return result;
        for (String part : inner.split(",")) {
            String s = part.trim().replace("\"", "");
            if (!s.isEmpty()) result.add(s);
        }
        return result;
    }

    private static List<Integer> parseIntArray(String bloque, String key) {
        List<Integer> result = new ArrayList<>();
        int idx = bloque.indexOf("\"" + key + "\"");
        if (idx < 0) return result;
        int start = bloque.indexOf("[", idx);
        int end   = bloque.indexOf("]", start);
        if (start < 0 || end < 0) return result;
        String inner = bloque.substring(start + 1, end).trim();
        if (inner.isEmpty()) return result;
        for (String part : inner.split(",")) {
            String s = part.trim();
            if (!s.isEmpty()) result.add(parseInt(s));
        }
        return result;
    }
}
