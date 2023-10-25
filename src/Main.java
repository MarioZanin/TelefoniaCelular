import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Telefonia telefonia = new Telefonia();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Assinante Pré-Pago");
            System.out.println("2 - Cadastrar Assinante Pós-Pago");
            System.out.println("3 - Listar Assinantes");
            System.out.println("4 - Fazer Chamada");
            System.out.println("5 - Fazer Recarga");
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
                    long cpfChamada = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Digite a duração da chamada em minutos: ");
                    int duracaoChamada = scanner.nextInt();
                    telefonia.fazerChamada(cpfChamada, new Date(), duracaoChamada);
                    break;
                case 5:
                    System.out.print("Digite o CPF do assinante: ");
                    long cpfRecarga = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Digite o valor da recarga: ");
                    float valorRecarga = scanner.nextFloat();
                    telefonia.fazerRecarga(cpfRecarga, new Date(), valorRecarga);
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
