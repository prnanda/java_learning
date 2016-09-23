import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import ocean.Fish;


public class Main {
    public static void main(String[] args) {

        System.out.println("Pranay");

        //Boolean
        boolean myBool = false;

        //Array List

        ArrayList<Integer> weeklyTemperatures = new ArrayList<Integer>();
        System.out.println(weeklyTemperatures.isEmpty());

        weeklyTemperatures.add(10);
        weeklyTemperatures.add(90);


        //System.out.println(weeklyTemperatures);
        System.out.println(weeklyTemperatures.isEmpty());
        System.out.println(weeklyTemperatures.size());

        for(int temperature: weeklyTemperatures){
            System.out.println(temperature);
        }

        //Hash Map = dictionary

        HashMap<String, Integer> firstHashMap = new HashMap<String, Integer>();
        firstHashMap.put("Pizza", 10);
        firstHashMap.put("Naan", 5);
        firstHashMap.put("Pasta", 7);

        System.out.println(firstHashMap);

        //Instantiate the droid class
        Droid myDroid = new Droid();
        System.out.println(myDroid.checkBatteryLevel());

        //String
        String myName = "Pranay Nanda";
        System.out.println(myName);
        String blank = "";

        //Strings can be concatenated using the + operator
        blank = "Hello" + myName;

        System.out.println(blank.length());

        //Arrays
        int[] firstArray = new int[3];
        int[] secondArray = {5,6,7};
        System.out.println(secondArray);

        for (int i=0;i<secondArray.length;i++){
            System.out.println(secondArray[i]);
        }

        //Array of string
        String[] myStringArray = new String[3];

        myStringArray[0] = "Hello";
        myStringArray[1] = "to";
        myStringArray[2] = "you";

        String[] fruits = {"Banana", "Kiwi", "Apple"};

        for(String fruit: fruits){
            System.out.println(fruit);
        }

        //Values and references
        int value = 0; //Primitive data type, this allocates memory

        String text; //Non-primitive data type, no memory is allocated(don't know the length of string yet)
        //This is just allocating memory for holding a reference with default value null

        String[] texts = new String[2]; //Allocating memory only for references
        System.out.println(texts[0]); //Java sets all indexes to value of null by default

        texts[0]="one";
        System.out.println(texts[0]);

        //Multi dimensional arrays(array of arrays)
        int[][] grid = {{3,5,43},
                {2,4},
                {1,2,3,4}
        };

        System.out.println(grid[1][1]);

        String[][] text1 = new String[2][3];
        System.out.println(text1[0][0]);

        //Classes and Objects
        Person person1 = new Person("Harpreet",12);
        person1.printInfo();

        Person person2 = new Person("Tom", 22);
        person2.printInfo();

        Person person3 = new Person();
        person3.printInfo();

        Person person4 = new Person(15);
        person4.printInfo();

        Person.showSerialNum();
        System.out.println(Person.LUCKY_NUMBER);

        //Innefficient - New string is created every time we append since Strings are immutable
        String info = "";
        info+="My name is";
        info+=" bob, the builder";

        System.out.println(info);

        //More Efficient
        StringBuilder sb = new StringBuilder("");
        sb.append("My name is Sue. ");
        sb.append(" ");

        System.out.println(sb.toString());


        //Formatting
        System.out.println("Here is some text. \tThat was a tab\nThat's a newline");

        //Print Format
        System.out.printf("Total cost %d; quantity is %d\n", 5, 120);

        System.out.printf("Total cost %.2f;\n", 0.766886);

        //toString method
        //All objects in Java have the Object class as their ultimate parent

        Object obj = new Object();
        System.out.println(obj.toString());

        System.out.println(person2.toString());

        //Packages
        Fish fish = new Fish();
        System.out.println(fish.toString());

        //Casting
        byte byteVal = 20;
        short shortVal =55;
        int intValue = 888;
        long longValue = 23555;

        float floatVal = 8834.8f;
        double doubleVal = 32.4;

        //intValue = doubleVal; //Error
        intValue = (int)longValue; //This works
        System.out.println(intValue);

        doubleVal = intValue; //Works fine since double can hold a larger value than int
        System.out.println(doubleVal);

        intValue = (int)floatVal; //Casting required
        System.out.println(intValue); //No rounding, just removes the decimal

        byteVal = (byte)128; //Be careful, can't predict the outcome since 128 is too big for byte
        System.out.println(byteVal);


        //Generics
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Cat");
        strings.add("Dog");

        //System.out.println(strings.get(1));

        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"Tom");

