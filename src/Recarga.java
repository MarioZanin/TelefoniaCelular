import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
//Adquando a estrutura funcional com a estrutura de negócio 
// import java.util.Date;
class Recarga {
    private GregorianCalendar data;//Date data;
    private float valor;
    // Construtor - Adquando a estrutura funcional com a estrutura de negócio
    //public Recarga(Date data, float valor) {
    public Recarga(GregorianCalendar data, float valor) {
            this.data = data;
            this.valor = valor;
        }
    // Método para obter a data da recarga
    public GregorianCalendar getData() {
        return data;
    }
    // Método para obter o valor da recarga
    public float getValor() {
        return valor;
    }
    // Método toString para representação em String do objeto
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Data: " + sdf.format(data.getTime()) + ", Valor: R$ " + valor;
    }
}