package conta.model;

public class ContaPoupanca extends Conta{
	
	private int aniversario;
	private float saldoPoupanca;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario,
			float saldoPoupanca) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
		this.saldoPoupanca = saldoPoupanca;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}

	public float getSaldoPoupanca() {
		return saldoPoupanca;
	}

	public void setSaldoPoupanca(float saldoPoupanca) {
		this.saldoPoupanca = saldoPoupanca;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: " + this.aniversario);
		System.out.println("Saldo na poupança: " + this.saldoPoupanca);
	}
	
}
