package playas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestionPlayas {
    private static int CAP_INICIAL = 5;
    private final String provincia;
    private int numPlayas;
    private Playa[] playas;

    public GestionPlayas(String n){
        if(n.isEmpty()){
            throw new PlayaException("Este campo no puede estar vacio");
        }else{
            this.provincia=n;
            playas = new Playa[CAP_INICIAL];
        }
    }

    public GestionPlayas(String n, String[] bg3){
        if(n.isEmpty()){
            throw new PlayaException("Este campo no puede estar vacio");
        } else if (bg3==null) {
            throw new PlayaException("El array introducido no puede estar vacio");
        }else{
            this.provincia=n;
            playas= new Playa[CAP_INICIAL];
            for (String s : bg3) {
                String[] data = s.split(";");
                if (data.length != 5) {
                    System.err.println("Faltan datos para crear una playa");
                } else {
                    try {
                        double latitud = Double.parseDouble(data[2]);
                        double longitud = Double.parseDouble(data[3]);
                        int aforo = Integer.parseInt(data[4]);
                        if (aforo < 0) {
                            System.err.println("ERROR: Aforo negativo");
                        }
                        Playa aux = new Playa(data[0], data[1], latitud, longitud, aforo);
                        incluye(aux);
                    } catch (NumberFormatException e) {
                        System.err.println("ERROR: Valor no numerico");
                    }
                }
            }
        }
    }

    public void incluye(Playa aux) {
        int pos = posicion(aux);
        if (pos != -1) {
            playas[pos] = aux;
        } else {
            if (numPlayas == CAP_INICIAL) {
                CAP_INICIAL *= 2;
            }
            Playa[] bruh = new Playa[CAP_INICIAL];
            if (numPlayas >= 0) System.arraycopy(playas, 0, bruh, 0, numPlayas);
            this.playas = bruh;
            playas[numPlayas++] = aux;
        }
    }

    private int posicion(Playa aux) {
        for (int pos = 0; pos < numPlayas; pos++) {
            if (playas[pos] != null && playas[pos].equals(aux)) {
                return pos;
            }
        }
        return -1;
    }

    private Playa buscar(double lati, double longi) {
        Playa aux = new Playa("Aux", "Aux", lati, longi, 0);
        int pos = posicion(aux);
        if (pos != -1) {
            aux = playas[pos];
        } else {
            // Check if it's a PlayaRestringida
            for (Playa playa : playas) {
                if (playa instanceof PlayaRestringida) {
                    PlayaRestringida pr = (PlayaRestringida) playa;
                    if (pr.getLatitud() == lati && pr.getLongitud() == longi) {
                        return pr;
                    }
                }
            }
            throw new PlayaException("La playa buscada no está en el array");
        }
        return aux;
    }


    public void registrarOcupacion(String lol) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(lol))){
            String line;
            while((line = br.readLine())!=null){
                String[] parts = line.split(";");
                if(parts.length!=3){
                    System.err.println("Error: Datos incorrectos en la linea "+line);
                }
                try {
                    double latitud = Double.parseDouble(parts[0]);
                    double longitud = Double.parseDouble(parts[1]);
                    int newPersonas = Integer.parseInt(parts[2]);
                    Playa aux = buscar(latitud, longitud);
                    int pos = posicion(aux);
                    playas[pos].setNumPersonas(newPersonas);
                }catch (NumberFormatException e){
                    System.err.println("Error al procesar la linea "+line);
                }
            }
        }
    }

    public Playa primeraPlayaConEstado(String est){
        for(int pos = 0; pos < numPlayas; pos++) {
            if (playas[pos] != null && est.equalsIgnoreCase(playas[pos].getEstado())) {
                return playas[pos];
            }
        }
        throw new PlayaException("No hay ninguna playa con el estado indicado en el array");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Playa playa : playas){
            if(playa != null) {
                sb.append(playa).append(", ");
            }
        }
        if(sb.length()>2){
            sb.setLength(sb.length()-2);
        }
        return this.provincia+" Playas: ["+sb+"]";
    }
}

