package main.OperacoesBasicas.list;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    //atributo; é o atributo desta classe ListaTarefa
    private List<Tarefa> tarefaList;

    //construtor; controi um metodo ListaTarefa que cria uma nova ArrayList
    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    //metodo: é uma aplicação desta classe; adicionarTarefa. Cria uma descrição da classe Tarefa
    public void adicionarTarefa (String descricao){
        tarefaList.add(new Tarefa(descricao));
    }
    //metodo: removerTarefa
    public void removerTarefa(String descricao){
        //Criou uma LIST que contem TAREFA, chamou de tarefasParaRemover e criou um array para guarda-las
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        //iterou sobre cada elemento da lista usando um for
        for (Tarefa t : tarefaList){
            //Verificou se o elemento que esta sendo adicionado é igual a algum eelmento na lista
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                //se sim, adiciona o elemento repetido no lista para remover
                tarefasParaRemover.add(t);
            }
        }
        //deleta a lista de elementos para remover
        tarefaList.removeAll(tarefasParaRemover);
    }
    //metodo: obter numero total de tarefas, retornando o tamanho da lista com size
    public int obterNumeroTotalDeTarefas(){
        return tarefaList.size();
    }
    //Imprime a lista de tarefas
    public void obterDescricoesTarefas() {
        System.out.println(tarefaList);

    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();
        System.out.println("O número total de elementos da lista é: "+ listaTarefa.obterNumeroTotalDeTarefas()  );

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        System.out.println("O número total de elementos da lista é: "+ listaTarefa.obterNumeroTotalDeTarefas()  );

        listaTarefa.removerTarefa("Tarefa 2");
        System.out.println("O número total de elementos da lista é: "+ listaTarefa.obterNumeroTotalDeTarefas()  );
        listaTarefa.obterDescricoesTarefas();
    }
}
