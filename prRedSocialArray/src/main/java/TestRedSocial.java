import prRedSocialArray.*;

import java.io.IOException;

public class TestRedSocial {
    public static void main(String[] args) {
        // Test darAlta method with file input
        RedSocial redSocial = new RedSocial();
        try {
            redSocial.darAlta("input.txt");
            System.out.println("Usuarios dados de alta desde archivo:");
            System.out.println(redSocial);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test darAlta method with individual Persona objects
        RedSocialRestringida redSocialRestringida = new RedSocialRestringida(new RestriccionNombre('A'));
        Persona persona1 = new Persona("John Doe", 30, "john@example.com");
        Persona persona2 = new Persona("Alice Smith", 25, "alice@example.com");
        Persona persona3 = new Persona("Bob Brown", 35, "bob@example.com");

        redSocialRestringida.darAlta(persona1); // Should be rejected due to name restriction
        redSocialRestringida.darAlta(persona2); // Should be accepted
        redSocialRestringida.darAlta(persona3); // Should be accepted

        System.out.println("\nUsuarios dados de alta individualmente:");
        System.out.println(redSocialRestringida);
    }
}

