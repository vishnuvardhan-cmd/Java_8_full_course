package com.dailycodelearner;

public class Employee implements Comparable<Employee>{
    public int id;
    public String name;
    public int age;
    public long salary;

    public String dep;

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getDep() {
        return dep;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, int age, long salary, String dep) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dep='" + dep + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if(id==o.id){

            return 0;
        }
        else if(id>o.id){
            return 1;
        }
        else{
            return -1;
        }
    }
}