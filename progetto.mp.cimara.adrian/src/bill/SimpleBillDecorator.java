package bill;

import java.util.List;

import item.Item;

public class SimpleBillDecorator implements Bill {

	private List<Item> items;

	public SimpleBillDecorator(List<Item> items) {
		this.items = items;
	}

	@Override
	public String getDescription() {
		String allItems = new String("Scontrino Acquisto: ");

		for (Item i : items) {
			allItems += i.toString() + ", ";
		}

		return allItems;
	}
}

// Questo è il componente concreto di base con le funzionalità di base. 
// Nelle prossime due classi devo implementare la funzionalità con gli auguri di compleanno senza prezzo
// e quella con il prezzo simil scontrino completo