package sisbiblioteca_v10;

public class Revista {
    private String nomeRevista;
    private String autor;
    private String ISSN;
    private String ano;
    private String editora;
    private String prateleira;
    private String secao;
    private String CDD;
    private int edicao;

    // Construtor da classe Revista
    public Revista(String nomeRevista, String autor, String ISSN, String ano, String editora, 
                   String prateleira, String secao, String CDD, int edicao) {
        this.nomeRevista = nomeRevista;
        this.autor = autor;
        this.ISSN = ISSN;
        this.ano = ano;
        this.editora = editora;
        this.prateleira = prateleira;
        this.secao = secao;
        this.CDD = CDD;
        this.edicao = edicao;
    }

    // Getters
    public String getNomeRevista() {
        return nomeRevista;
    }

    public String getAutor() {
        return autor;
    }

    public String getISSN() {
        return ISSN;
    }

    public String getAno() {
        return ano;
    }

    public String getEditora() {
        return editora;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public String getSecao() {
        return secao;
    }

    public String getCDD() {
        return CDD;
    }

    public int getEdicao() {
        return edicao;
    }

    // Setters
    public void setNomeRevista(String nomeRevista) {
        this.nomeRevista = nomeRevista;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public void setCDD(String CDD) {
        this.CDD = CDD;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
}
