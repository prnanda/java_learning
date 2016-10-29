package Generics;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);

    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    public int getAge(){return age;}

    public String getName(){return name;}




}
