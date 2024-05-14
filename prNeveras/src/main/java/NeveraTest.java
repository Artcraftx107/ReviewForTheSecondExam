import neveras.Nevera;
import neveras.Fecha;

public class NeveraTest {
    public static void main(String[] args) {
        // Create a Nevera object with a capacity of 50
        Nevera nevera = new Nevera(50);

        // Add products to the fridge
        nevera.mete("A123", "Apple", new Fecha(1, 1, 2025), 10);
        nevera.mete("B456", "Banana", new Fecha(2, 2, 2025), 15);
        nevera.mete("C789", "Orange", new Fecha(3, 3, 2025), 20);

        // Print the contents of the fridge
        System.out.println("Fridge contents after adding products:");
        System.out.println(nevera);

        // Remove a product from the fridge
        nevera.saca("B456", new Fecha(2, 2, 2025), 5);

        // Print the contents of the fridge after removal
        System.out.println("Fridge contents after removing a product:");
        System.out.println(nevera);
    }
}

