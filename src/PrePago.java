import java.util.Date;

class PrePago {
    private long cpf;
    private String nome;
    private int numero;
    private float credito;
    private int numRecargas;

    // Construtor
    public PrePago(long cpf, String nome, int numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        
    }

    // Método para realizar uma recarga
    public void recarga(Date data, float valor) {
        this.data = data;
        this.valor = valor;
        
    }

    // Método para fazer uma chamada
    public float fazerChamada(Date data, int duracao) {
        return this.data = data;
        return this.duracao = duracao;
        
    }

    // Método para imprimir a fatura de um determinado mês
    public void imprimirFatura(int mes) {
        this.mes = mes;
       
    }
}
