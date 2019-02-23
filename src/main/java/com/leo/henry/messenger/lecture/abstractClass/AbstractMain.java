package com.leo.henry.messenger.lecture.abstractClass;

public class AbstractMain {
    public static void main(String[] args) {

        Parrot parrot = new Parrot("Jeo Pet");
        parrot.eat();
        parrot.breath();
        parrot.fly();
        Penguin penguin = new Penguin("Emperor");
        penguin.eat();
        penguin.breath();
        penguin.fly();
    }
}
