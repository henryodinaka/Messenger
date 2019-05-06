package com.leo.henry.messenger.lecture.lamdaExpression;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
/*

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is anonymous thread without lamda expression");
            }
        }).start();
*/

       /* new Thread(() -> {
            System.out.printf("This is anonymous Thread with lamda");
            System.out.println("this is the second, Just Trying to execute multiple lines");
        }).start();
*/

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

        /*Collections.sort(employees,Comparator.comparing(Employee::getName));
        for (Employee employee: employees){
            System.out.println(employee.getName());
        }*/

       // System.out.println(jane.getClassName());
      /*  System.out.println("This is from forEach block");
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });*/
      Employee.printEmployeeByAge(employees,"Employee age below 25",employee -> employee.getAge()< 25);
//      Employee.printEmployeeByAge(employees,"Employee age above 25",employee -> employee.getAge()> 25);
        Employee.printStream(employees,"Employees name starting with: ","J");

        System.out.println("===================================");
        Department hr = new Department("Human resources");
        hr.addEmployee(jane);
         hr.addEmployee(paul);
         hr.addEmployee(john);
        Department accounting  = new Department("Accounting");
        accounting.addEmployee(josh);
        accounting.addEmployee(jane);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        Employee.streamCollect(employees,"P");
        Employee.streamReduce(departments);
        Employee.streamFlatMap(departments);



    }


}

@Data
@AllArgsConstructor
class Employee{
    private String name;
    private int age;
    public String getClassName(){
        return "The class name called is "+ getClass().getSimpleName();
    }
    public static void printEmployeeByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        for (Employee employee: employees){
            if (ageCondition.test(employee))
                System.out.println(employee.getName().substring(0,employee.getName().indexOf(' ')));
                System.out.println(employee.getName().substring(0,2));
        }
    }
    public static void printStream(List<Employee> employees,String text,String filter){
        System.out.println(text+filter);

        employees
                .stream()
                .map(Employee::getName)
                .filter(s->s.startsWith(filter))
                .sorted()
                .forEach(System.out::println);
    }

    public static void streamCollect(List<Employee> employees,String filter){
        System.out.println("From streamCollect method"+filter);

        List<String> sortedList = employees
                .stream()
                .map(Employee::getName)
                .filter(s -> s.startsWith(filter))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        for (String s:sortedList ){
            System.out.println(s);
        }
    }

    public static void streamReduce(List<Department> departments){
        System.out.println("Returning employee with the youngest age");
            departments
                .stream()
                .flatMap(department ->department.getEmployees().stream())
                .reduce((e1,e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

    }

    public static void streamFlatMap(List<Department> departments) {
        System.out.println("Printing all employees in a department Using stream and flatMap");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
    }
    @Override
    public String toString() {
        return name ;
    }
}