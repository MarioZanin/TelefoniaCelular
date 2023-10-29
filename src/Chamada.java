import java.util.Date;

class Chamada {
    private Date data;
    private int duracao;

    // Construtor
    public Chamada(Date data, int duracao) {
        this.data = data;
        this.duracao = duracao;
        
    }

    // Método para obter a data da chamada
    public Date getData() {
        return this.data = data;
       
    }

    public void setData(Date data){
        this.data = data;

    }

    // Método para obter a duração da chamada
    public int getDuracao() {
        return this.duracao = duracao;
    }

    public int setDuracao(){
        this.duracao = duracao;
    }

    // Método toString para representação em String do objeto
    public String toString() {
        return "Chamada [data=" + data + "duracao" +duracao+ "]";
       
    }
}
