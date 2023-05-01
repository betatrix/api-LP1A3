package br.com.ifsp.projetolinguagens.services;

import br.com.ifsp.projetolinguagens.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private List<Livro> livros = new ArrayList<>();

    //Cria algumas instâncias de livros quando o programa é executado para facilitar a visualizacao

    {
        Livro livro1 = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", "tralala", 1990, 20, 20, false);
        Livro livro2 = new Livro(2, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "tralalaaaa", 1997, 30, 10, true);
        livros.add(livro1);
        livros.add(livro2);
    }

    public Livro adicionarLivro(Livro livro) {
        livros.add(livro);
        return livro;
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public Livro buscarLivro(Integer id) {
        return livros.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void excluirLivro(Integer id) {
        livros.removeIf(l -> l.getId().equals(id));
    }


    public Livro alterarLivro(Integer id, Livro livro) {
        Livro livroAtualizado = buscarLivro(id);
        if (livroAtualizado == null) {
            return null;
        }
        livroAtualizado.setTitulo(livro.getTitulo());
        livroAtualizado.setAutor(livro.getAutor());
        livroAtualizado.setEditora(livro.getEditora());
        livroAtualizado.setAnoPublicacao(livro.getAnoPublicacao());
        livroAtualizado.setNumExemplares(livro.getNumExemplares());
        livroAtualizado.setNumExemplaresDisponiveis(livro.getNumExemplaresDisponiveis());
        livroAtualizado.setReservado(livro.isReservado());
        return livroAtualizado;
    }
}