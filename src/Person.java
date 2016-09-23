public class Person implements Human, Comparable<Person> {
    private int age; //Instance variable
    private int height;
    private static int serialNum = 0; //Class variable
    private String name;
    public final static int LUCKY_NUMBER = 7;
    private int id;

    public static void showSerialNum(){
        System.out.println("Static method");
        System.out.println(serialNum);
        //System.out.println(name);//this will fail(name is not a static variable)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override // Since class person, does not have a natural order, this is required
    public int compareTo(Person p1){
        if(this.age < p1.age){
            return -1;
        }
        else if(this.age > p1.age){
            return 1;
        }

        return 0;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.height = 150;
        id = serialNum; //Each instance will have a unique id
        serialNum++;

    }

    //Method/constructor overloading
    public Person(){
        System.out.println("Running the constructor with no parameters");
        this.name = "Harry";

        this.age = 12;
        this.height = 144;
        serialNum++;
    }

    //Constructor can call other constructor
    public Person(int age){
        this("Default name", age);
    }

    public void printInfo(){
        //Instance methods can access static variables
        System.out.println("This person's name is " + name + ". Sno: " + serialNum);
    }

    public String toString(){
        //String representation of the object
        StringBuilder sb = new StringBuilder();
        sb.append("My name is ").append(name).append(". My age is ").append(age);
        return(sb.toString());

    }

}
