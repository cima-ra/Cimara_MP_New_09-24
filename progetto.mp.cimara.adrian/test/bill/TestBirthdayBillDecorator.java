package bill;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.SingleItem;

public class TestBirthdayBillDecorator {
	private List<Item> items;

	@Before
	public void inInizializeList() {

		items = new LinkedList<>();
		items.add(new SingleItem(50, "Ite", 0));
		items.add(new SingleItem(20, "Arc", 1));
		items.add(new SingleItem(15, "WWF", 2));

	}

	@Test
	public void testGetDescription() {
		SimpleBillDecorator simpleBill = new SimpleBillDecorator(items);
		BirthdayBillDecorator greetingBill = new BirthdayBillDecorator(simpleBill);

		assertThat(greetingBill.getDescription())
				.isEqualTo("Scontrino Acquisto: Ite, Arc, WWF,  Scontrino di cortesia. Tanti auguri e buon compleanno!!");
	}
}
