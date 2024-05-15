package prRedSocialArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RedSocial {
    private List<Persona> personas;

    public RedSocial(){
        this.personas=new ArrayList<>();
    }
    public RedSocial(int tam){
        this.personas=new ArrayList<>(tam);
    }

    public void darAlta(String file) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                try {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    String mail = data[2];
                    Persona persona = new Persona(name, age, mail);
                    int found = buscar(persona);
                    if (found != -1) {
                        personas.add(persona);
                        System.out.println("Added: " + persona); // Add this line
                    }
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("La edad no ha podido pasarse a entero, revise la linea " + line);
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException("El fichero especificado no se ha encontrado");
        }
    }


    private int buscar(Persona persona) {
        int aux = 0;
        if(!personas.contains(persona)){
            aux=-1;
        }
        return aux;
    }

    public void darAlta(Persona persona){
        if(buscar(persona)!=-1){
            personas.add(persona);
        }else{
            System.err.println("La persona ya esta registrada en la red social");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Usuarios registrados:\n");
        for (Persona persona : personas) {
            sb.append(persona.toString()).append("\n");
        }
        return sb.toString();
    }


}
