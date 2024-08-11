package bill;

public class BirthdayBillDecorator extends BillDecorator {

	public BirthdayBillDecorator(Bill billDecorated) {
		super(billDecorated);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + " Scontrino di cortesia. Tanti auguri e buon compleanno!!";
	}
	
	//Classe per lo scontrino di cortesia. Dove non ci deve essere il prezzo.

}
