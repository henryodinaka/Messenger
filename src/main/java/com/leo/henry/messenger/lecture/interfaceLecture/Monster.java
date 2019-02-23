package com.leo.henry.messenger.lecture.interfaceLecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@ToString
public class Monster implements ISavable {

    private String name;
    private int hitPoint;
    private int strength;
    @Override
    public List<String> write() {
        List<String > values = new ArrayList<>();
        values.add(0,this.name);
        values.add(1,""+this.hitPoint);
        values.add(2,""+this.strength);
        return values;
    }

    @Override
    public void read(List<String> savedValue) {
        if (savedValue !=null && savedValue.size()!=0)
        {
            this.name = savedValue.get(0);
            this.hitPoint = Integer.parseInt(savedValue.get(1));
            this.strength = Integer.parseInt(savedValue.get(2));
        }

    }
}
