import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int resposta;
        do {
            // Indicando as possiveis escolhas do usuário!
            System.out.println("1. Soma");
            System.out.println("2. Subtracao");
            System.out.println("3. Divisao");
            System.out.println("4. Faixa etária");
            System.out.println("5. Numeros primos");
            System.out.println("6. Mudança de Base");
            System.out.println("7. Sair\n\n");
            System.out.println("Entre com a opcao: ");
            // Utilizando o scanner par receber o valor e já o convertendo para int
            resposta = sc.nextInt();

            // Estrutura que define qual função chamar, dependendo da escolha
            switch (resposta) {
                case 1:
                    soma();
                    break;
                case 2:
                    subtracao();
                    break;
                case 3:
                    divisao();
                    break;
                case 4:
                    faixaEtaria();
                    break;
                case 5:
                    numeroPrimo();
                    break;
                case 6:
                    mudancaBase();
                    break;
            }
            // Estrutura de repetição que continuará funcionando
            // enquanto a resposta for diferente de SAIR (7)
        } while (resposta != 7);
    }

    private static void soma() {
        try {
            System.out.println("\nEntre com o primeiro numero: ");
            // Recebe o primeiro numero
            // Double pois o usuário pode entrar com um numero com casa decimal
            double numeroUm = sc.nextDouble();
            
            System.out.println("\nEntre com o segundo numero: ");
            // Recebe o segundo numero
            // Double pois o usuário pode entrar com um numero com casa decimal
            double numeroDois = sc.nextDouble();
    
            // Realiza a soma dos valores
            double soma = numeroUm + numeroDois;
            System.out.println("\nA soma resultou em: " + soma);
    
            // Estrutura usuada para pausar momentaneamente o programa
            System.out.println("\nEnter para continuar....: ");
            sc.nextLine();
        } catch (Exception e) {
            // Exception que proteje o programa caso o usuario entre 
            // com um texto diferente de um numero
            System.out.println("\n\nEntrada inválida!\n" + e.getMessage());
        }
    }

    private static void subtracao() {
        try {
            System.out.println("\nEntre com o primeiro numero: ");
            // Recebe o primeiro numero
            // Double pois o usuário pode entrar com um numero com casa decimal
            double numeroUm = sc.nextDouble();
            
            System.out.println("\nEntre com o segundo numero: ");
            // Recebe o segundo numero
            // Double pois o usuário pode entrar com um numero com casa decimal
            double numeroDois = sc.nextDouble();
    
            // Realiza a subtração dos valores
            double subtracao = numeroUm - numeroDois;
            System.out.println("\nA subtração resultou em: " + subtracao);
    
            // Estrutura usuada para pausar momentaneamente o programa
            System.out.println("\nEnter para continuar....: ");
            sc.nextLine();
        } catch (Exception e) {
            // Exception que proteje o programa caso o usuario entre 
            // com um texto diferente de um numero
            System.out.println("\n\nEntrada inválida!\n" + e.getMessage());
        }
    }

    private static void divisao() {
        try {
            System.out.println("\nEntre com o primeiro numero: ");
            // Recebe o primeiro numero
            // Double pois o usuário pode entrar com um numero com casa decimal
            double numeroUm = sc.nextDouble();
            
            System.out.println("\nEntre com o segundo numero: ");
            // Recebe o segundo numero
            // Double pois o usuário pode entrar com um numero com casa decimal
            double numeroDois = sc.nextDouble();
    
            // Realiza a divisão dos valores
            double divisao = numeroUm / numeroDois;
            System.out.println("\nA divisão resultou em: " + divisao);
    
            // Estrutura usuada para pausar momentaneamente o programa
            System.out.println("\nEnter para continuar....: ");
            sc.nextLine();
        } catch (Exception e) {
            // Exception que proteje o programa caso o usuario entre 
            // com um texto diferente de um numero
            System.out.println("\n\nEntrada inválida!\n" + e.getMessage());
        }
    }

    private static void faixaEtaria() {
        try {
            // Recebe o numero
            // Int pois o usuário pode entrar apenas com numeros interos
            System.out.println("\nEntre com a quantidade de pessoa: ");
            int numero = sc.nextInt();
            // Como a leitura de teclado gera suja o buffer (estrutura que armazenar dados)
            // Utilizamos esse 'leitura' para limpar
            // Caso seja utilizado sem pode gerar erro na leitura
            // Sugiro testar com e sem para ver a diferença
            sc.nextLine();
            
            // Foi criada a classe Pessoa para gerar uma lista
            // com o objetivo de facilitar o armazenamento de dados
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            
            // Loop de acordo com a quantidade inserida
            for (int i = 0; i < numero; i++) {
                System.out.println("\nEntre com o sexo da pessoa(M ou F): ");
                String sexo = sc.nextLine();
                System.out.println("\nEntre com a idade: ");
                int idade =  sc.nextInt();
                // Como a leitura de teclado gera suja o buffer (estrutura que armazenar dados)
                // Utilizamos esse 'leitura' para limpar
                // Caso seja utilizado sem pode gerar erro na leitura
                // Sugiro testar com e sem para ver a diferença
                sc.nextLine();

                // Preenchendo a lista de Pessoas
                Pessoa pessoa = new Pessoa(sexo, idade);
                pessoas.add(pessoa);
            }
            
            double somaIdades = 0;
            List<Pessoa> homens = new ArrayList<Pessoa>();
            List<Pessoa> mulheres = new ArrayList<Pessoa>();

            for (Pessoa pessoa : pessoas) {
                somaIdades += pessoa.getIdade();
                if(pessoa.getSexo().equals("M"))
                { 
                    homens.add(pessoa);
                }
                else
                {
                    mulheres.add(pessoa);
                }
                System.out.println(pessoa.toString());
            }

            double somaHomens = 0;
            for (Pessoa pessoa : homens) {
                somaHomens += pessoa.getIdade();
            }

            double somaMulheres = 0;
            for (Pessoa pessoa : mulheres) {
                somaMulheres += pessoa.getIdade();
            }

            System.out.println("\n A soma das idades é de: " + somaIdades/pessoas.size());
            System.out.println("\n A soma das idades dos homens é de: " + somaHomens/homens.size());
            System.out.println("\n A soma das idades é de: " + somaMulheres/mulheres.size());

            System.out.println("\nEnter para continuar....: ");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("\nEntrada inválida!\n" + e.getMessage());
        }
    }

    private static void numeroPrimo() {
        try {
            System.out.println("\nEntre com o número máximo: ");
            double numeroUm = sc.nextDouble();
    
            double somaPrimos = 0;
            for (int i = 1; i <= numeroUm; i++) {
                int numeroDividores = 0;
                for (int j = 1; j <= i; j++) {
                    if(i%j == 0)
                        numeroDividores ++;
                }
                if(numeroDividores == 2)
                somaPrimos += i;
            }
            System.out.println("\nA soma dos numeros primos entre 1 e " + numeroUm + " é: " + somaPrimos);               

        } catch (Exception e) {
            System.out.println("\nEntrada inválida!\n" + e.getMessage());
        }
        System.out.println("\nEnter para continuar....: ");
        sc.nextLine();
    }

    private static void mudancaBase(){
        try {
            System.out.println("\nPara converter para decimal adicione xBinario após o final do número!");   
            System.out.println("\nPara converter para binário adicione xDecimal após o final do número!");   
            System.out.println("\nEntre com a quantidade de números a serem convertidos: ");   
            int quantidade = sc.nextInt(); 
            sc.nextLine();
            
            for (int i = 0; i < quantidade; i++) {                
                System.out.println("\nEntre com o " + (i+1)  +"o valor: ");   
                String valor = sc.nextLine();
                if(valor.contains("xDecimal"))
                {                                        
                    int indexMaximo = 0;
                    for (int j = 0; j < valor.length(); j++) {
                        if(!Character.isDigit(valor.charAt(j)))
                        {
                            indexMaximo = j;
                            break;
                        }
                    }
                    int numero = Integer.parseInt(valor.substring(0,indexMaximo));
                    String bin = Integer.toBinaryString(numero);//Converter um valor int para binario e atribui o valor a um tipo string
                    System.out.println("\nO valor "+numero+" em binário é: " + bin + "\n"); 
                }
                else if(valor.contains("xBinario"))
                {
                    int indexMaximo = 0;
                    for (int j = 0; j < valor.length(); j++) {
                        if(!Character.isDigit(valor.charAt(j)))
                        {
                            indexMaximo = j;
                            break;
                        }
                    }
                    String numero = valor.substring(0,indexMaximo);
                    int bin = Integer.parseInt(numero, 2);//Converter um valor int para binario e atribui o valor a um tipo string
                    System.out.println("\nO valor "+numero+" em binário é: " + bin + "\n"); 
                }
            }     
        } catch (Exception e) {
            System.out.println("\nErro!\n" + e.getMessage());
        }
        System.out.println("\nEnter para continuar....: ");
        sc.nextLine();
    }
}