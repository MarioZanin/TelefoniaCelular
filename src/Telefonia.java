//import java.util.Scanner;
//class Telefonia {
//    private PrePago[] prePagos;
//    private PosPago[] posPagos;
//    private int numPrePagos;
//    private int numPosPagos;
    // Construtor
//    public Telefonia() {
//    }
    // Método para cadastrar um novo assinante Pré-Pago e Pós-Pago
//    public void cadastrarAssinantes() {
//    }
    // Método para listar todos os assinantes
//    public void listarAssinantes() {
//    }
   // Método para fazer uma chamada
//    public void fazerChamada() {
//    }
    // Método para fazer uma recarga
//    public void fazerRecarga() {
//    }
    // Método para imprimir faturas de todos os assinantes
//    public void imprimirFaturas() {
//    }
//    public static void main(String[] args) {
//}
import java.util.Scanner;
import java.util.Date;

class Telefonia {
    private static final int MAX_PREPAGOS = 50; // Número máximo de assinantes pré-pagos
    private static final int MAX_POSPAGOS = 50; // Número máximo de assinantes pós-pagos
    
    private PrePago[] prePagos;
    private PosPago[] posPagos;
    private int numPrePagos;
    private int numPosPagos;

    // Construtor
    public Telefonia() {
        this.prePagos = new PrePago[MAX_PREPAGOS];
        this.posPagos = new PosPago[MAX_POSPAGOS];
        this.numPrePagos = 0;
        this.numPosPagos = 0;
    }

    // Método para cadastrar um novo assinante Pré-Pago
    public void cadastrarPrePago(long cpf, String nome, int numero) {
        if (numPrePagos < MAX_PREPAGOS) {
            prePagos[numPrePagos] = new PrePago(cpf, nome, numero);
            numPrePagos++;
            System.out.println("Assinante Pré-Pago cadastrado com sucesso!");
        } else {
            System.out.println("Limite máximo de assinantes Pré-Pagos atingido.");
        }
    }

    // Método para cadastrar um novo assinante Pós-Pago
    public void cadastrarPosPago(long cpf, String nome, int numero, float assinatura) {
        if (numPosPagos < MAX_POSPAGOS) {
            posPagos[numPosPagos] = new PosPago(cpf, nome, numero, assinatura);
            numPosPagos++;
            System.out.println("Assinante Pós-Pago cadastrado com sucesso!");
        } else {
            System.out.println("Limite máximo de assinantes Pós-Pagos atingido.");
        }
    }

    // Método para listar todos os assinantes
    public void listarAssinantes() {
        System.out.println("Assinantes Pré-Pagos:");
        for (int i = 0; i < numPrePagos; i++) {
            System.out.println(prePagos[i]);
        }

        System.out.println("Assinantes Pós-Pagos:");
        for (int i = 0; i < numPosPagos; i++) {
            System.out.println(posPagos[i]);
        }
    }
    // Método para fazer uma chamada
    public void fazerChamada(long cpf, Date data, int duracao) {
        boolean found = false;
        for (int i = 0; i < numPrePagos; i++) {
            if (prePagos[i].getCpf() == cpf) {
                float custo = prePagos[i].fazerChamada(data, duracao);
                System.out.println("Custo da chamada: R$" + custo);
                found = true;
                break;
            }
        }

        if (!found) {
            for (int i = 0; i < numPosPagos; i++) {
                if (posPagos[i].getCpf() == cpf) {
                    posPagos[i].fazerChamada(data, duracao);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Assinante não encontrado.");
        }
    }

    // Método para fazer uma recarga
    public void fazerRecarga(long cpf, Date data, float valor) {
        boolean found = false;
        for (int i = 0; i < numPrePagos; i++) {
            if (prePagos[i].getCpf() == cpf) {
                prePagos[i].recarga(data, valor);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Assinante não encontrado.");
        }
    }

    // Método para imprimir faturas de todos os assinantes
    public void imprimirFaturas() {
        System.out.println("Faturas dos Assinantes Pré-Pagos:");
        for (int i = 0; i < numPrePagos; i++) {
            System.out.println("CPF: " + prePagos[i].getCpf() + ", Nome: " + prePagos[i].getNome());
            System.out.println("Saldo Restante: R$" + prePagos[i].getCredito());
            System.out.println("--------------------");
        }

        System.out.println("Faturas dos Assinantes Pós-Pagos:");
        for (int i = 0; i < numPosPagos; i++) {
            System.out.println("CPF: " + posPagos[i].getCpf() + ", Nome: " + posPagos[i].getNome());
            System.out.println("Valor da Assinatura: R$" + posPagos[i].getAssinatura());
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        Telefonia telefonia = new Telefonia();
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("Menu:");
			    System.out.println("1 - Cadastrar Assinante Pré-Pago");
			    System.out.println("2 - Cadastrar Assinante Pós-Pago");
			    System.out.println("3 - Listar Assinantes");
			    System.out.println("4 - Fazer Recarga");
			    System.out.println("5 - Fazer Chamada");
			    System.out.println("6 - Imprimir Faturas");
			    System.out.println("0 - Sair");
			    System.out.print("Escolha uma opção: ");

			    int escolha = scanner.nextInt();
			    scanner.nextLine(); // Limpar o buffer do scanner

			    switch (escolha) {
			        case 1:
			            System.out.print("Digite o CPF: ");
			            long cpfPrePago = scanner.nextLong();
			            scanner.nextLine(); // Limpar o buffer do scanner
			            System.out.print("Digite o nome: ");
			            String nomePrePago = scanner.nextLine();
			            System.out.print("Digite o número: ");
			            int numeroPrePago = scanner.nextInt();
			            telefonia.cadastrarPrePago(cpfPrePago, nomePrePago, numeroPrePago);
			            break;
			        case 2:
			            System.out.print("Digite o CPF: ");
			            long cpfPosPago = scanner.nextLong();
			            scanner.nextLine(); // Limpar o buffer do scanner
			            System.out.print("Digite o nome: ");
			            String nomePosPago = scanner.nextLine();
			            System.out.print("Digite o número: ");
			            int numeroPosPago = scanner.nextInt();
			            System.out.print("Digite o valor da assinatura: ");
			            float assinatura = scanner.nextFloat();
			            telefonia.cadastrarPosPago(cpfPosPago, nomePosPago, numeroPosPago, assinatura);
			            break;
			        case 3:
			            telefonia.listarAssinantes();
			            break;
			        case 4:
			            System.out.print("Digite o CPF do assinante: ");
			            long cpfRecarga = scanner.nextLong();
			            scanner.nextLine(); // Limpar o buffer do scanner
			            System.out.print("Digite o valor da recarga: ");
			            float valorRecarga = scanner.nextFloat();
			            telefonia.fazerRecarga(cpfRecarga, new Date(), valorRecarga);
			            break;
			        case 5:
			            System.out.print("Digite o CPF do assinante: ");
			            long cpfChamada = scanner.nextLong();
			            scanner.nextLine(); // Limpar o buffer do scanner
			            System.out.print("Digite a duração da chamada em minutos: ");
			            int duracaoChamada = scanner.nextInt();
			            telefonia.fazerChamada(cpfChamada, new Date(), duracaoChamada);
			            break;    
			        case 6:
			            telefonia.imprimirFaturas();
			            break;
			        case 0:
			            System.out.println("Saindo do programa.");
			            System.exit(0);
			            break;
			        default:
			            System.out.println("Opção inválida. Tente novamente.");
			    }
			}
		}
    }
}     