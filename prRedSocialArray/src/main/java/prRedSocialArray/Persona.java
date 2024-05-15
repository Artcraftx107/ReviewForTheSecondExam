package prRedSocialArray;

import java.util.Objects;

public class Persona {
    private String nombre;
    private int edad;
    private String email;

    public Persona(String n, int e, String em){
        if(n.isBlank() || em.isEmpty() || e<=0){
            throw new RedSocialException("Datos incorrectos");
        }else{
            this.nombre=n;
            this.edad=e;
            this.email=em;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return this.getNombre()+" "+this.getEdad()+" ("+this.getEmail()+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return this.nombre.equalsIgnoreCase(persona.nombre)&&this.email.equalsIgnoreCase(persona.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, email);
    }
}
