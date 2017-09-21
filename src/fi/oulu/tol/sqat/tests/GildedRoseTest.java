package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		
			
		
		store.updateEndOfDay();
		
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testRagnaros_quality_never_decreases_Hand_of_Ragnaros_0_80() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		for(int i=0; i<8; i++) {
			store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item itemRagnaros = items.get(0);
		assertEquals(80, itemRagnaros.getQuality());
	}
	@Test
	public void testBackstagepasses_test1_11_10(){
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) );
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemPasses = items.get(0);
		assertEquals(11, itemPasses.getQuality());
	}
	@Test
	public void testBackstagepasses_test2_10_10(){
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) );
		
		for(int i=0; i<5; i++) {
			
			store.updateEndOfDay();
			
		}
		List<Item> items = store.getItems();
		Item itemPasses = items.get(0);
		assertEquals(20, itemPasses.getQuality());
	}
	@Test
	public void testBackstagepasses_test3_5_10(){
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) );
		
		for(int i=0; i<5; i++) {
			
			store.updateEndOfDay();
			
		}
		List<Item> items = store.getItems();
		Item itemPasses = items.get(0);
		assertEquals(25, itemPasses.getQuality());
	}
	@Test
	public void testBackstagepasses_test4_0_10(){
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) );
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemPasses = items.get(0);
		assertEquals(0, itemPasses.getQuality());
	}
		
}
