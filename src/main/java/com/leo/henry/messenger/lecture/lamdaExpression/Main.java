package com.leo.henry.messenger.lecture.lamdaExpression;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is anonymous thread without lamda expression");
            }
        }).start();

        new Thread(() -> {
            System.out.printf("This is anonymous Thread with lamda");
            System.out.println("this is the second, Just Trying to execute multiple lines");
        }).start();


        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Wall", 21);
        Employee josh = new Employee("Josh Posh", 40);
        Employee paul = new Employee("Paul Allen", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(jane);
        employees.add(josh);
        employees.add(paul);

       /* Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return employee.getName().compareTo(t1.getName());
            }
        });*/

       /*Collections.sort(employees,( e1, e2) -> e1.getName().compareTo(e2.getName()));
        for (Employee employee: employees){
            System.out.println(employee.getName());
        }*/

        Collections.sort(employees,Comparator.comparing(Employee::getName));
        for (Employee employee: employees){
            System.out.println(employee.getName());
        }
    }
}

@Data
@AllArgsConstructor
class Employee{
    private String name;
    private int age;
}