package prRedSocialArray;

public class RestriccionNombre implements TipoRestriccion{
    private char letra;
    public RestriccionNombre(char x){
        this.letra=x;
    }

    @Override
    public boolean valida(Persona persona) {
        boolean valido = false;
        if(!persona.getNombre().contains(Character.toString(letra))){
            valido=true;
        }
        return valido;
    }
}
