import bus.BusException;
import bus.Parada;

public class PruebaParada {
    public static void main(String[] args){
        Parada p1 = new Parada("Paseo del Parque", 36.71884, -4.41910);
        Parada p2 = new Parada("paseo del parque", 36.71884, -4.41910);
        System.out.println(p1);
        System.out.println(p2);
        if(p1.equals(p2)){
            System.out.println("Las paradas son iguales");
        }else{
            System.out.println("Las paradas son distintas");
        }
        try{
            Parada p3 = new Parada("Louis Pasteur", 36.71654, -184.47508);
        }catch (BusException e){
            System.err.println(e.getMessage());
        }
    }
}
