import java.util.Scanner;

public class Principal {
    //static Scanner novoScanner = new Scanner(System.in);
    static Banco bancoBrasileiro = new Banco();
    Banco[] listaBancos = {bancoBrasileiro};

    public static void main(String[] args) {
        ContaPoupanca contaPoupanca1 = new ContaPoupanca("Elena Santos", 98, bancoBrasileiro.getContadorContasPoupancas(), 3000.00);
        bancoBrasileiro.adicionarContaPoupanca(contaPoupanca1);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca("Richarlisson Araujo Deltas", 98, bancoBrasileiro.getContadorContasPoupancas(), 980.89);
        bancoBrasileiro.adicionarContaPoupanca(contaPoupanca2);

        contaPoupanca1.transferirParaMesmoBanco("Poupanca", 1230.00, contaPoupanca2);
        contaPoupanca1.visualizarExtrato();
        contaPoupanca2.visualizarExtrato();





    }
}