        showList(strings);

        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(new Person("Harry", 14));

        showList(people);

        //Anonymous class: This is a child class of machine, a class without a name
        Person crazyPerson = new Person("Crazy", 111){
          @Override public void printInfo(){
              System.out.println("I'm overriding the printinfo() using anonymous classes");
          }
        };
        crazyPerson.printInfo();

        //Instantiating an interface with an anonymous class implementation
        Human newPerson = new Human() {
            @Override
            public void printInfo() {
                System.out.println("Implementing the printinfo class required by the interface");

            }
        };

        newPerson.printInfo();



        //Exceptions
        File file = new File("test.txt");
        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e){
            System.out.println("\nCould not open the file!");
            e.printStackTrace();
        }

        /*
        //Run time exceptions

        int a = 9/0; //Divide by zero

        //Null pointer exception
        String text2 = null;
        System.out.println(text2.length());

        //Out of bound exception
        String[] texts4 = {"one", "two", "three"};
        System.out.println(texts4[4]); //ArrayIndexOutOfBoundsException */

        //Equals method
        String tex1 = "Hello";
        String tex2 = "Hello";
        System.out.println(tex1.equals(tex2)); //Don't use == for comparing non-primitive data types

        //tex1 == tex2; This only checks if the objects are pointing to the same address

        newPerson.equals(person1);

        //Inner(nested) classes - Robot java
        Robot robot = new Robot(1);
        robot.start();

        Robot.Battery battery = new Robot.Battery();
        battery.charge();

        //Enum
        Animal animal = Animal.CAT;

        switch (animal) {
            case CAT:
                break;
            case DOG:
                break;
            case MOUSE:
                break;
        }

        //CAT, DOG, MOUSE are actually considered objects of class animal
        System.out.println(Animal.DOG.getClass());
        System.out.println(animal.name());//Inbuilt function returns the STRING version

       //The Java collections framework
        //ArrayList

        ArrayList<Integer> numbers = new ArrayList<>();//Cannot use a primitive type(int, short etc)
        numbers.add(10);
        numbers.add(100);
        numbers.add(40);

        System.out.println(numbers.get(0));
        numbers.size();

        for(Integer num:numbers){
            System.out.println(num);
        }

        //HashMaps - Key, Value pair, not ordered
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(5, "Five");
        map1.put(8, "Eight");
        map1.put(6, "Six");
        map1.put(2, "Two");

        String text_eg = map1.get(5); //"Four"
        text_eg = map1.get(4); //null
        map1.put(6,"Hello"); //Overwrites previous key, value pair

        //Iterating over keys and values in a map
        for(Map.Entry<Integer, String> entry: map1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //Sets: Only unique elements
        Set<String> set1 = new HashSet<>(); //HashSet does not guarantee order
        set1.add("dog");
        set1.add("cat");
        set1.add("mouse");
        set1.add("dog");//Duplicate item is ignored
        set1.add("dear");

        System.out.println(set1);

        //Iteration
        for (String element: set1){
            System.out.println(element);
        }

        boolean cat;
        //Does set contain an item? Sets are optimized for search
        if(set1.contains("cat")){
            cat = true;
        }

        // Linked Lists

        ArrayList<Integer> arrayList = new ArrayList<>(); // Fast to add and remove items from the end
        LinkedList<Integer> linkedList = new LinkedList<>(); // Faster to add and remove items at
        // any position in a linkedlist

        //doTimings("ArrayList", arrayList);
        //doTimings("LinkedList", linkedList);

        // Using custom objects in Sets or as keys in Maps
        Map<String, Integer> map2 = new HashMap<>();


        // Keys have to be unique
        map2.put("one", 1);
        map2.put("two", 2);
        map2.put("three", 1);


        for(String key: map2.keySet()){
            System.out.println(key+ ": " + map2.get(key));
        }

        // A sets elements have to be unique as well
        Set<String> set = new LinkedHashSet<>();
        set.add("dog");
        set.add("cat");
        set.add("mouse");

        // In order to use a custom object (say Person) in the set or as a key in a map,
        // the equals and hash methods for that class need to be defined

        // Let's learn about comparators
        ArrayList<String> listToSort = new ArrayList<>();
        ArrayList<Integer> intListToSort = new ArrayList<>();

        listToSort.add("Pranay");
        listToSort.add("Tom");
        listToSort.add("This guy");
        listToSort.add("James");
        listToSort.add("Alonso");


        Collections.sort(listToSort); // If we don't supply a comparator, default is alphabetical
        System.out.println("\nRegular sort:");
        for(String name: listToSort){
            System.out.println(name);
        }

        Collections.sort(listToSort, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()){
                    return 1;
                }
                else if (o1.length() <= o2.length()){
                    return -1;
                }
                return 0;
            }
        });


        System.out.println("\nSorted based on length using comparator:");
        for(String name: listToSort){
            System.out.println(name);
        }

        // Natural Ordering
        List<String> listN = new ArrayList<>();
        SortedSet<String> setN = new TreeSet<>();

        addElements(listN);
        addElements(setN);
        System.out.println("\nUnsorted List: ");
        showElements(listN);
        System.out.println("\nSet: ");
        showElements(setN);

        Collections.sort(listN);
        System.out.println("\nSorted List: ");
        showElements(listN);

        // If we have a collection of custom objects, Eg: Person, we need to define the natural order
        // by implementing the Comparable interface and defining the compareTo class

        List<Person> listPeople = new ArrayList<>();
        listPeople.add(new Person("Joe", 10));
        listPeople.add(new Person("James", 20));
        listPeople.add(new Person("Jack", 18));
        listPeople.add(new Person("Dane", 23));
        listPeople.add(new Person("Pranay", 29));

        Collections.sort(listPeople); // This works because we defined a compareTo in Person
        System.out.println("\nSorted List of people: ");
        for (Person person: listPeople){
            System.out.println(person.toString());
        }

        // Queues

        Queue<Integer> q1 = new ArrayBlockingQueue<>(3);
        q1.add(10);
        q1.add(5);
        q1.add(6);

        try{
            q1.add(40);
        } catch (IllegalStateException e){
            System.out.println("\nQueue is already full");
        }

        for(Integer val: q1){
            System.out.println("Queue value: " + val);
        }

        Integer value1 = q1.remove(); // Removes from head
        System.out.println("Removed from queue: " + value1);

        System.out.println("Head of the queue is " + q1.element());

        // Iterators
        LinkedList<String> animals1 = new LinkedList<>();
        animals1.add("dog");
        animals1.add("cat");
        animals1.add("horse");

        Iterator<String> it = animals1.iterator();

        while (it.hasNext()) {
            String valIt = it.next();
            System.out.println(valIt);

            if(valIt.equals("cat")){
                it.remove();
            }
        }

        // Modern iteration, Java 5 +
        for(String animal1: animals1){
            System.out.println(animal1);
        }

        // Implementing the iterable interface

        UrlLibrary urlLibrary = new UrlLibrary();

        for(String url: urlLibrary){
            System.out.println(url);
        }

        // Lambda Expressions






    }

    //?: Wild card
    public static void showList(ArrayList<?> list){
        for(Object value: list){
            System.out.println(value);
        }
    }

    private static void doTimings(String type, List<Integer> list){
        for (int i=0; i<1E5; i++){
            list.add(i);
        }

        long start = System.currentTimeMillis();

        /*Add items at the end of the list
        for (int i=0;i<1E5;i++){
            list.add(i);
        }*/

        // Add items in the beginning of the list
        for (int i=0;i<1E5;i++) {
            list.add(0, i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-start) + " ms for " + type);



    }

    private static void addElements(Collection<String> col){
        col.add("Joe");
        col.add("Sue");
        col.add("Juliet");
        col.add("Claire");
        col.add("Mike");
    }

    private static void showElements(Collection<String> col){
        for(String name: col){
            System.out.println(name);
        }
    }
}
