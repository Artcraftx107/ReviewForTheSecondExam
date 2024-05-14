package playas;

public class Playa {
    private String name;
    private String location;
    private final double latitud;
    private final double longitud;
    private final int aforoMax;
    private int numPersonas;
    protected String estado;

    public Playa(String n, String l, double lati, double longi, int aforoBruh){
        if(n.isEmpty() || l.isEmpty() || aforoBruh<0){
            throw new PlayaException("Uno de los valores especificados no es correcto");
        }else{
            this.name=n;
            this.location=l;
            this.latitud=lati;
            this.longitud=longi;
            this.aforoMax=aforoBruh;
            this.estado="VACIO";
            this.numPersonas=0;
        }
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public int getAforoMax() {
        return aforoMax;
    }

    public String getEstado() {
        return estado;
    }

    public void setNumPersonas(int numPersonas) {
        if(numPersonas<0){
            throw new PlayaException("El numero de personas no puede ser negativo");
        }else{
            if(0<numPersonas&&numPersonas<(0.25*aforoMax)){
                this.estado="LEVE"; 
            } else if ((0.25*aforoMax)<numPersonas&&numPersonas<(0.75*aforoMax)) {
                this.estado="MODERADO";
            } else if ((0.75*aforoMax<numPersonas&&numPersonas<aforoMax)) {
                this.estado="SATURADO";
            } else if (aforoMax<numPersonas) {
                this.estado="SIN ESPACIO";
            }else {
                this.estado="VACIO";
            }
            this.numPersonas=numPersonas;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Playa playa = (Playa) obj;
        return Double.compare(playa.latitud, this.latitud) == 0 &&
                Double.compare(playa.longitud, this.longitud) == 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode()+location.hashCode();
    }

    @Override
    public String toString() {
        return "("+name+", "+location+", "+latitud+", "+longitud+", "+aforoMax+", "+numPersonas+", "+estado+")";
    }
}
