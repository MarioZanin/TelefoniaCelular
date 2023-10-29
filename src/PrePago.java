import java.util.Date;

class PrePago extends Assinante{
    private float credito;
    private int numRecargas;

    // Construtor
    public PrePago(long cpf, String nome, int numero) {
        super(cpf,nome,numero);
        this.credito = 0;
        this.numRecargas = 0;
    }

    public float getcredito(float credito){
        return credito;
    }

    public void setcredito(){
        this.credito = credito;
    }

    public int getnumrecargas(int numRecargas){
        return numRecargas;
    }

    public void setnumrecargas(){
        thi.numRecargas = numRecargas;
    }

    // Método para realizar uma recarga
    public void recarga(Date data, float valor, int numRecargas) {
        if (valor <= 0){
            throw new Exception("O valor da recarga deve ser maior que 0");
        }

        this.creditos += valor;
        this.numRecargas++; 
    }
    

    // Método para fazer uma chamada
    public float fazerChamada(Date data, int duracao) throws Exception {
        float valorChamada = duracao * 0.5;
        if (this.creditos < valorChamada) {
            throw new Exception("Saldo insuficiente");
        }

        this.creditos -= valorChamada;

        float valorChamadaReal = calcularValorChamada(data, duracao);
        return valorChamadaReal;
    }

    // Método para imprimir a fatura de um determinado mês
    public void imprimirFatura(int mes) {
        this.mes = mes;
       
    }
}
