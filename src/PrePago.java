//Adquando a estrutura funcional com a estrutura de negócio
//import java.util.Date;
import java.util.GregorianCalendar;
class PrePago extends Assinante{
    private Recarga[] recargas;
    private float creditos;
    private int numRecargas;
    // Construtor
    public PrePago(long cpf, String nome, String numero, int maxChamadas, int maxRecargas) {
        super(cpf,nome,numero, maxChamadas);
        this.recargas = new Recarga[maxRecargas];
        this.creditos = 0;
        this.numRecargas = 0;
    }
    //Adquando a estrutura funcional com a estrutura de negócio
    //public float getcredito(float credito){
    //    return credito;
    //}
    //public void setcredito(){
    //    this.credito = credito;
    //}
    //public int getnumrecargas(int numRecargas){
    //  return numRecargas;
    //}
    //public void setnumrecargas(){
    //  thi.numRecargas = numRecargas;
    //}
    // * Método para realizar uma recarga - Adquando a estrutura funcional com a estrutura de negócio *
    //public void recarga(Date data, float valor, int numRecargas) {
    //throw new Exception("O valor da recarga deve ser maior que 0");
    //}
    //this.creditos += valor;
    //this.numRecargas++;
    //}
    public void recarregar(GregorianCalendar data, float valor) {
        if (numRecargas < recargas.length) {
            recargas[numRecargas] = new Recarga(data, valor);
            numRecargas++;
            creditos += valor;
        } else {
            System.out.println("Limite de recargas atingido para este assinante.");
        }
    }
    public float getCreditos() {
        return creditos;
    }
    // ****Método para fazer uma chamada - Este método é lançado na classe Assinante que, com a classe telefonia
    //realiza uma busca pelo CPF e computa todas as chamadas feitas, tanto para os assinantes no sistema de
    //Pré-Pagos como para os Pós-Pagos.****
    //public float fazerChamada(Date data, int duracao) throws Exception {
    //    float valorChamada = duracao * 0.5;
    //    if (this.creditos < valorChamada) {
    //        throw new Exception("Saldo insuficiente");
    //    }
    //    this.creditos -= valorChamada;
    //    float valorChamadaReal = calcularValorChamada(data, duracao);
    //    return valorChamadaReal;
    //}
    // **** Método para imprimir a fatura de um determinado mês - Adquando a estrutura funcional com a estrutura de negócio ****
    public void imprimirFatura(int mes) {
    //    this.mes = mes;
        System.out.println("Fatura do assinante pré-pago: " + super.toString());
        float totalChamadas = 0;
        for (Chamada chamada : super.getChamadas()) {
            if (chamada != null && chamada.getData().get(GregorianCalendar.MONTH) == mes) {
                totalChamadas += chamada.getDuracao() * 1.04; // Custo da chamada pré-paga é R$ 1,04 por minuto
                System.out.println(chamada);
            }
        }
        System.out.println("Total de chamadas: R$ " + totalChamadas);
        System.out.println("Recargas:");
        float totalRecargas = 0;
        for (Recarga recarga : recargas) {
            if (recarga != null && recarga.getData().get(GregorianCalendar.MONTH) == mes) {
                totalRecargas += recarga.getValor();
                System.out.println(recarga);
            }
        }
        System.out.println("Total de recargas: R$ " + totalRecargas);
        System.out.println("Saldo atual: R$ " + (creditos - totalChamadas));
    }
}