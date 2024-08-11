package shopRegister;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import item.CompoundItem;
import item.Item;
import item.SingleItem;
import sortingStrategy.AlphabeticSortingStrategy;
import sortingStrategy.NumericSortingStrategy;

public class TestRegister {

	@Test
	public void testOperatorId() {
		Register shopRegister = new Register(01);
		assertThat(shopRegister.getOperatorId()).isEqualTo(01);
	}

	@Test
	public void testAddArticleListInsertion() {
		Register shopRegister = new Register(02);
		Item singleItem = new SingleItem(12.5, "Fish", 0);
		Item singleItem1 = new SingleItem(13.5, "Knife", 1);
		Item singleItem2 = new SingleItem(12.5, "Item", 2);
		Item compItem = new CompoundItem("Things", 3);
		compItem.addItem(singleItem1);
		compItem.addItem(singleItem2);
		shopRegister.addArticle(singleItem);
		shopRegister.addArticle(compItem);
		assertThat(shopRegister.getArticles()).hasSize(2).anyMatch(article -> article.getName().equals("Things"))
				.anyMatch(article -> Double.compare(article.getPrice(), 12.5) == 0).anyMatch(item -> item.getId() == 3);
	}

	@Test
	public void testAddArticlePriceUpdate() {
		Register shopRegister = new Register(02);
		Item singleItem = new SingleItem(12.5, "Fish", 0);
		Item singleItem1 = new SingleItem(13.5, "Knife", 1);
		Item singleItem2 = new SingleItem(12.5, "Item", 2);
		Item compItem = new CompoundItem("Things", 3);
		compItem.addItem(singleItem1);
		compItem.addItem(singleItem2);
		shopRegister.addArticle(singleItem);
		shopRegister.addArticle(compItem);
		assertThat(shopRegister.getTotalPrice()).isEqualTo(38.5);
	}

	@Test
	public void testRemouveArticlePriceUpdate() {
		Register shopRegister = new Register(02);
		Item singleItem = new SingleItem(12.5, "Fish", 0);
		Item singleItem1 = new SingleItem(13.5, "Knife", 1);
		Item singleItem2 = new SingleItem(12.5, "Item", 2);
		Item compItem = new CompoundItem("Things", 3);
		compItem.addItem(singleItem1);
		compItem.addItem(singleItem2);
		shopRegister.addArticle(singleItem);
		shopRegister.addArticle(compItem);
		shopRegister.removeArticle(compItem);
		assertThat(shopRegister.getTotalPrice()).isEqualTo(12.5);
	}

	@Test
	public void testRemouveArticleListUpdated() {
		Register shopRegister = new Register(02);
		Item singleItem = new SingleItem(12.5, "Fish", 0);
		Item singleItem1 = new SingleItem(13.5, "Knife", 1);
		Item singleItem2 = new SingleItem(12.5, "Item", 2);
		Item compItem = new CompoundItem("Things", 3);
		compItem.addItem(singleItem1);
		compItem.addItem(singleItem2);
		shopRegister.addArticle(singleItem);
		shopRegister.addArticle(compItem);
		shopRegister.removeArticle(compItem);
		assertThat(shopRegister.getArticles()).hasSize(1).anyMatch(article -> article.getName().equals("Fish"))
				.anyMatch(article -> Double.compare(article.getPrice(), 12.5) == 0).anyMatch(item -> item.getId() == 0);
	}

	@Test
	public void testGetBillNumericStrategy() {
		Register shopRegister = new Register(03);
		Item singleItem = new SingleItem(12.5, "Fish", 0);
		Item singleItem1 = new SingleItem(13.5, "Knife", 1);
		Item singleItem2 = new SingleItem(12.5, "Item", 2);
		Item compItem = new CompoundItem("Things", 3);
		compItem.addItem(singleItem1);
		compItem.addItem(singleItem2);
		shopRegister.addArticle(singleItem);
		shopRegister.addArticle(compItem);

		NumericSortingStrategy numericSorting = new NumericSortingStrategy();
		numericSorting.sortList(shopRegister.getArticles());

		assertThat(shopRegister.getBill(numericSorting))
				.isEqualTo("Scontrino Acquisto: Fish, Things: - Knife - Item - ,  38.5€. Grazie per l'acquisto e buona giornata.");
	}

	@Test
	public void testGetBillAlphabeticStrategy() {
		Register shopRegister = new Register(03);
		Item singleItem = new SingleItem(12.5, "Fish", 0);
		Item singleItem1 = new SingleItem(13.5, "Knife", 1);
		Item singleItem2 = new SingleItem(12.5, "Item", 2);
		Item compItem = new CompoundItem("Things", 3);
		compItem.addItem(singleItem1);
		compItem.addItem(singleItem2);
		shopRegister.addArticle(singleItem);
		shopRegister.addArticle(compItem);

		AlphabeticSortingStrategy alphabeticSorting = new AlphabeticSortingStrategy();
		alphabeticSorting.sortList(shopRegister.getArticles());

		assertThat(shopRegister.getBill(alphabeticSorting))
				.isEqualTo("Scontrino Acquisto: Fish, Things: - Knife - Item - ,  38.5€. Grazie per l'acquisto e buona giornata.");
	}
}
