package domain;

public class Produto {

    private Long id;  // O id continua como Long, pois o SERIAL no banco gera um valor Long
    private Integer codigo;  // Alterado para Integer, pois 'codigo' é INT no banco
    private String nome;
    private Double preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
