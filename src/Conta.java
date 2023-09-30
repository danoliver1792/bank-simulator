
public abstract class Conta implements iConta {
	
	private static final int AGENCIA_PADRAO = 0;
	private static int SEQUENCIAL = 1;
	
	public Conta() {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
	}
	
	protected int agencia;
	protected int numero;
	protected double saldo;

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
}
