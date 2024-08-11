package sortingStrategy;

import java.util.LinkedList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.Before;
import org.junit.Test;

import item.Item;
import item.SingleItem;

public class TestAlphabeticSortingStrategy {

	private List<Item> items;

	@Before
	public void inizializeList() {
		items = new LinkedList<>();
		items.add(new SingleItem(50.0, "Ite", 0));
		items.add(new SingleItem(20.0, "Arc", 1));
		items.add(new SingleItem(15.0, "WWF", 2));
	}

	@Test
	public void testAlphabeticSortingStrategy() {
		AlphabeticSortingStrategy alphabetic = new AlphabeticSortingStrategy();
		alphabetic.sortList(items);

		Assertions.assertThat(items).extracting(Item::getPrice, Item::getName, Item::getId)
				.containsExactly(Tuple.tuple(20.0, "Arc", 1), Tuple.tuple(50.0, "Ite", 0), Tuple.tuple(15.0, "WWF", 2));

	}

}
