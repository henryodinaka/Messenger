package com.leo.henry.messenger.lecture.abstractClass;

public abstract class Bird extends Animal implements CanFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName()+" is eating");

    }

    @Override
    public void breath() {
        System.out.println("Breath in, breath out");

    }

    @Override
    public void fly() {
        System.out.println(getName()+" is flapping it's wings");
    }
}
