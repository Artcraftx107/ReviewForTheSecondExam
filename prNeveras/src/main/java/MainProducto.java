import neveras.Fecha;
import neveras.Producto;

public class MainProducto {
    public static void main(String[] args) {
        // Create Fecha instances
        Fecha fecha1 = new Fecha(26, 5, 2020);
        Fecha fecha2 = new Fecha(26, 5, 2020);
        Fecha fecha3 = new Fecha(20, 5, 2020);

        // Create Producto instances
        Producto queso = new Producto("A123", "queso", fecha1);
        Producto tomate = new Producto("A124", "tomate", fecha2);
        Producto tomateRallado = new Producto("A124", "tomate rallado", fecha2);

        // Test equality
        System.out.println("Los productos " + queso + " y " + tomate + " no son iguales");
        System.out.println("Los productos " + tomate + " y " + tomateRallado + " son iguales");
        System.out.println("Los productos " + queso + " y " + tomateRallado + " no son iguales");
        System.out.println("Los productos " + tomate + " y " + tomateRallado + " no son iguales");

        // Exception test
        try {
            // This should throw IllegalArgumentException
            Producto invalidProduct = new Producto("", "", null);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

        try {
            // This should throw IllegalArgumentException
            Fecha invalidFecha = new Fecha(-1, 5, 2020);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}

