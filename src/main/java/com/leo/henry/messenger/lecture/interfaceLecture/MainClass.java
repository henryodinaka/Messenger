package com.leo.henry.messenger.lecture.interfaceLecture;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Player tim = new Player("Tim",10,15);
        System.out.println(tim);
        saveObject(tim);
        tim.setHitPoint(8);
        System.out.println("Stormbringer ");
        saveObject(tim);
        loadObject(tim);
        System.out.println(tim);

        ISavable monster = new Monster("Werewolf",20,40);
        System.out.println(monster);
        saveObject(monster);
        ((Monster )monster).setHitPoint(9);
        System.out.println("The great monster ");
        saveObject(monster);
        loadObject(monster);
        System.out.println(monster);
    }

    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choese\n 1 to enter a string\n 0 to quit");
        while ((!quit))
        {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index,stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
    public static void saveObject(ISavable objectToSaved){
        for (String value : objectToSaved.write())
        {
            System.out.println("Saving "+ value + " to storage device");
        }
    }
    public static void loadObject(ISavable iSavable)
    {
        ArrayList<String> values = readValues();
        iSavable.read(values);
    }
}
