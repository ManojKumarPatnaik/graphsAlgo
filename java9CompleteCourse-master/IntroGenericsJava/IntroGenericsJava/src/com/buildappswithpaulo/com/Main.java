package com.buildappswithpaulo.com;

class Person {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Login<T> {
    private T name;
    private T password;

    public Login(T name, T password) {
        this.name = name;
        this.password = password;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getPassword() {
        return password;
    }

    public void setPassword(T password) {
        this.password = password;
    }
}



public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        person.setName("James");
        person.setPassword("Password");


         Login<String> login = new Login<>("Paul", "password");

         Login<Integer> login1 = new Login<>(23, 43);

         Login<Person> login2 = new Login<>(person, person);

         Login<Boolean> login3 = new Login<>(true, true);

         System.out.println(login2.getName().getName() + ", " + login2.getName().getPassword());

    }
}
