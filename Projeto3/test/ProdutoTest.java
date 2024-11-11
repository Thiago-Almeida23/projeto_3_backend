import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.ProdutoDAO;
import dao.IProdutoDAO;
import domain.Produto;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Before
    public void setUp() throws Exception {
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrarTest() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo(Integer.valueOf("100"));
        produto.setNome("Produto A");
        produto.setPreco(19.99);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar(Integer.valueOf("100"));
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco(), 0.01);

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo(Integer.valueOf("100"));
        produto.setNome("Produto A");
        produto.setPreco(19.99);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar(Integer.valueOf("100"));
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco(), 0.01);

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo(Integer.valueOf("100"));
        produto.setNome("Produto A");
        produto.setPreco(19.99);
        produtoDAO.cadastrar(produto);

        Produto produtoBD = produtoDAO.buscar(Integer.valueOf("100"));
        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);

        Produto produtoDel = produtoDAO.buscar(Integer.valueOf("100"));
        assertNull(produtoDel);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo(Integer.valueOf("100"));
        produto.setNome("Produto A");
        produto.setPreco(19.99);
        produtoDAO.cadastrar(produto);

        List<Produto> lista = produtoDAO.buscarTodos();
        assertTrue(lista.size() > 0);
    }

    @Test
    public void atualizarTest() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo(Integer.valueOf("100"));
        produto.setNome("Produto A");
        produto.setPreco(19.99);
        produtoDAO.cadastrar(produto);

        produto.setNome("Produto Atualizado");
        produto.setPreco(29.99);
        Integer countUpd = produtoDAO.atualizar(produto);
        assertTrue(countUpd == 1);

        Produto produtoBD = produtoDAO.buscar(Integer.valueOf("100"));
        assertNotNull(produtoBD);
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco(), 0.01);

        produtoDAO.excluir(produtoBD);
    }
}
