package model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor

public final class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
    private final LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

    public Item(@NonNull String name) {
        assert !"".equals(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Item {id = %02d, name = \'%8s\', created = %s}",
                id, name, created.format(FORMATTER));
    }
}
