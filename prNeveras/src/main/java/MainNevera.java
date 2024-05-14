import neveras.*;

import java.io.IOException;

public class MainNevera {
    public static void main(String[] args) {
            Nevera nevera = new Nevera(2000.0);

            nevera.mete("A123", "tomate", new Fecha(20, 5, 2020), 200.2);
            nevera.mete("A124", "lechuga", new Fecha(20, 5, 2020), 150.0);
            nevera.mete("A124", "lechuga", new Fecha(26, 5, 2020), 180.0);
            nevera.mete("A126", "leche", new Fecha(24, 5, 2020), 1119.8);
            nevera.mete("A126", "maiz", new Fecha(20, 5, 2020), 350.0);

            System.out.println(nevera);

            nevera.saca("A124", new Fecha(26, 5, 2020), 100.0);

            System.out.println(nevera);

            nevera.saca("A124", new Fecha(20, 5, 2020), 70.0);

            System.out.println(nevera);

            nevera.mete("A124", "lechuga", new Fecha(30, 5, 2020), 260.0);

            System.out.println(nevera);

            System.out.println("A124anterior a 1/6/2020:" + nevera.getPeso("A124", new Fecha(1, 6, 2020)));

            Nevera nevera2 = new Nevera(500.0);
            nevera2.mete("A126", "maiz", new Fecha(24, 5, 2020), 299.8);
            nevera2.mete("A123", "tomate", new Fecha(24, 5, 2020), 200.2);

            System.out.println(nevera2);

            Nevera nevera3 = new Nevera(2000.0);
            nevera3.mete("A126", "leche", new Fecha(24, 5, 2020), 500.0);
            nevera3.mete("A123", "tomate", new Fecha(24, 5, 2020), 200.0);
            nevera3.mete("A124", "lechuga", new Fecha(24, 5, 2020), 180.0);

            System.out.println(nevera3);


    }
}