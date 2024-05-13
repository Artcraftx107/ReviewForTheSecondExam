package bus;

import java.util.Objects;

public class Parada {

    public final static double RADIO_TIERRA = 6378.137;

    private String nombre;
    private final double latitud;
    private final double longitud;

    public Parada(String nombre, double latitud, double longitud) {
        if (latitud < -90 || latitud > 90) {
            throw new BusException("La latitud tiene que estar dentro del intervalo [-90, 90].");
        }
        if (longitud < -180 || longitud > 180) {
            throw new BusException("La longitud debe estar dentro del intervalo [-180, 180].");
        }

        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
    public double distancia(Parada par){
        return Math.ceil(distanciaGeodesica(this, par)*1000)/1000;
    }
    public static double distanciaGeodesica(Parada p1, Parada p2){
        double ltRad1 = Math.toRadians(p1.latitud);
        double lgRad1 = Math.toRadians(p1.longitud);
        double ltRad2 = Math.toRadians(p2.latitud);
        double lgRad2 = Math.toRadians(p2.longitud);
        return RADIO_TIERRA * Math.acos(Math.cos(ltRad1) * Math.cos(ltRad2) * Math.cos(lgRad2 - lgRad1) + Math.sin(ltRad1) * Math.sin(ltRad2));
    }
    @Override
    public String toString() {
        return nombre.toUpperCase() + "(" + latitud + "," + longitud + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Parada p;
        boolean res =obj instanceof Parada;
        if(res){
             p = (Parada)obj;
        }else{
             p = null;
        }
        return res&&this.nombre.equalsIgnoreCase(p.getNombre())&&this.latitud==p.getLatitud()&&this.longitud==p.getLongitud();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nombre.toUpperCase(),this.longitud,this.latitud);
    }
}
