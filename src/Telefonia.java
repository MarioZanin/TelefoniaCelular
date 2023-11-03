import java.util.Scanner;
//import java.util.Date;
import java.util.GregorianCalendar;
class Telefonia {
   // private static final int MAX_PREPAGOS = 50; // Número máximo de assinantes pré-pagos
   // private static final int MAX_POSPAGOS = 50; // Número máximo de assinantes pós-pagos
   // Adquando a estrutura funcional com a estrutura de negócio 
    private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;
    // Construtor -  Adquando a estrutura funcional com a estrutura de negócio 
    public Telefonia(int maxPrePagos, int maxPosPagos, int maxChamadas, int maxRecargas) {
        this.prePagos = new PrePago[maxPrePagos];
        this.numPrePagos = 0;
        this.posPagos = new PosPago[maxPosPagos];
        this.numPosPagos = 0;
    }
    // Método para cadastrar assinante - Adquando a estrutura funcional com a estrutura de negócio 
    // Método para cadastrar um novo assinante Pré-Pago
    //public void cadastrarPrePago(long cpf, String nome, int numero) {
    //    if (numPrePagos < MAX_PREPAGOS) {
    //        prePagos[numPrePagos] = new PrePago(cpf, nome, numero);
    //        numPrePagos++;
    //        System.out.println("Assinante Pré-Pago cadastrado com sucesso!");
    //    } else {
    //        System.out.println("Limite máximo de assinantes Pré-Pagos atingido.");
    //    }
    //}
    // Método para cadastrar um novo assinante Pós-Pago
    //public void cadastrarPosPago(long cpf, String nome, int numero, float assinatura) {
    //    if (numPosPagos < MAX_POSPAGOS) {
    //        posPagos[numPosPagos] = new PosPago(cpf, nome, numero, assinatura);
    //        numPosPagos++;
    //        System.out.println("Assinante Pós-Pago cadastrado com sucesso!");
    //    } else {
    //        System.out.println("Limite máximo de assinantes Pós-Pagos atingido.");
    //    }
    //}
    public void cadastrarAssinante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tipo de assinante (1 para Pré-pago, 2 para Pós-pago): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o CPF do assinante: ");
        long cpf = scanner.nextLong();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o nome do assinante: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o número do assinante: ");
        String numero = scanner.nextLine();

