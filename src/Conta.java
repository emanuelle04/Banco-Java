import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;


public class Conta implements OperacoesContasBancarias {
    String proprietario;
    int agencia;
    int numeroConta;
    double saldo;
    ArrayList<String>  horaTransacao = new ArrayList<String>();
    ArrayList<Double>  saldoTransacao = new ArrayList<Double>();

    Conta(){}
    Conta(String proprietario, int agencia, int numeroConta, double saldo){
        this.proprietario = proprietario;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    @Override
    public boolean depositar(double valorDeposito) {
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

    public boolean sacar(double valor){
        boolean statusSaque;
        if (valor < 0){
            throw new RuntimeException("Valor negativo, escreva um valor maior que 0.");
        }
        else if (saldo > 0 && valor <= saldo){
            saldo = saldo - valor;
            // Adiciona Data e hora no Extrato Bancário.
            LocalTime horaTransacaoNow= LocalTime.now();
            LocalDate dataTransacao = LocalDate.now();
            horaTransacao.add( "Data da transação: " + dataTransacao.toString() + "\nHora da transação:"+ horaTransacaoNow.toString() + "\nOperação: Saque.");
            saldoTransacao.add(saldo);
            System.out.println("Operação concluída!\nValor:" + valor +"\nRetirado da conta: " + numeroConta + "-" + agencia);
            statusSaque = true;
        }
        else{
            System.out.println("Valor indisponível para saque.");
            statusSaque = false;
        }
        return statusSaque;
    }

    @Override
    public void visualizarExtrato() {
        for(int i =0; i < horaTransacao.size(); i++){
            System.out.println(horaTransacao.get(i)+ "\nSaldo na conta: " + saldoTransacao.get(i) + "\n");

        }

    }


    @Override
    public void tranferirDinheiroOutroBanco(String bancoDestino, int numeroDaContaDestino, double valorTrasnferencia) {
        if(bancoDestino == Banco.listaBancos[0] || bancoDestino == Banco.listaBancos[1] || bancoDestino == Banco.listaBancos[2]){
            if(saldo >= valorTrasnferencia){
                saldo -= valorTrasnferencia;
                System.out.println("Valor de " + valorTrasnferencia + " transferido para a conta " + numeroDaContaDestino + " do banco "+ bancoDestino +".");
                // Adiciona Data e hora no Extrato Bancário.
                LocalTime horaTransacaoNow= LocalTime.now();
                LocalDate dataTransacao = LocalDate.now();
                horaTransacao.add( "Data da transação: " + dataTransacao.toString() + "\nHora da transação:"+ horaTransacaoNow.toString() + "\nOperação: Transferencia Para outro Banco." );
                saldoTransacao.add(saldo);
            }
            else{
                System.out.println("Saldo indisponível.");
            }
        }
        else{
            System.out.println("Banco não aceito.");
        }
    }

    @Override
    public boolean transferirParaMesmoBanco(String tipoDaConta, int numeroDaContaDestino, int agenciaDaConta, double valorTrasnferencia) {
        return false;
    }


    public String getSaldo(){
        return "Seu saldo é: " + saldo;
    }
}
