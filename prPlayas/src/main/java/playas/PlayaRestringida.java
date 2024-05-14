package playas;

public class PlayaRestringida extends Playa{
    private int porcentaje;
    public PlayaRestringida(String n, String l, double lati, double longi, int aforo){
        super(n, l, lati, longi, aforo);
        this.porcentaje=0;
    }

    public void setPorcentaje(int porcentaje) {
        if(porcentaje<0||porcentaje>100){
            throw new PlayaException("El porcentaje no puede ser negativo ni superior a 100");
        }
        this.porcentaje = porcentaje;
    }

    @Override
    public void setNumPersonas(int numPersonas) {
        if(numPersonas<0){
            throw new PlayaException("El numero de personas no puede ser negativo");
        }else{
            if(0<numPersonas&&numPersonas<(25*porcentaje/100)){
                this.estado="LEVE";
            } else if ((25*porcentaje/100)<numPersonas&&numPersonas<(75*porcentaje/100)) {
                this.estado="MODERADO";
            } else if ((75*porcentaje/100<numPersonas&&numPersonas<porcentaje)) {
                this.estado="SATURADO";
            } else if (porcentaje<numPersonas) {
                this.estado="SIN ESPACIO";
            }else {
                this.estado="VACIO";
            }
        }
    }

    @Override
    public String toString() {
        return "["+super.toString()+", "+porcentaje+"%]";
    }
}