        if (tipo == 1 && numPrePagos < prePagos.length) {
            prePagos[numPrePagos] = new PrePago(cpf, nome, numero, 100, 50); // Exemplo de limite de 100 chamadas e 50 recargas
            numPrePagos++;
            System.out.println("Assinante pré-pago cadastrado com sucesso!");
        } else if (tipo == 2 && numPosPagos < posPagos.length) {
            posPagos[numPosPagos] = new PosPago(cpf, nome, numero, 100, 150); // Exemplo de limite de 100 chamadas e assinatura de R$ 150
            numPosPagos++;
            System.out.println("Assinante pós-pago cadastrado com sucesso!");
        } else {
            System.out.println("Limite de assinantes atingido para este tipo.");
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
    // Método para fazer uma chamada - Adquando a estrutura funcional com a estrutura de negócio 
    //public void fazerChamada(long cpf, Date data, int duracao) {
    //    boolean found = false;
    //    for (int i = 0; i < numPrePagos; i++) {
    //        if (prePagos[i].getCpf() == cpf) {
    //            float custo = prePagos[i].fazerChamada(data, duracao);
    //            System.out.println("Custo da chamada: R$" + custo);
    //            found = true;
    //            break;
    //        }
    //    }
    //        if (!found) {
    //        for (int i = 0; i < numPosPagos; i++) {
    //            if (posPagos[i].getCpf() == cpf) {
    //                posPagos[i].fazerChamada(data, duracao);
    //                found = true;
    //                break;
    //            }
    //        }
    //    }
    //    if (!found) {
    //        System.out.println("Assinante não encontrado.");
    //    }
    //}
    public void fazerChamada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo do assinante (1 para Pré-pago, 2 para Pós-pago): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o CPF do assinante: ");
        long cpf = scanner.nextLong();
        scanner.nextLine(); // Limpar o buffer
        Assinante assinante = null;
        if (tipo == 1) {
            assinante = localizarPrePago(cpf);
        } else if (tipo == 2) {
            assinante = localizarPosPago(cpf);
        }
        if (assinante != null) {
            System.out.println("Digite a data da chamada (formato DD/MM/YYYY): ");
            String dataStr = scanner.nextLine();
            System.out.println("Digite a duração da chamada em minutos: ");
            int duracao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            String[] dataSplit = dataStr.split("/");
            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1])-1; // Janeiro é representado por 0 no Calendar
            int ano = Integer.parseInt(dataSplit[2]);
            GregorianCalendar data = new GregorianCalendar(ano, mes, dia);
            assinante.fazerChamada(data, duracao);
            System.out.println("Chamada registrada com sucesso!");
        } else {
            System.out.println("Assinante não encontrado.");
        }
    }
    // Método para fazer uma recarga - Adquando a estrutura funcional com a estrutura de negócio 
    //public void fazerRecarga(long cpf, Date data, float valor) {
    //    boolean found = false;
    //    for (int i = 0; i < numPrePagos; i++) {
    //        if (prePagos[i].getCpf() == cpf) {
    //            prePagos[i].recarga(data, valor);
    //            found = true;
    //            break;
    //        }
    //    }
    //    if (!found) {
    //        System.out.println("Assinante não encontrado.");
    //    }
    //}
    public void fazerRecarga() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante pré-pago para recarga: ");
        long cpf = scanner.nextLong();
        scanner.nextLine(); // Limpar o buffer
        PrePago assinante = localizarPrePago(cpf);
        if (assinante != null) {
            System.out.println("Digite a data da recarga (formato DD/MM/YYYY): ");
            String dataStr = scanner.nextLine();
            System.out.println("Digite o valor da recarga: ");
            float valor = scanner.nextFloat();
            scanner.nextLine(); // Limpar o buffer
            String[] dataSplit = dataStr.split("/");
            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1])-1;// Janeiro é representado por 0 no Calendar
            int ano = Integer.parseInt(dataSplit[2]);
            GregorianCalendar data = new GregorianCalendar(ano, mes, dia);
            assinante.recarregar(data, valor);
            System.out.println("Recarga realizada com sucesso!");
        } else {
            System.out.println("Assinante pré-pago não encontrado.");
        }
    }
    private PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (prePagos[i].getCpf() == cpf) {
                return prePagos[i];
            }
        }
        return null;
    }
    private PosPago localizarPosPago(long cpf) {
        for (int i = 0; i < numPosPagos; i++) {
            if (posPagos[i].getCpf() == cpf) {
                return posPagos[i];
            }
        }
        return null;
    }
    // Método para imprimir faturas de todos os assinantes - Adquando a estrutura funcional com a estrutura de negócio 
    //public void imprimirFaturas() {
    //    System.out.println("Faturas dos Assinantes Pré-Pagos:");
    //    for (int i = 0; i < numPrePagos; i++) {
    //        System.out.println("CPF: " + prePagos[i].getCpf() + ", Nome: " + prePagos[i].getNome());
    //        System.out.println("Saldo Restante: R$" + prePagos[i].getCredito());
    //        System.out.println("--------------------");
    //    }
    //    System.out.println("Faturas dos Assinantes Pós-Pagos:");
    //    for (int i = 0; i < numPosPagos; i++) {
    //        System.out.println("CPF: " + posPagos[i].getCpf() + ", Nome: " + posPagos[i].getNome());
    //        System.out.println("Valor da Assinatura: R$" + posPagos[i].getAssinatura());
    //        System.out.println("--------------------");
    //    }
    //}
