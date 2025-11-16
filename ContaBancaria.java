public class ContaBancaria {
    // Atributos privados (encapsulados)
    private String numeroConta;
    private String titular;
    private double saldo;

    // Construtor para inicializar a conta
    public ContaBancaria(String numeroConta, String titular) {
        setNumeroConta(numeroConta);
        setTitular(titular);
        this.saldo = 0.0; // Saldo inicial é zero
    }

    // Getter e Setter para numeroConta
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        if (numeroConta != null && !numeroConta.isEmpty()) {
            this.numeroConta = numeroConta;
        } else {
            System.out.println("Erro: Número da conta não pode ser nulo ou vazio.");
        }
    }

    // Getter e Setter para titular
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        } else {
            System.out.println("Erro: Titular não pode ser nulo ou vazio.");
        }
    }

    // Getter para saldo (somente leitura)
    public double getSaldo() {
        return saldo;
    }

    // Método de transação: depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + String.format("%.2f", valor) + " realizado com sucesso!");
        } else {
            System.out.println("Erro: Valor de depósito inválido.");
        }
    }

    // Método de transação: sacar
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso!");
            } else {
                System.out.println("Erro: Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Erro: Valor de saque inválido.");
        }
    }

    // Método principal para testar a classe ContaBancaria
    public static void main(String[] args) {
        // Criando uma instância da ContaBancaria
        ContaBancaria minhaConta = new ContaBancaria("12345-6", "João Silva");

        System.out.println("--- Informações da Conta ---");
        System.out.println("Número da Conta: " + minhaConta.getNumeroConta());
        System.out.println("Titular: " + minhaConta.getTitular());
        System.out.println("Saldo Inicial: R$" + String.format("%.2f", minhaConta.getSaldo()));

        // Realizando operações
        minhaConta.depositar(1000.00);
        System.out.println("Saldo após depósito: R$" + String.format("%.2f", minhaConta.getSaldo()));

        minhaConta.sacar(200.50);
        System.out.println("Saldo após saque: R$" + String.format("%.2f", minhaConta.getSaldo()));

        minhaConta.sacar(900.00); // Tentativa de saque com saldo insuficiente
        System.out.println("Saldo atual: R$" + String.format("%.2f", minhaConta.getSaldo()));

        minhaConta.depositar(-50.00); // Tentativa de depósito inválido
        minhaConta.sacar(-10.00);    // Tentativa de saque inválido

        // Testando setters com valores inválidos
        minhaConta.setTitular("");
        minhaConta.setNumeroConta(null);

        System.out.println("\n--- Informações Finais da Conta ---");
        System.out.println("Número da Conta: " + minhaConta.getNumeroConta());
        System.out.println("Titular: " + minhaConta.getTitular());
        System.out.println("Saldo Final: R$" + String.format("%.2f", minhaConta.getSaldo()));
    }
}
