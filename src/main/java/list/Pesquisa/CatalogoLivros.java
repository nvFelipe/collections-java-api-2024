package main.java.list.Pesquisa;
import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livrosList;

    public CatalogoLivros() {
        this.livrosList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livrosList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        // Criando uma lista com Livros de mesmo autor
        List<Livro> livrosPorAutor = new ArrayList<>();
        //verificando se a lista está vazia:(Se a livroList for diferente(!) de isEmptu())
        if(!livrosList.isEmpty()){
            //laço para passar ipor cada um dos elementos da lista
            for(Livro l : livrosList){
                //se o livro l getAutor (traz o nome do autor for equalsIgnoreCase (igual) ao autor
                if(l.getAutor().equalsIgnoreCase(autor)){
                    //caso positivo, a array livrosPorAutor addiciona (add) ao livro l
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        // Criando uma lista com Livros por intervalo de ano
        List<Livro> livrosrPorIntervaloAnos = new ArrayList<>();
        //verificando se a lista está vazia:(Se a livroList for diferente(!) de isEmptu())
        if(!livrosList.isEmpty()){
            //laço para passar ipor cada um dos elementos da lista
            for(Livro l : livrosList) {
                //se o livro l getAnoPublicacao (ano de publicação do livro for maior que o ano inicial e menos do que o ano final:
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao()<= anoFinal){
                    //adiciona o livro no array livros por intervalos de anos
                    livrosrPorIntervaloAnos.add(l);
                }
            }
        }
        return livrosrPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo){
        //Como só tenho que retornar o primeiro livro encontrado, o retorno deste método é Livro
        //Como ainda não possuo nenhum objeto do tipo Livro, defino como null
        Livro livroPorTitulo = null;
        //se a livrosList não está vazia
        if(!livrosList.isEmpty()){
            //laço para passar ipor cada um dos elementos da lista
            for(Livro l: livrosList){
                //se o livro l getTitulo é igual ao titulo do livro do parametro
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    //adiciono o livro l na variavel livroPorTitulo
                    livroPorTitulo =l;
                    //para encerrar o laço
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1","Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 1","Autor 2", 2021);
        catalogoLivros.adicionarLivro("Livro 2","Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3","Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4","Autor 4", 1194);

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 4"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2020, 2021));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));

    }

}
