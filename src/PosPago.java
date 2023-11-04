//Adquando a estrutura funcional com a estrutura de negócio
//import java.util.Date;
import java.util.GregorianCalendar;
class PosPago extends Assinante {
    private float assinatura;

    // ***Construtor -Adquando a estrutura funcional com a estrutura de negócio***
    public PosPago(long cpf, String nome, String numero, int maxChamadas, float assinatura) {
        super(cpf, nome, numero, maxChamadas);
        this.assinatura = assinatura;        
    }
    // ***Método para imprimir a fatura de um determinado mês - Adquando a estrutura funcional com a estrutura de negócio***
    public void imprimirFatura(int mes) {
    System.out.println("Fatura do assinante pós-pago: " + super.toString());
    float totalChamadas = 0;
    for (Chamada chamada : super.getChamadas()) {
        if (chamada != null && chamada.getData().get(GregorianCalendar.MONTH) == mes) {
            totalChamadas += chamada.getDuracao() * 1.04; // Custo da chamada pós-paga é R$ 1,04 por minuto
            System.out.println(chamada);
        }
    }
    System.out.println("Total de chamadas: R$ " + totalChamadas);
    System.out.println("Assinatura: R$ " + assinatura);
    System.out.println("Total da fatura: R$ " + (assinatura - totalChamadas));
    }
}