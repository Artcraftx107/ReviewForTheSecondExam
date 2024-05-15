package prRedSocialArray;

public class RestriccionEdad implements TipoRestriccion {
    private int edad;
    public RestriccionEdad(int x){
        if(x<0){
            throw new IllegalArgumentException("La edad minima requerida no puede ser negativa");
        }else{
            this.edad=x;
        }
    }

    @Override
    public boolean valida(Persona persona) {
        boolean valid = false;
        if(persona.getEdad()>edad){
            valid=true;
        }
        return valid;
    }
}
