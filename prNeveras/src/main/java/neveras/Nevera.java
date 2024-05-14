package neveras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        return totalPeso;
    }

    public void mete(String c, String n, Fecha f, double p){
        if(c.isEmpty()||n.isEmpty()||f==null||p<0){
            throw new IllegalArgumentException("Los argumentos introducidos son invalidos");
        }else{
            
        }
    }


}
