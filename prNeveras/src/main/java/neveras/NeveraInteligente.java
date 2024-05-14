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

    public SortedMap<Fecha, Set<Producto>> productosConFechaAnterior(Fecha f) {
        SortedMap<Fecha, Set<Producto>> productosAnteriores = new TreeMap<>();
        for (Map.Entry<Producto, Double> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            if (producto.getFechaCaducidad().compareTo(f) < 0) {
                Fecha fechaCaducidad = producto.getFechaCaducidad();
                Set<Producto> productosExpirados = productosAnteriores.getOrDefault(fechaCaducidad, new HashSet<>());
                productosExpirados.add(producto);
                productosAnteriores.put(fechaCaducidad, productosExpirados);
            }
        }

        return productosAnteriores;
    }
}