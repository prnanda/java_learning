package Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Im in the main of the java class");

        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person burtCopper = new Person("Burt Cooper", 100);

        //Person[] madMen = {donDraper, peggyOlson};
        //System.out.println(Arrays.toString(madMen));

        // It's hard to add elements to an array and no easy to check for membership
        List<Person> madMen = new ArrayList<>();

        // Easy to add elements to the list
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(burtCopper);

        System.out.println(madMen);

        // Type safety: The following will result in a compile error
        // madMen.add(new Object());

        System.out.println(madMen.get(0));

        for(Person person: madMen){
            System.out.println(person);
        }

        // Sets can only have unique items
        Set<Person> madMenSet = new HashSet<>();
        madMenSet.add(donDraper);
        madMenSet.add(peggyOlson);

        // We can iterate over a set same as a list
        System.out.println("\nSet:");
        for(Person madMan: madMenSet){
            System.out.println(madMan);
        }

        // No get method(since the elements are not ordered)
        //madMenSet.get(0);

        madMenSet.add(donDraper); //Duplicate will be ignored
        System.out.println(madMenSet);

        System.out.println(madMenSet.contains(burtCopper));

        // Maps, dictionaries have two generic parameters(key, value)
        Map<String, Person> madMenMap = new HashMap<>();

        madMenMap.put(donDraper.getName(), donDraper);
        madMenMap.put(peggyOlson.getName(), peggyOlson);

        System.out.println(madMenMap.get("Peggy Olson"));

        // Iterating over a map
        for(Map.Entry<String, Person> entry: madMenMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // We need a comparator to sort the persons
        Collections.sort(madMen, new AgeComparator());
        System.out.println(madMen);

        final Person youngestCastMember = min(madMen, new AgeComparator());
        System.out.println("\nThe youngest cast member is: ");
        System.out.println(youngestCastMember);
    }

    public static <T> T min(List<T> values, Comparator<T> comparator){
       T lowestElement = values.get(0);
       for (int i=0;i<values.size();i++){
           final T element = values.get(i);

           if(comparator.compare(element, lowestElement) < 0){
               lowestElement = element;
           }
       }

       return lowestElement;
    }


}
