import neveras.*;

import java.util.Set;
import java.util.SortedMap;

public class MainNeveraInteligente {
    public static void main(String[] args) {
        // Creating a new intelligent fridge with a capacity of 2000.0
        NeveraInteligente nevera = new NeveraInteligente(2000.0);

        // Adding products to the fridge
        try {
            nevera.mete("A123", "tomate", new Fecha(20, 5, 2020), 200.2);
            nevera.mete("A124", "carne", new Fecha(20, 5, 2020), 150.0);
            nevera.mete("A124", "lechuga", new Fecha(26, 5, 2020), 180.0);
            nevera.mete("A126", "leche", new Fecha(24, 5, 2020), 1119.8);
            nevera.mete("A126", "maiz", new Fecha(20, 5, 2020), 350.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding products to the fridge: " + e.getMessage());
        }

        // Printing the fridge contents after adding products
        System.out.println("Fridge contents after adding products:");
        System.out.println(nevera);

        // Removing a product from the fridge
        try {
            nevera.saca("A124", new Fecha(26, 5, 2020), 80.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error removing product from the fridge: " + e.getMessage());
        }

        // Printing the fridge contents after removing a product
        System.out.println("Fridge contents after removing a product:");
        System.out.println(nevera);

        // Printing products with expiration dates before 26/5/2020
        System.out.println("Productos con fecha anterior a 26/5/2020:");
        SortedMap<Fecha, Set<Producto>> productosAnteriores = nevera.productosConFechaAnterior(new Fecha(26, 5, 2020));
        System.out.println(productosAnteriores);
    }
}
