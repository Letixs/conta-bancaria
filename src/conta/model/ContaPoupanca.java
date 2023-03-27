package conta.model;

public class ContaPoupanca extends Conta{
	
	private float saldoPoupanca;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, float saldoPoupanca) {
		super(numero, agencia, tipo, titular, saldo);
		this.saldoPoupanca = saldoPoupanca;
	}

	public float getSaldoPoupanca() {
		return saldoPoupanca;
	}

	public void setSaldoPoupanca(float saldoPoupanca) {
		this.saldoPoupanca = saldoPoupanca;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Saldo na poupança: " + this.saldoPoupanca);
	}
	
}
