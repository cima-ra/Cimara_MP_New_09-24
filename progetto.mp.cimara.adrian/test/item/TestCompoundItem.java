package item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TestCompoundItem {

	@Test
	public void testAddItemListInsertion() {
		CompoundItem bundle = new CompoundItem("Kit Mare", 1);
		Item singleS = new SingleItem(120, "Canna con il mulinello 4.30m", 2);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		assertThat(bundle.getItems()).hasSize(3).allMatch(item -> item.getName().equals("Canna con il mulinello 4.30m"))
				.allMatch(item -> Double.compare(item.getPrice(), 120) == 0).allMatch(item -> item.getId() == 2);
	}

	@Test
	public void testAddItemPriceUpdate() {
		CompoundItem bundle = new CompoundItem("Kit Mare", 1);
		Item singleS = new SingleItem(120, "Canna con il mulinello 4.30m", 2);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		assertThat(bundle.getPrice()).isEqualTo(360);
	}

	@Test
	public void testRemoveItemListRemouved() {
		CompoundItem bundle = new CompoundItem("Kit Lago", 1);
		Item singleS = new SingleItem(50, "Canna fissa 4m", 0);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		bundle.removeItem(singleS);
		assertThat(bundle.getItems()).hasSize(2).allMatch(item -> item.getName().equals("Canna fissa 4m"))
				.allMatch(item -> Double.compare(item.getPrice(), 50) == 0).allMatch(item -> item.getId() == 0);
	}

	@Test
	public void testRemoveItemPriceUpdate() {
		CompoundItem bundle = new CompoundItem("Kit Lago", 1);
		Item singleS = new SingleItem(50, "Canna fissa 4m", 0);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		bundle.removeItem(singleS);
		assertThat(bundle.getPrice()).isEqualTo(50);
	}

	@Test
	public void testToString() {
		CompoundItem bundle = new CompoundItem("Kit Mare", 1);
		Item singleS = new SingleItem(120, "Canna con il mulinello 4.30m", 2);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		bundle.addItem(singleS);
		assertThat(bundle.toString()).isEqualTo(
				"Kit Mare: - Canna con il mulinello 4.30m - Canna con il mulinello 4.30m - Canna con il mulinello 4.30m - ");
	}

}
