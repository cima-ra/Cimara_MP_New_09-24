package bill;

public abstract class BillDecorator implements Bill {

	protected Bill billDecorated;

	public BillDecorator(Bill billDecorated) {
		this.billDecorated = billDecorated;
	}

	@Override
	public String getDescription() {
		return billDecorated.getDescription();
	}

}
