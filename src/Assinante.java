//Adquando a estrutura funcional com a estrutura de negócio 
import java.util.GregorianCalendar;
class Assinante {
    private long cpf;
    private String nome;
    private String numero;
    private Chamada[] chamadas;
    private int numChamadas;
    // * Construtor *
    public Assinante(long cpf, String nome,  String numero, int maxChamadas) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[maxChamadas];
    //  this.creditos = 0;
        this.numChamadas = 0;
    }
    // * Método para obter o CPF *
    public long getCpf() {
        return cpf;
    }
   // public void setCpf(long cpf) {
   //     this.cpf = cpf;
   // }
   // public String getNome() {
   //     return nome;
   // }
   // public void setNome(String nome) {
   //     this.nome = nome;
   // }
   // public int getNumero() {
   //     return numero;
   // }
   // public void setNumero(int numero) {
   //     this.numero = numero;
   // }
   //public float getCreditos() {
   //    return creditos;
   //}
   //public void setCreditos(float creditos) {
   //    this.creditos = creditos;
   //}
   //public int getNumRecargas() {
   //    return numRecargas;
   //}
   //public void setNumRecargas(int numRecargas) {
   //    this.numRecargas = numRecargas;
   //}
   // * Método toString para representação em String do objeto *
    @Override
    public String toString() {
   //      return "Assinante{" +"cpf=" + cpf + ", nome='" + nome + '\'' +", numero=" + numero +", creditos=" + creditos +", numRecargas=" + numRecargas +'}';
        return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
    }
    // * Relacionar e Contabilizar Chamada com os Assinantes *
    public void fazerChamada(GregorianCalendar data, int duracao) {
        if (numChamadas < chamadas.length) {
            chamadas[numChamadas] = new Chamada(data, duracao);
            numChamadas++;
        } else {
            System.out.println("Limite de chamadas atingido para este assinante.");
        }
    }
   // * Contador Chamada *
    public Chamada[] getChamadas() {
        return chamadas;
    }
}