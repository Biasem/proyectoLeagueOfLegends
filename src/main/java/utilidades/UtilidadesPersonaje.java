package utilidades;

import modelos.Escalabilidad;
import modelos.Personaje;
import modelos.Region;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesPersonaje {

    //Que recibiendo un personaje aumente su nivel en 1, actualizando
    //todas sus estadísticas según su escalabilidad.
    public Personaje levelUp(Personaje personaje){
        if (personaje.getNivel()<18) {
            personaje.setNivel(personaje.getNivel() + 1);
            personaje.setAtaqueBase(personaje.getAtaqueBase() + personaje.getEscalabilidad().getIncrementoDanioNivel() * personaje.getNivel());
            personaje.setDefensaBase(personaje.getDefensaBase() + personaje.getEscalabilidad().getIncrementoDefensaNivel() * personaje.getNivel());
            personaje.setManaBase(personaje.getManaBase() + personaje.getEscalabilidad().getIncrementoManaNivel() * personaje.getNivel());
            personaje.setVidaBase(personaje.getVidaBase() + personaje.getEscalabilidad().getIncrementoSaludNivel() * personaje.getNivel());
        }
            return personaje;
    }

    //Que a partir de un listado de personajes devuelve un mapa de los
    //personajes agrupados por región.
    public Map<Region,List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes){

        return personajes.stream().collect(Collectors.groupingBy(p-> p.getRegion()));
    }

    //A partir de una lista de personajes, devuelve el personaje más
    //poderoso.
    public Personaje getMasPoderoso(List<Personaje> personaje){
        Personaje poderoso = new Personaje();
        for (Personaje perso :personaje){
            while(perso.getNivel()<18){
                levelUp(perso);
            }
            if (poderoso.getNivel()==null){
                poderoso = perso;
            }
            if((perso.getAtaque()+ perso.getDefensa()+perso.getMana()+perso.getVida())>
               (perso.getAtaque())+poderoso.getDefensa()+ poderoso.getMana()+ poderoso.getVida()){
                poderoso = perso;
            }
        }
        return poderoso;
    }



}
