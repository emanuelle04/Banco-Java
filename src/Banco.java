public class Banco {
    ContaCorrente[] contasCorrentes = new ContaCorrente[10];
    ContaPoupanca[] contasPoupancas = new ContaPoupanca[10];
    CarteiraDigital[] carteiraDigitals = new CarteiraDigital[10];
    public static String[] listaBancos = {"Azul", "Pague Facil", "Banco Brasileiro"};
    static int contadorCarteirasDigitais = 0;
    static int contadorContasCorrentes = 0;
    static int contadorContasPoupancas = 0;


    public void adicionarContaCorrente(ContaCorrente conta) {
        this.contasCorrentes[contadorContasCorrentes] = conta;
        String textoConclusaoAdicaoDaContaCorrente = "Nova Conta Corrente adicionada.\nNúmero da Conta Corrente: " + contadorContasCorrentes + "\nProprietario:" + conta.proprietario + "\nAgencia:" + conta.agencia +"\n";
        System.out.println(textoConclusaoAdicaoDaContaCorrente);
        contadorContasCorrentes++;

    }

    public void adicionarContaPoupanca(ContaPoupanca conta) {
        this.contasPoupancas[contadorContasPoupancas] = conta;
        String textoConclusaoAdicaoDaContaPoupanca = "Nova Conta Poupança adicionada.\nNúmero da Conta Poupanca: " + contadorContasCorrentes + "\nProprietario:" + conta.proprietario + "\nAgencia:" + conta.agencia+"\n";
        System.out.println(textoConclusaoAdicaoDaContaPoupanca);
        contadorContasPoupancas++;
    }
    public void adicionarCarteiraDigital(CarteiraDigital conta) {
        this.carteiraDigitals[contadorCarteirasDigitais] = conta;
        String textoConclusaoAdicaoDeCarteiraDigital = "Nova Carteira Digital adicionada.\nId da Carteira Digital: " + contadorContasCorrentes + "\nProprietario:" + conta.proprietario + "\n";
        System.out.println(textoConclusaoAdicaoDeCarteiraDigital);
        contadorCarteirasDigitais++;

    }


    public int getContadorContasCorrentes() {
        return contadorContasCorrentes;
    }

    public int getContadorContasPoupancas() {
        return contadorContasPoupancas;
    }

    public Conta procurarUsuario(String tipoDeConta, int agencia, int numeroDaConta) {
        Conta contaPesquisada = new Conta();
        if (tipoDeConta == "Corrente") {
            for (int i = 0; i < contasCorrentes.length; i++) {
                if (this.contasCorrentes[i].agencia == agencia && this.contasCorrentes[i].numeroConta == numeroDaConta) {
                    contaPesquisada = this.contasCorrentes[i];
                    break;
                }
            }
        } else {
            for (int i = 0; i < contasPoupancas.length; i++) {
                if (this.contasPoupancas[i].agencia == agencia && this.contasPoupancas[i].numeroConta == numeroDaConta) {
                    contaPesquisada = this.contasPoupancas[i];
                    break;
                }
            }

        }
        return contaPesquisada;
    }
}