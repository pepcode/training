package pep.training.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectSortExample {

    public static void main(String args[]) {

        List<Person> persons = new ArrayList<Person>();
        persons.add( new Person("praveen", 37));
        persons.add( new Person("Charanya", 34));
        persons.add( new Person("Prajith", 9));
        persons.add( new Person("Kosal", 7));

        Collections.sort(persons);

        System.out.println(persons.toString());

    }
    
}

class Person implements Comparable<Person> {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return name + " : " + age;
    }


    @Override
    public int compareTo(Person o) {
        //return Comparators.NAME.compare(this, (Person)o);
    	return Comparators.AGE.compare(this, o);
    }

    public static class Comparators {

        public static Comparator<Person> NAME = new Comparator<Person> () {

            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        };

        public static Comparator<Person> AGE = new Comparator<Person> () {

            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        };

        public static Comparator<Person> PERSON = new Comparator<Person> () {

            public int compare(Person p1, Person p2) {
                int i = p1.name.compareTo(p2.name);
                if(i == 0) {
                    i = p1.age - p2.age;
                }
                return i;
            }
        };


    }


}


