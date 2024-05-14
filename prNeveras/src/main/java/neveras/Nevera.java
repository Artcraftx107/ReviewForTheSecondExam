package neveras;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Nevera {
    private double ocupacion;
    private double capacidad;
    protected Map<Producto, Double> productos;

    public Nevera(double cap){
        if(cap<0){
            throw new IllegalArgumentException("la capacidad de la nevera no puede ser negativa");
        }else{
            this.capacidad=cap;
            this.productos=new HashMap<>();
        }
    }
    public Nevera(double cap, String file) throws IOException {
        if(cap<0){
            throw new IllegalArgumentException("la capacidad de la nevera no puede ser negativa");
        }else {
            this.capacidad=cap;
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String linea;
                while ((linea= br.readLine())!=null){
                    try {
                        String[] data = linea.split(":");
                        String[] date = data[3].split(":");
                        int dia = Integer.parseInt(date[0]);
                        int mes = Integer.parseInt(date[1]);
                        int anyo = Integer.parseInt(date[2]);
                        double peso = Double.parseDouble(data[2]);
                        Producto productoAux = new Producto(data[0], data[1], new Fecha(dia, mes, anyo));
                        if (productos != null) {
                            productos.put(productoAux, peso);
                        }
                    }catch (NumberFormatException e){
                        System.err.println("Error al procesar la linea "+linea);
                    }

                }
            }catch (IOException e){
                throw new FileNotFoundException("The file specified was not found");
            }
        }
    }

    public Map<Producto, Double> getProductos() {
        return productos;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public double getDisponible() {
        return capacidad-ocupacion;
    }

    public double getPeso(String n, Fecha f){
        double totalPeso = 0;
        for(Map.Entry<Producto, Double> entry : productos.entrySet()){
            Producto producto = entry.getKey();
            if(producto.getCodigo().equalsIgnoreCase(n)&&producto.getFechaCaducidad().compareTo(f)==-1){
                totalPeso+=entry.getValue();
            }
        }
        this.ocupacion=totalPeso;
        return totalPeso;
    }

    public void mete(String c, String n, Fecha f, double p){
        if(c.isEmpty()||n.isEmpty()||f==null||p<0){
            throw new IllegalArgumentException("Los argumentos introducidos son invalidos");
        }else{
            Producto sergiBruh = new Producto(c, n, f);
            if(productos.isEmpty()||!productos.containsKey(sergiBruh)){
                if(this.ocupacion+p>this.capacidad){
                    double epicMonkey = this.capacidad-this.ocupacion;
                    productos.put(sergiBruh, epicMonkey);
                }else{
                    productos.put(sergiBruh, p);
                    this.ocupacion+=p;
                }
            }else{
                if(this.ocupacion+p>this.capacidad){
                    double farded = this.capacidad-this.ocupacion;
                    productos.replace(sergiBruh, productos.get(sergiBruh).doubleValue(), farded+productos.get(sergiBruh).doubleValue());
                    this.ocupacion+=farded;
                }else{
                    productos.replace(sergiBruh, productos.get(sergiBruh).doubleValue(),p+productos.get(sergiBruh).doubleValue());
                    this.ocupacion+=p;
                }
            }
        }
    }

    public void saca(String c, Fecha f, double p){
        if(p<0){
            throw new IllegalArgumentException("El valor indicado no es correcto ("+p+")");
        }
        for(Map.Entry<Producto, Double> entry : productos.entrySet()){
            Producto obsequio = entry.getKey();
            if(obsequio.getCodigo().equalsIgnoreCase(c)&&obsequio.getFechaCaducidad().equals(f)){
                if(productos.get(obsequio).doubleValue()-p <0){
                    throw new IllegalArgumentException("El valor resultante de sacar el peso p no es valido");
                } else if (productos.get(obsequio).doubleValue()-p==0) {
                    productos.remove(obsequio);
                    if(productos.isEmpty()){
                        throw new IllegalArgumentException("La nevera no puede estar vacia");
                    }
                }else{
                    productos.replace(obsequio, productos.get(obsequio).doubleValue(), productos.get(obsequio).doubleValue()-p);
                    this.ocupacion-=p;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ocupacion).append(" / ").append(capacidad).append(": [");

        for (Map.Entry<Producto, Double> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            Double peso = entry.getValue();

            sb.append("[")
                    .append(producto.toString())
                    .append(" (")
                    .append(peso)
                    .append(")], ");
        }

        // Quita la ultima coma y el espacio
        if (!productos.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
        return sb.toString();
    }
}
