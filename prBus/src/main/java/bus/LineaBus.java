package bus;

import java.util.ArrayList;

public class LineaBus {
    private String linea;
    private ArrayList<Parada> paradas;
    public LineaBus(String l){
        if(l.isEmpty()){
            throw new BusException("El nombre de la linea no puede estar vacio.");
        }else{
            this.linea=l;
            this.paradas = new ArrayList<>();
        }
    }
    public void agregar(Parada bruh){
        paradas.add(bruh);
    }
    public int agregarParadas(String[] datosParadas) {
        int contadorFormatoIncorrecto = 0;
        for (String dato : datosParadas) {
            // Dividimos cada string por "@" y luego por ","
            String[] partes = dato.split("@");
            if (partes.length == 2 && partes[1].contains(",")) {
                String[] coords = partes[1].split(",");
                if (coords.length == 2) {
                    try {
                        // Parseamos la latitud y longitud
                        double latitud = Double.parseDouble(coords[0]);
                        double longitud = Double.parseDouble(coords[1]);
                        try{
                            // Creamos un nuevo objeto Parada y lo añadimos a la lista paradas
                            Parada nuevaParada = new Parada(partes[0], latitud, longitud);
                            paradas.add(nuevaParada);
                        }catch (BusException e){
                            contadorFormatoIncorrecto++;
                        }

                    } catch (NumberFormatException e) {
                        contadorFormatoIncorrecto++;
                    }
                } else {
                    contadorFormatoIncorrecto++;
                }
            } else {
                contadorFormatoIncorrecto++;
            }
        }
        return contadorFormatoIncorrecto;
    }

    public ArrayList<Parada> paradasAlejadas(double dist){
        ArrayList<Parada> epic = new ArrayList<>();
        Parada paradaInicial = paradas.get(0);
        for(int i = 1; i<paradas.size(); i++){
            if(paradaInicial.distancia(paradas.get(i))>=dist){
                epic.add(paradas.get(i));
            }
        }
        return epic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<paradas.size(); i++){
            if(i+1 == paradas.size()){
                sb.append(paradas.get(i));
            }else {
                sb.append(paradas.get(i)).append(" -> ");
            }
        }
        return linea.toUpperCase()+": {["+sb+"]}";
    }

    public ArrayList<Parada> filtrarParadas(CriterioParadas criterio) {
        return criterio.seleccionar(paradas);
    }
}
