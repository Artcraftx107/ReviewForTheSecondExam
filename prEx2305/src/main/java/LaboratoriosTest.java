import ex2305.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LaboratoriosTest {
    public static void main(String[] args) {
        // Create Laboratorios object
        Laboratorios laboratorios = new Laboratorios(3);

        // Add some Solicitud objects for testing
        laboratorios.addSolicitud("POO-A;1;3");
        laboratorios.addSolicitud("POO-B;1;3");
        laboratorios.addSolicitud("POO-A;2;1");
        laboratorios.addSolicitud("TEC-A;1;3");
        // Add more solicitudes and errors as needed...

        // Add some errors for testing
        laboratorios.addSolicitud("Web-B;1;3");
        // Add more errors as needed...

        // Print output to console and file
        laboratorios.asignarLabs();
        System.out.println(laboratorios);

        // Print output to file
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.println(laboratorios);
            System.out.println("Output written to 'output.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

