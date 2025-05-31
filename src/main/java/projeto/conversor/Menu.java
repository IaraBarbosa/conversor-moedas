package projeto.conversor;

import projeto.conversor.clients.ExchangeRateAPIClient;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    public String exibeMenu() {
        return
        """
        *------------------------------------------------------------*
        |                    CONVERSOR DE MOEDA                      |
        |____________________________________________________________|
        |                                                            |
        |       1. Real Brasileiro  ->  Dólar Americano              |
        |       2. Coroa Norueguesa ->  Baht Tailandês               |
        |       3. Iene Japonês     ->  Dólar Canadense              |
        |       4. Yuan Chinês      ->  Peso Cubano                  |
        |       5. Libra Egípcia    ->  Libra Esterlina              |
        |       6. Ariary Malagasy  ->  Rand Sul-Africano            |
        |                                                            |
        |       7. Sair                                              |
        |____________________________________________________________|
        """;
    }

    public void processaOpcao() {
        String opcao = "";

        do {
            System.out.println(exibeMenu());
            System.out.print("Digite a opção: ");
            opcao = sc.next();

            switch (opcao) {
                case "1":
                    converteMoeda("BRL", "USD");
                    break;
                case "2":
                    converteMoeda("NOK", "THB");
                    break;
                case "3":
                    converteMoeda("JPY", "CAD");
                    break;
                case "4":
                    converteMoeda("CNY", "CUP");
                    break;
                case "5":
                    converteMoeda("EGP", "GBP");
                    break;
                case "6":
                    converteMoeda("MGA", "ZAR");
                    break;
                case "7":
                    sc.close();
                    System.out.println("Até Logo!");
                    break;
                default:
                    System.out.printf("Opção inválida! Selecione novamente. %n%n");
                    break;
            }
        }
        while (!opcao.equals("7"));
    }

    private void converteMoeda(String moeda1, String moeda2) {
        ExchangeRateAPIClient erac = new ExchangeRateAPIClient();

        double valor = 0.0;
        do {
            System.out.print("Digite o valor a ser convertido: ");
            if (sc.hasNextDouble()) {
                double entrada = sc.nextDouble();
                if (entrada >= 0.1) {
                    valor = entrada;
                }
                else {
                    System.out.printf("Valor inválido! Para a conversão, deve ser passado um número maior que zero. %n%n");
                }
            } else {
                System.out.printf("Valor inválido! Para a conversão, deve ser passado um número como no seguinte exemplo: 100,00. %n%n");
                sc.next();
            }
        } while (valor == 0.0);

        var conversao = erac.pairConversionCall(moeda1, moeda2, valor);
        if (conversao == null){
            System.out.printf("API indisponivel tente novamente em instantes! %n%n");
            return;
        }

        exibeResultado(moeda1, moeda2, valor, conversao.conversion_result());
    }

    private void exibeResultado(String moeda1, String moeda2, double valor, double conversao) {
        String moedaOrig = valor > 1 ? "moedas" : "moeda";
        String moedaFim = conversao > 1 ? "moedas" : "moeda";

        System.out.printf("A conversão de %.2f %s %s equivale a %.2f %s %s. %n%n",
                valor, moedaOrig, moeda1, conversao, moedaFim, moeda2);
    }
}
