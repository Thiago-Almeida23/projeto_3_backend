import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;

public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Before
    public void setUp() throws Exception {
        clienteDAO = new ClienteDAO();
    }

    @Test
    public void cadastrarTest() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Rodrigo Pires");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);  // Verifica se o cliente foi cadastrado com sucesso

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);  // Verifica se o cliente foi encontrado no banco
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);  // Exclui o cliente
        assertTrue(countDel == 1);  // Verifica se o cliente foi excluído com sucesso
    }

    @Test
    public void buscarTest() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Rodrigo Pires");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Rodrigo Pires");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("10");
        cliente1.setNome("Rodrigo Pires");
        Integer countCad1 = clienteDAO.cadastrar(cliente1);
        assertTrue(countCad1 == 1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("20");
        cliente2.setNome("Teste");
        Integer countCad2 = clienteDAO.cadastrar(cliente2);
        assertTrue(countCad2 == 1);

        List<Cliente> list = clienteDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);  // Exclui todos os clientes da lista
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = clienteDAO.buscarTodos();
        assertEquals(0, list.size());  // Verifica se não há mais clientes
    }

    @Test
    public void atualizarTest() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Rodrigo Pires");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("20");
        clienteBD.setNome("Outro nome");
        Integer countUpdate = clienteDAO.atualizar(clienteBD);
        assertTrue(countUpdate == 1);

        Cliente clienteBD1 = clienteDAO.buscar("10");
        assertNull(clienteBD1);  // Verifica se o cliente com código "10" foi atualizado

        Cliente clienteBD2 = clienteDAO.buscar("20");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);  // Exclui todos os clientes da lista
        }
    }
}

