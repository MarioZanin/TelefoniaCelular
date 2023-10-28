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
        this.credito = 0.0f;//criando estrutura para adicionar os créditos
        this.numRecarga = 0;//criando estrutura para cálcular o número de recargas 
        
    }

    // Método para realizar uma recarga
    public void recarga(Date data, float valor) {
        //this.data = data;
        //this.valor = valor;
        //Gerar a relação com os créditos feitos
        this.credito += valor;
        this.numRecargas ++;

    }

    // Método para fazer uma chamada
    public float fazerChamada(Date data, int duracao) {
       // return this.data = data;
       // return this.duracao = duracao;
       float custoChamada = duracao * 1.04f; // Assumindo um custo de R$ 1.04 por minuto
       if (credito >= custoChamada) {
           credito -= custoChamada;
           System.out.println("Chamada realizada em " + data + " com duração de " + duracao + " minutos. Custo: R$" + custoChamada);
       } else {
           System.out.println("Saldo insuficiente para realizar a chamada em " + data);
           custoChamada = 0; // A chamada não é completada devido ao saldo insuficiente
       }
       // Os println serão chamadas quando da execução do main na classe Telefonia
       return custoChamada;
    }

    // Método para imprimir a fatura de um determinado mês
    public void imprimirFatura(int mes) {
        this.mes = mes;
       
    }
    //inserindo os Get para serem aplicados na classe
    public long getCpf() {
		// TODO Auto-generated method stub
		return cpf;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	public float getCredito() {
		// TODO Auto-generated method stub
		return credito;
	}
    @Override
    public String toString() {
        return "Pré-Pago [CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero + ", Crédito: R$" + credito + "]";
    }
}
