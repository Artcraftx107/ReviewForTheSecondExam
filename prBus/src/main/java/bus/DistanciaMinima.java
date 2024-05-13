package bus;

import java.util.ArrayList;

public class DistanciaMinima implements CriterioParadas{
    private final double distancia;
    public DistanciaMinima(double bruh){
        if(bruh<0){
            throw new BusException("La distancia minima no puede ser menor que 0");
        }else{
            this.distancia=bruh;
        }
    }

    @Override
    public ArrayList<Parada> seleccionar(ArrayList<Parada> paradas) {
        ArrayList<Parada> fueraDeDist = new ArrayList<>();
        Parada aux = paradas.get(0);
        for(int i = 1; i<paradas.size(); i++){
            if(aux.distancia(paradas.get(i))>this.distancia){
                fueraDeDist.add(paradas.get(i));
            }
        }
        return fueraDeDist;
    }
}
