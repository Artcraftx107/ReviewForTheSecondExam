import playas.*;

public class TestPlaya {
    public static void main(String[] args) {
        // Test Playa class
        Playa playa1 = new Playa("Playa 1", "Location 1", 40.0, 30.0, 100);
        Playa playa2 = new Playa("Playa 2", "Location 2", 41.0, 31.0, 150);

        // Test PlayaRestringida class
        PlayaRestringida playaRestringida = new PlayaRestringida("Playa 3", "Location 3", 42.0, 32.0, 200);
        playaRestringida.setPorcentaje(50);

        // Test GestionPlayas class
        GestionPlayas gestionPlayas = new GestionPlayas("Province 1");

        // Adding Playa objects to gestionPlayas
        gestionPlayas.incluye(playa1);
        gestionPlayas.incluye(playa2);
        gestionPlayas.incluye(playaRestringida);

        // Test registrarOcupacion method
        try {
            gestionPlayas.registrarOcupacion("file.txt"); // Assuming file.txt contains data in the format "latitude;longitude;numPersons"
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test primeraPlayaConEstado method
        try {
            Playa playaWithState = gestionPlayas.primeraPlayaConEstado("MODERADO");
            System.out.println("Playa with state MODERADO: " + playaWithState);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test toString method of GestionPlayas class
        System.out.println(gestionPlayas);
    }
}

