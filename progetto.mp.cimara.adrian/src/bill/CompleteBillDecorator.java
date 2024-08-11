package bill;

public class CompleteBillDecorator extends BillDecorator {
	
	private Double price;

	public CompleteBillDecorator(Bill billDecorated, Double totalPrice) {
		super(billDecorated);
		price = totalPrice;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " " + price + "€. Grazie per l'acquisto e buona giornata.";
	}
	
	/*
	 * Questa classe contiene tutte le informazioni complete dello scontrino. 
	 * Capire se ho fatto bene o no a passare il prezzo totale dello scontrino come parametro oppure no.
	*/

}
