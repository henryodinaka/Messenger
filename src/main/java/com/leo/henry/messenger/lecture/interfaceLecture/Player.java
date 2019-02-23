package com.leo.henry.messenger.lecture.interfaceLecture;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Player implements  ISavable {
    private String name;
    private int hitPoint;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoint, int strength) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.strength = strength;
        this.weapon = "Soard";
    }

    @Override
    public List<String> write() {
        List<String > values = new ArrayList<>();
        values.add(0,this.name);
        values.add(1,""+this.hitPoint);
        values.add(2,""+this.strength);
        values.add(3,this.weapon);
        return values;
    }

    @Override
    public void read(List<String> savedValue) {
        if (savedValue !=null && savedValue.size()!=0)
        {
            this.name = savedValue.get(0);
            this.hitPoint = Integer.parseInt(savedValue.get(1));
            this.strength = Integer.parseInt(savedValue.get(2));
            this.weapon = savedValue.get(3);
        }
    }
}
