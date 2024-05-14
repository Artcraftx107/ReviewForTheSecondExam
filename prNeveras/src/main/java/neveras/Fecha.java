package neveras;

import java.util.Objects;

public class Fecha implements Comparable<Fecha>{
    private int dia;
    private int mes;
    private int anyo;

    public Fecha(int d, int m, int a){
        if(d<0||d>31||m<1||12<m){
            throw new IllegalArgumentException("Argumentos especificados fuera de rango");
        }else{
            this.dia=d;
            this.mes=m;
            this.anyo=a;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha = (Fecha) o;
        return dia == fecha.dia && mes == fecha.mes && anyo == fecha.anyo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, anyo);
    }

    @Override
    public String toString() {
        return this.dia+"/"+this.mes+"/"+this.anyo;
    }

    @Override
    public int compareTo(Fecha otraFecha) {
        if (this.anyo != otraFecha.anyo) {
            return Integer.compare(this.anyo, otraFecha.anyo);
        } else if (this.mes != otraFecha.mes) {
            return Integer.compare(this.mes, otraFecha.mes);
        } else {
            return Integer.compare(this.dia, otraFecha.dia);
        }
    }
}
