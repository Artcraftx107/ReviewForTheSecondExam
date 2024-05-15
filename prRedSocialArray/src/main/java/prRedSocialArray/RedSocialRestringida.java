package prRedSocialArray;

public class RedSocialRestringida extends RedSocial {
    private TipoRestriccion restriccion;
    public RedSocialRestringida(TipoRestriccion tipoRestriccion){
        super();
        this.restriccion=tipoRestriccion;
    }

    @Override
    public void darAlta(Persona persona) {
        if(restriccion.valida(persona)){
            super.darAlta(persona);
        }else{
            System.err.println("La informacion de la persona no esta permitida");
        }
    }
}
