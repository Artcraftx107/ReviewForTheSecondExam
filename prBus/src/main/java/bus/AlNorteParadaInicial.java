package bus;

import java.util.ArrayList;

public class AlNorteParadaInicial implements CriterioParadas{
    @Override
    public ArrayList<Parada> seleccionar(ArrayList<Parada> paradas) {
        ArrayList<Parada> alNorte = new ArrayList<>();
        Parada p0 = paradas.get(0);
        for(int i = 1; i<paradas.size(); i++){
            if(paradas.get(i).getLatitud()>p0.getLatitud()){
                alNorte.add(paradas.get(i));
            }
        }
        return alNorte;
    }
}
