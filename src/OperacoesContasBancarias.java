public interface OperacoesContasBancarias {
    boolean depositar(double valorDeposito);
    boolean sacar(double valor);
    void visualizarExtrato();
    void tranferirDinheiroOutroBanco(String bancoDestino, int numeroDaContaDestino, double valorTrasnferencia);
    boolean transferirParaMesmoBanco(String tipoDaConta, int numeroDaContaDestino, int agenciaDaConta, double valorTrasnferencia);

}
