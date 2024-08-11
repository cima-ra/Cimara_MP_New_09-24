package sortingStrategy;

import java.util.List;

import item.Item;

public class NumericSortingStrategy implements SortingStrategy {

	@Override
	public void sortList(List<Item> items) {
		items.sort((i1, i2) -> Double.compare(i1.getPrice(), i2.getPrice()));
	}

}
