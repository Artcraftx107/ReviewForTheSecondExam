import bus.*;
public class PruebasAdicionales {
    public static void main(String[] args) {
// Se crea una línea de autobús, denominada Línea 11
        LineaBus linea11 = new LineaBus("Línea 11");

        // Array con datos (obsérvese que dos de ellos son incorrectos)
        String[] datos = {
                "Playa Virginia@36.71869,-4.34",
                "Elcano@136.71869,-4.34",
                "Echeverría@36.72181,-4.36351",
                "Pedregalejo@36.72248,-4.37685",
                "Baños del Carmen@36.72248",
                "Paseo del Parque@36.71884,-4.41910",
                "Puente de las Américas@36.71755,-4.43903",
                "Louis Pasteur@36.71654,-4.47508"
        };

        // Se agregan las paradas del array datos,
        // y se imprime el número de datos erróneos
        System.out.println("Paradas con datos erróneos: " +
                linea11.agregarParadas(datos));

        // Se imprime en pantalla la linea 11
        System.out.println(linea11);

        // Se define una referencia al criterio a aplicar
        CriterioParadas criterio;

        // Se considera como criterio un objeto de la clase DistanciaMinima,
        // donde la distancia es 5
        criterio = new DistanciaMinima(5);
        // Se seleccionan e imprimen las paradas que distan, de la parada inicial, menos de 5 km
        System.out.println(linea11.filtrarParadas(criterio));

        // Se considera como criterio un objeto de la clase AlNorte
        criterio = new AlNorteParadaInicial();
        // Se seleccionan e imprimen las paradas que se sitúan al norte de laparada inicial
        System.out.println(linea11.filtrarParadas(criterio));
    }
}

/* SALIDA DEL PROGRAMA DE PRUEBAS
Paradas con datos erróneos: 2
LÍNEA 11: {PLAYA VIRGINIA(36.71869,-4.34) -> ECHEVERRÍA(36.72181,-4.36351) ->
PEDREGALEJO(36.72248,-4.37685) -> PASEO DEL PARQUE(36.71884,-4.4191) ->
PUENTE DE LAS AMÉRICAS(36.71755,-4.43903) -> LOUIS PASTEUR(36.71654,
4.47508)}
[PASEO DEL PARQUE(36.71884,-4.4191), PUENTE DE LAS AMÉRICAS(36.71755,
4.43903), LOUIS PASTEUR(36.71654,-4.47508)]
[ECHEVERRÍA(36.72181,-4.36351), PEDREGALEJO(36.72248,-4.37685), PASEO
DEL PARQUE(36.71884,-4.4191)]
*/

