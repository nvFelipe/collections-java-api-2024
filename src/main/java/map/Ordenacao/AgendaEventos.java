package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data,evento);
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventoTreeMap);
    }

    public void obterProximoEvento(){
       LocalDate dataAtual = LocalDate.now();
       LocalDate proximaData = null;
       Evento proximoEvento = null;
       //Criei um MAP, passando a data e a classe evento como chave e valor
        //chamei de eventosTreeMap e instanciei uma TreeMap com os
        //valores da minha HashMap eventosMap, assim, eu peguei as informa
        //ções da minha HashMap e organizei em ordem de data, pois a
        //TreeMap recebe os dados na ordem crescente.
       Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
       //com a minha lista de eventos em ordem eu posso pesquisar o proximo
        //evento com base na minha data atual.

        //para cada entry que é um MAP passando data e valor na evetosMaP
        //aplicando entrySet que me retorna um SET que consegue relacionar
        //a chave com o valor
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData =entry.getKey();
                proximoEvento =entry.getValue();
                System.out.println("O proximo evento: " + proximoEvento + "acontecerá na data" + proximaData);
                break;
            }

        }


    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2024,7,20),"Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY,21),"Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2023,1,20),"Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2021,10,20),"Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2020,Month.DECEMBER,25),"Evento 5", "Atração 5");


        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();


    }
}
