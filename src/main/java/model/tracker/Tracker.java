package model.tracker;

import lombok.NonNull;
import model.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 0;

    public void add(Item item) {
        item.setId(ids);
        items.add(item);
        ids++;
    }

    public Item findById(int id) {
        assert id > -1;
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

    public List<Item> findByName(@NonNull String key) {
        assert !"".equals(key);
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
        assert id > -1;
        validateId(id);

        int rsl = indexOf(id);
        item.setId(id);
        items.set(rsl, item);
    }

    public void delete(int id) {
        assert id > -1;
        validateId(id);

        Item item = findById(id);
        items.remove(item);
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
        boolean flag = false;
        for (Item item : items) {
            if (item.getId() == id) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            throw new InvalidIdException("This id does not exist!");
        }
    }

    private void validateName(String name) {
        boolean flag = false;
        for (Item item : items) {
            if (name.equalsIgnoreCase(item.getName())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            throw new InvalidStringException("This name does not exist!");
        }
    }


    private void validateName2(String name) {
        for (Item item : items) {
            if (name.equalsIgnoreCase(item.getName())) {
               return;
            }
        }

        throw new InvalidStringException("This name does not exist!");
    }
}
