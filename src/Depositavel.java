public interface Depositavel {
    boolean depositar(int agencia, int numeroDaConta, double valor);
    boolean pagarBoleto(int numeroDoBoleto, double valorDoBoleto, String dataDeVencimento);
    boolean pagarUsuario(int idUsuario, double valorDoPagamento);
}
