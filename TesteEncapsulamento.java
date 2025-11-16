public class TesteEncapsulamento {
    public static void main(String[] args) {
        // Criando uma nova instância de ContaBancaria
        ContaBancaria conta = new ContaBancaria();

        // Tentando acessar diretamente os atributos (isso gera erro de compilação)
        // conta.saldo = 500; // ERRO: saldo é privado

        // Inicializando atributos com Setters
        conta.setNumeroConta("12345-6");
        conta.setTitular("Samuel");

        // Testando transações
        conta.depositar(1000);   // Depósito válido
        conta.depositar(-50);    // Depósito inválido

        conta.sacar(200);        // Saque válido
        conta.sacar(2000);       // Saque inválido (saldo insuficiente)
        conta.sacar(-10);        // Saque inválido (valor negativo)

        // Exibindo saldo final
        System.out.println("Saldo final: R$" + conta.getSaldo());
    }
}
