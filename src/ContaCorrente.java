public class ContaCorrente extends Conta{
    double taxaDeManutencao;

    ContaCorrente(String proprietario, int agencia, int numeroConta, double saldo){
        super(proprietario, agencia, numeroConta, saldo);
        this.taxaDeManutencao = 0.8;

    }

}
