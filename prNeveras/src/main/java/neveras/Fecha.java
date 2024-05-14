package neveras;

import java.util.Objects;

public class Fecha {
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

    public int compareTo(Fecha f) {
        if(this.anyo<f.anyo){
            return 1;
        } else if (this.anyo==f.anyo) {
            if(this.mes<f.mes){
                return 1;
            } else if (this.mes==f.mes) {
                if(this.dia<f.dia){
                    return 1;
                } else if (this.dia==f.dia) {
                    return 0;
                }else {
                    return -1;
                }
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
}
