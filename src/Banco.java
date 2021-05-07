import java.util.ArrayList;

public class Banco {
    ArrayList<ContaCorrente> contasCorrentes = new ArrayList<ContaCorrente>();
    ArrayList<ContaPoupanca> contasPoupancas = new ArrayList<ContaPoupanca>();
    ArrayList<ContaSalario> contasSalarios = new ArrayList<ContaSalario>();
    ArrayList<CarteiraDigital>  carteiraDigitais = new ArrayList<CarteiraDigital>();
    public static String[] listaBancos = {"Azul", "Pague Facil", "Banco Brasileiro"};
    static int contadorCarteirasDigitais = 0;
    static int contadorContasCorrentes = 0;
    static int contadorContasPoupancas = 0;


    public void adicionarContaCorrente(ContaCorrente conta) {
        this.contasCorrentes.add(conta);
        String textoConclusaoAdicaoDaContaCorrente = "Nova Conta Corrente adicionada.\nNúmero da Conta Corrente: " + contadorContasCorrentes + "\nProprietario:" + conta.proprietario + "\nAgencia:" + conta.agencia +"\n";
        System.out.println(textoConclusaoAdicaoDaContaCorrente);
        contadorContasCorrentes++;

    }

    public void adicionarContaPoupanca(ContaPoupanca conta) {
        this.contasPoupancas.add(conta);
        String textoConclusaoAdicaoDaContaPoupanca = "Nova Conta Poupança adicionada.\nNúmero da Conta Poupanca: " + contadorContasCorrentes + "\nProprietario:" + conta.proprietario + "\nAgencia:" + conta.agencia+"\n";
        System.out.println(textoConclusaoAdicaoDaContaPoupanca);
        contadorContasPoupancas++;
    }
    public void adicionarCarteiraDigital(CarteiraDigital conta) {
        this.carteiraDigitais.add(conta);
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
            for (int i = 0; i < contasCorrentes.size(); i++) {
                if (this.contasCorrentes.get(i).agencia == agencia && this.contasCorrentes.get(i).numeroConta == numeroDaConta) {
                    contaPesquisada = this.contasCorrentes.get(i);
                    break;
                }
            }
        } else if (tipoDeConta == "Salario") {
            for (int i = 0; i < contasSalarios.size(); i++) {
                if (this.contasSalarios.get(i).agencia == agencia && this.contasSalarios.get(i).numeroConta == numeroDaConta) {
                    contaPesquisada = this.contasSalarios.get(i);
                    break;
                }
            }

        } else if (tipoDeConta == "Poupanca"){
            for (int i = 0; i < contasPoupancas.size(); i++) {
                if (this.contasPoupancas.get(i).agencia == agencia && this.contasPoupancas.get(i).numeroConta == numeroDaConta) {
                    contaPesquisada = this.contasPoupancas.get(i);
                    break;
                }
            }

        }
        return contaPesquisada;
    }
}