package sortingStrategy;

import java.util.LinkedList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.SingleItem;

public class TestNumericSortingStrategy {

	private List<Item> items;

	@Before
	public void inizializeList() {
		items = new LinkedList<>();
		items.add(new SingleItem(50.0, "Ite", 0));
		items.add(new SingleItem(15.0, "WWF", 2));
		items.add(new SingleItem(20.0, "Arc", 1));
	}

	@Test
	public void testNumericSortingStrategy() {
		NumericSortingStrategy numeric = new NumericSortingStrategy();
		numeric.sortList(items);

		Assertions.assertThat(items).extracting(Item::getPrice, Item::getName, Item::getId)
				.containsExactly(Tuple.tuple(15.0, "WWF", 2), Tuple.tuple(20.0, "Arc", 1), Tuple.tuple(50.0, "Ite", 0));

	}

}
