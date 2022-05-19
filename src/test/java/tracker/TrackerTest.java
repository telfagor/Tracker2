package tracker;

import model.Item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrackerTest {

    @Test
    void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        String name = "test";
        tracker.add(item, name);
        Item result = tracker.findById(item.getId());
        Assertions.assertEquals(item.getId(), result.getId());
    }

    @Test
    void findByIdTest() {
        Tracker tracker = new Tracker();
        String name = "test2";
        Item item = new Item();
        tracker.add(item, name);
        Item result = tracker.findById(item.getId());
        Assertions.assertEquals(item.getName(), result.getName());
    }

    @Test
    void findAllTest() {
        Tracker tracker = new Tracker();
        String itemName1 = "test1";
        String itemName2 = "test2";
        Item item1 = new Item();
        Item item2 = new Item();
        tracker.add(item1, itemName1);
        tracker.add(item2, itemName2);
        int result = tracker.findAll().size();
        int expected = 2;
        Assertions.assertEquals(result, expected);
    }

    @Test
    void findByNameTest() {
        Tracker tracker = new Tracker();
        String name = "test";
        Item item = new Item();
        tracker.add(item, name);
        Item firstListItem = tracker.findByName(name).get(0);
        Assertions.assertEquals(item.getName(), firstListItem.getName());
    }

    @Test
    void replaceTest() {
        Tracker tracker = new Tracker();
        Item oldItem = new Item();
        tracker.add(oldItem, "oldItem");
        Item newItem = new Item("newItem");
        tracker.replace(newItem, oldItem.getId());
        Item item = tracker.findAll().get(0);
        Assertions.assertEquals(item.getName(), newItem.getName());
    }

    @Test
    void deleteTest() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item();
        Item secondItem = new Item();
        Item thirdItem = new Item();
        tracker.add(firstItem, "firstItem");
        tracker.add(secondItem, "secondItem");
        tracker.add(thirdItem, "thirdItem");
        tracker.delete(secondItem.getId());
        int result = tracker.findAll().size();
        int expected = 2;
        Assertions.assertEquals(expected, result);
    }
}