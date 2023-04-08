package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Player {
    private int id;
    private String name;
    private int strength;

    public boolean matches(String search) {
        if (getName().equals(search)) {
            return true;
        }

        return false;
    }
}
