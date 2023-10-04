package map.evento;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos(){
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEventos(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);

        eventosMap.put(data, evento);
    }

    // public void exibirAgenda(){
    //    Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
    // }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        
    }

}
