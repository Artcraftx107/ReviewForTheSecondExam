package neveras;

import java.util.Objects;

public class Producto {
    private String codigo;
    private String nombre;
    private Fecha fechaCaducidad;

    public Producto(String c, String n, Fecha f){
        if(c.isEmpty()||n.isEmpty()||f==null){
            throw new IllegalArgumentException("Argumentos introducidos no vaidos");
        }else{
            this.codigo=c.toUpperCase();
            this.nombre=n;
            this.fechaCaducidad=f;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Fecha getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Fecha fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo) && Objects.equals(fechaCaducidad, producto.fechaCaducidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, fechaCaducidad);
    }

    @Override
    public String toString() {
        return nombre+": "+codigo+": "+fechaCaducidad;
    }
}
