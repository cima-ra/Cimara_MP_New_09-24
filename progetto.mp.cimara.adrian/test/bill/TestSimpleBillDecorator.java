package bill;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.SingleItem;

public class TestSimpleBillDecorator {

	private List<Item> items;

	@Before
	public void ininizializeList() {

		items = new LinkedList<>();
		items.add(new SingleItem(50, "Ite", 0));
		items.add(new SingleItem(20, "Arc", 1));
		items.add(new SingleItem(15, "WWF", 2));

	}

	@Test
	public void testGetDecorato() {
		SimpleBillDecorator bill = new SimpleBillDecorator(items);

		assertThat(bill.getDescription()).isEqualTo("Scontrino Acquisto: Ite, Arc, WWF, ");
	}
}
