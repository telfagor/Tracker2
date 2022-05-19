package tracker;

import exceptions.InvalidIdException;
import exceptions.InvalidStringException;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private final List<Integer> itemsIds = new ArrayList<>();
    private final List<String> itemsName = new ArrayList<>();
    private int ids = 0;

    public void add(Item item, String name) {
        item.setId(ids);
        item.setName(name);
        items.add(item);
        itemsIds.add(ids);
        itemsName.add(name);
        ids++;
    }

    public Item findById(int id) {
        validateId(id);

        Item rsl = null;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        validateName(key);

        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                list.add(item);
            }
        }
        return list;
    }

    public void replace(Item item, int id) {
        validateId(id);

        itemsName.add(item.getName());
        int rsl = indexOf(id);
        item.setId(id);
        items.set(rsl, item);
    }

    public void delete(int id) {
        validateId(id);

        Item item = findById(id);
        items.remove(item);
        itemsIds.remove(id);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    private void validateId(int id) {
        if (!itemsIds.contains(id)) {
            throw new InvalidIdException("This id does not exist!");
        }
    }

    private void validateName(String name) {
        if (!itemsName.contains(name)) {
            throw new InvalidStringException("This name does not exists!");
        }
    }
}
