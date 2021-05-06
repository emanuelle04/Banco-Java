import java.util.Scanner;

public class Principal {
    static Scanner novoScanner = new Scanner(System.in);
    static Banco bancoBrasileiro =  new Banco();
    Banco[] listaBancos = {bancoBrasileiro};
    public static void main(String[] args){
        while(true) {
            System.out.println("Escolha uma opção:\n1-Banco Brasileiro\n2-Finalizar Operação\n");
            String escolhaBanco = novoScanner.nextLine();
            int intEscolhaBanco = Integer.parseInt(escolhaBanco);
            if(intEscolhaBanco == 2){break;}
            else{
                System.out.print("Escolha uma operação:\n1-Criar Conta Corrente\n2- Criar Conta Poupanca\n3- Outras Operações Conta Corrente\n4-Outras Operações Conta Poupanca\n4- Sair\n1");
                String escolhaOperacao = novoScanner.nextLine();
                int intEscolhaOperacao = Integer.parseInt(escolhaOperacao);
                Principal classePrincipal = new Principal();
                if(intEscolhaOperacao == 1){classePrincipal.criarConta(intEscolhaBanco, "Corrente");}
                else if (intEscolhaOperacao == 2){ classePrincipal.criarConta(intEscolhaBanco, "Poupanca");}
                else if(intEscolhaOperacao == 3){
                    System.out.println("Escolha uma operação:\n1- Sacar\n2- Depositar\n3- Transferir\n4- Ver Extrato\n5- Sair\n");
                    String escolhaMaisOperacoes = novoScanner.nextLine();
                    int intEscolhaMaisOperacoes = Integer.parseInt(escolhaMaisOperacoes);
                    classePrincipal.realizarOperacoes("Corrente", intEscolhaMaisOperacoes);

                }
            }



        }
    }


    public void criarConta(int bancoEscolhido, String tipoDeConta){
            System.out.println("Digite o nome do proprietário da conta: ");
            String nome = novoScanner.nextLine();
            System.out.println("Digite o número da agencia: ");
            String agencia = novoScanner.nextLine();
            int agenciaNumber = Integer.parseInt(agencia);
            System.out.println("Digite o depósito incial (saldo incial): ");
            String saldo = novoScanner.nextLine();
            double saldoNumber = Double.parseDouble(saldo);

            if (bancoEscolhido == 1 && tipoDeConta == "Corrente") {
                int numeroContaUser = this.bancoBrasileiro.getContadorContasCorrentes();
                bancoBrasileiro.adicionarContaCorrente(new ContaCorrente(nome, agenciaNumber, numeroContaUser, saldoNumber));
            }
            else if (bancoEscolhido == 1 && tipoDeConta == "Poupanca") {
                int numeroContaUser = this.bancoBrasileiro.getContadorContasPoupancas();
                bancoBrasileiro.adicionarContaPoupanca(new ContaPoupanca(nome, agenciaNumber, numeroContaUser, saldoNumber));
            }

        }

        public void realizarOperacoes(String tipoDeConta, int numeroDaOperacao){
            System.out.println("Digite o numero da conta: ");
            String numeroDaConta = novoScanner.nextLine();
            int intNumeroDaConta = Integer.parseInt(numeroDaConta);
            System.out.println("Digite a Agencia: ");
            String agenciaDaConta = novoScanner.nextLine();
            int intAgenciaDaConta = Integer.parseInt(agenciaDaConta);

            Conta conta = bancoBrasileiro.procurarUsuario(tipoDeConta, intAgenciaDaConta, intNumeroDaConta);
            if(numeroDaOperacao == 1){
                System.out.println("Digite o valor que deseja sacar: \n");
                String valorSaque = novoScanner.nextLine();
                double doubleValorSaque = Double.parseDouble(valorSaque);

                conta.sacar(doubleValorSaque);
            }
            else if(numeroDaOperacao == 2){
                System.out.println("Digite o valor que deseja depositar: \n");
                String valorDeposito = novoScanner.nextLine();
                double doubleValorDeposito = Double.parseDouble(valorDeposito);

                conta.depositar(doubleValorDeposito);

            }
            else if(numeroDaOperacao == 3){

            }


        }






}

