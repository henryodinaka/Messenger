package com.leo.henry.messenger.lecture.thread;

public class PolitePerson {
    public static void main(String[] args) {
        Person jane = new Person("Jane");
        Person john = new Person("John");
        //Deadlock will occur because the thread are holding a lock on each of the objects
        new Thread(() -> jane.sayHello(john)).start();
        new Thread(() -> john.sayHello(jane)).start();

    }
    static class Person {
        private final String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public synchronized void sayHello(Person person){
            System.out.format("%s: %s"+"has said hello to me!%n",this.name,person.getName());
            person.sayHelloBack(this);
        }
        public synchronized void sayHelloBack(Person person){
            System.out.format("%s: %s"+"has said hello back to me!%n",this.name,person.getName());
        }
    }
}
