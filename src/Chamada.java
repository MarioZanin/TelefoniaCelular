//Adquando a estrutura funcional com a estrutura de negócio
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
class Chamada {
    private GregorianCalendar data;
    private int duracao;
    // Construtor
    public Chamada(GregorianCalendar data, int duracao) {
        this.data = data;
        this.duracao = duracao;
        
    }
    // Método para obter a data da chamada
    public GregorianCalendar getData() {
        return data;
    }
    // Método para obter a duração da chamada
    public int getDuracao() {
        return duracao;
    }
    // Método toString para representação em String do objeto
    @Override
    public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return "Data: " + sdf.format(data.getTime()) + ", Duração: " + duracao + " minutos";
    }
}