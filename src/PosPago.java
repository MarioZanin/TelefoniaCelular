import java.util.Date;

class PosPago extends Assinante {
    private long cpf;
    private String nome;
    private int numero;
    private float assinatura;
   
    // Construtor
    public PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero, assinatura)
        this.assinatura = assinatura;        
    }

    public float getassinatura(float assinatura){
        return assinatura;
    }

    public void setassinatura(){
        this.assinatura = assinatura;
    }

    // Método para fazer uma chamada
    public void fazerChamada(Date data, int duracao) {
        this.data = data;
        this.duracao = duracao;
        
    }

    // Método para imprimir a fatura de um determinado mês
    public void imprimirFatura(int mes) {
        this.mes = mes;        
    }
}