package nk.enonces;

public enum CentsInfo {
	// du plus grand au plus petit, parce que je le vaux bien
	Baz(21), Qix(11), Bar(7), Foo(1);

	private int montant;

	private CentsInfo(int montant) {
		this.montant = montant;
	}

	public int getMontant() {
		return montant;
	}
}
