package neveras;

import java.io.IOException;
import java.util.*;

public class NeveraInteligente extends Nevera{
    public NeveraInteligente(double d){
        super(d);
    }
    public NeveraInteligente(double f, String file) throws IOException {
        super(f, file);
    }

    public SortedMap<Fecha, Set<Producto>> productosConFechaAnterior(Fecha f){
        SortedMap<Fecha, Set<Producto>> productosAnteriores = new TreeMap<>();

        for (Map.Entry<Producto, Double> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            Fecha fechaCaducidad = producto.getFechaCaducidad();

            // Check if the expiration date is before the specified date 'f'
            if (fechaCaducidad.compareTo(f) < 0) {
                // Get the set of products with the same expiration date
                Set<Producto> productosSet = productosAnteriores.getOrDefault(fechaCaducidad, new HashSet<>());

                // Add the current product to the set
                productosSet.add(producto);

                // Update the map entry with the set of products
                productosAnteriores.put(fechaCaducidad, productosSet);
            }
        }

        return productosAnteriores;
    }
}