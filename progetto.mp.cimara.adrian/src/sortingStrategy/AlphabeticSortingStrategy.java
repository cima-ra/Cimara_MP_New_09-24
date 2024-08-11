package sortingStrategy;

import java.util.List;

import item.Item;

public class AlphabeticSortingStrategy implements SortingStrategy {

	@Override
	public void sortList(List<Item> items) {
		items.sort((i1, i2) -> i1.getName().compareTo(i2.getName()));
	}

}
