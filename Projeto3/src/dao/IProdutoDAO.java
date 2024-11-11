package dao;

import java.util.List;
import domain.Produto;

public interface IProdutoDAO {

    Integer cadastrar(Produto produto) throws Exception;

    Integer atualizar(Produto produto) throws Exception;

    Produto buscar(Integer codigo) throws Exception;  // Alterado para Integer

    Integer excluir(Produto produto) throws Exception;

    List<Produto> buscarTodos() throws Exception;
}
