import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class CarteiraDigital implements Depositavel{
    String proprietario;
    double saldo;
    int idDaCarteira;
    ArrayList<String> horaTransacao = new ArrayList<String>();
    ArrayList<Double>  saldoTransacao = new ArrayList<Double>();

    CarteiraDigital(String proprietario, double saldo, int idDaCarteira){
        this.proprietario = proprietario;
        this.saldo = saldo;
        this.idDaCarteira = idDaCarteira;
    }



    //Apenas paga e aceita depósito.
    @Override
    public boolean depositar(int agencia, int numeroDaConta, double valorDeposito) {
        boolean statusDeposito;
        if(valorDeposito > 0){
            this.saldo += valorDeposito;
            // Adiciona Data e hora no Extrato Bancário.
            LocalTime horaTransacaoNow= LocalTime.now();
            LocalDate dataTransacao = LocalDate.now();
            horaTransacao.add( "Data da transação: " + dataTransacao.toString() + "\nHora da transação:"+ horaTransacaoNow.toString() + "\nOperação: Deposito.");
            saldoTransacao.add(saldo);
            System.out.println("Deposito realizado.");
            statusDeposito = true;
        }
        else{
            System.out.println("Valores negativos não podem se depositados.");
            statusDeposito = false;
        }
        return statusDeposito;

    }

    @Override
    public boolean pagarBoleto(int numeroDoBoleto, double valorDoBoleto, String dataDeVencimento) {
        return false;
    }

    @Override
    public boolean pagarUsuario(int idUsuario, double valorDoPagamento) {
        return false;
    }


}