public void imprimirFaturas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do mês de consumo para imprimir as faturas (1 para janeiro, 2 para fevereiro, etc.): ");
        int mes = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Faturas do mês " + mes + ":");
        imprimirFaturasPrePagos(mes);
        imprimirFaturasPosPagos(mes);
    }
    private void imprimirFaturasPrePagos(int mes) {
        System.out.println("Faturas dos assinantes pré-pagos:");
        for (int i = 0; i < numPrePagos; i++) {
            PrePago assinante = prePagos[i];
            if (assinante != null) {
                System.out.println("Assinante: " + assinante.getCpf());
                assinante.imprimirFatura(mes);
                System.out.println("--------------------------");
            }
        }
    }
    private void imprimirFaturasPosPagos(int mes) {
        System.out.println("Faturas dos assinantes pós-pagos:");
        for (int i = 0; i < numPosPagos; i++) {
            PosPago assinante = posPagos[i];
            if (assinante != null) {
                System.out.println("Assinante: " + assinante.getCpf());
                assinante.imprimirFatura(mes);
                System.out.println("--------------------------");
            }
        }
    }
    public static void main(String[] args) {
    // Adquando a estrutura funcional com a estrutura de negócio 
    //    Telefonia telefonia = new Telefonia();
    //    try (Scanner scanner = new Scanner(System.in)) {
	//		while (true) {
        Telefonia telefonia = new Telefonia(100, 100, 100, 50);
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
			System.out.println("Menu:");
	//		System.out.println("1 - Cadastrar Assinante Pré-Pago");
	//		System.out.println("2 - Cadastrar Assinante Pós-Pago");
            System.out.println("1. Cadastrar Assinante");
            System.out.println("2 - Listar Assinantes");
			System.out.println("3 - Fazer Recarga");
			System.out.println("4 - Fazer Chamada");
			System.out.println("5 - Imprimir Faturas");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
    //		int escolha = scanner.nextInt();
            opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner
			switch (opcao) {
			case 1:
	//		System.out.print("Digite o CPF: ");
	//		long cpfPrePago = scanner.nextLong();
	//		scanner.nextLine(); // Limpar o buffer do scanner
	//		System.out.print("Digite o nome: ");
	//		String nomePrePago = scanner.nextLine();
	//		System.out.print("Digite o número: ");
	//		int numeroPrePago = scanner.nextInt();
	//		telefonia.cadastrarPrePago(cpfPrePago, nomePrePago, numeroPrePago);
            telefonia.cadastrarAssinante();
            break;
			case 2:
	//		System.out.print("Digite o CPF: ");
	//		long cpfPosPago = scanner.nextLong();
	//		scanner.nextLine(); // Limpar o buffer do scanner
	//		System.out.print("Digite o nome: ");
	//		String nomePosPago = scanner.nextLine();
	//		System.out.print("Digite o número: ");
	//		int numeroPosPago = scanner.nextInt();
	//		System.out.print("Digite o valor da assinatura: ");
	//		float assinatura = scanner.nextFloat();
	//		telefonia.cadastrarPosPago(cpfPosPago, nomePosPago, numeroPosPago, assinatura);
            telefonia.listarAssinantes();
            break;
			case 3:
	//		telefonia.listarAssinantes();
            telefonia.fazerRecarga();
			break;
			case 4:
	//		System.out.print("Digite o CPF do assinante: ");
	//		long cpfRecarga = scanner.nextLong();
	//		scanner.nextLine(); // Limpar o buffer do scanner
	//		System.out.print("Digite o valor da recarga: ");
	//		float valorRecarga = scanner.nextFloat();
	//		telefonia.fazerRecarga(cpfRecarga, new Date(), valorRecarga);
            telefonia.fazerChamada();
            break;
	//		case 5:
	//		System.out.print("Digite o CPF do assinante: ");
	//		long cpfChamada = scanner.nextLong();
	//		scanner.nextLine(); // Limpar o buffer do scanner
	//		System.out.print("Digite a duração da chamada em minutos: ");
	//		int duracaoChamada = scanner.nextInt();
	//		telefonia.fazerChamada(cpfChamada, new Date(), duracaoChamada);
	//		break;
    //		case 6:
            case 5:
			telefonia.imprimirFaturas();
			break;
			case 0:
			System.out.println("Saindo do programa.");
	//		System.exit(0);
			break;
			default:
			System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 0);
	}
}