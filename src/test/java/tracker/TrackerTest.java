package tracker;

import model.entity.Item;
import model.tracker.Tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrackerTest {

    @Test
    void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Assertions.assertEquals(item.getId(), result.getId());
    }

    @Test
    void whenTrackerIsEmptyThenZero() {
        Tracker tracker = new Tracker();
        int expected = 0;
        int size = tracker.findAll().size();
        Assertions.assertEquals(expected, size);
    }

    @Test
    void whenFindByIdTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Assertions.assertEquals(item.getName(), result.getName());
    }

    @Test
    void whenNotFindById() {
        Tracker tracker = new Tracker();

    }

    @Test
    void findAllTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        int result = tracker.findAll().size();
        int expected = 2;
        Assertions.assertEquals(result, expected);
    }

    @Test
    void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        Item firstListItem = tracker.findByName(item.getName()).get(0);
        Assertions.assertEquals(item.getName(), firstListItem.getName());
    }

    @Test
    void replaceTest() {
        Tracker tracker = new Tracker();
        Item oldItem = new Item();
        tracker.add(oldItem);
        Item newItem = new Item("newItem");
        tracker.replace(newItem, oldItem.getId());
        Item item = tracker.findAll().get(0);
        Assertions.assertEquals(item.getName(), newItem.getName());
    }

    @Test
    void deleteTest() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstItem");
        Item secondItem = new Item("secondItem");
        Item thirdItem = new Item("thirdItem");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.delete(secondItem.getId());
        int result = tracker.findAll().size();
        int expected = 2;
        Assertions.assertEquals(expected, result);
    }


}