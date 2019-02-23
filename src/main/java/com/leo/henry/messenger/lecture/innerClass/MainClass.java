package com.leo.henry.messenger.lecture.innerClass;

public class MainClass {
    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
       mcLaren.operateClutch(true);
       mcLaren.chagneGear(1);
       mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.operateClutch(true);
        mcLaren.chagneGear(2);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.chagneGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));
    }
}
