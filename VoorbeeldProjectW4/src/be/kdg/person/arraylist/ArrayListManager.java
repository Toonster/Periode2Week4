package be.kdg.person.arraylist;

import be.kdg.person.Person;
import be.kdg.person.PersonComparable;
import be.kdg.person.PersonComparator;

import java.util.*;

// Bekijk eerst de utility methods, onderaan in de class.

public class ArrayListManager
{
    // Declaratie van een lijst van Strings (type staat tussen <>).
    private ArrayList<String> listOfNames = null;

    public ArrayListManager()
    {
        System.out.println("In de constructor : aanmaken en initialiseren van nieuwe ArrayList.\n");
        listOfNames = new ArrayList<>();

        listOfNames.add("Casper");
        listOfNames.add("Rafael");
        listOfNames.add("Barbara");
        listOfNames.add("Bart");
        listOfNames.add("Pat");
    }

    public void doStuff()
    {
        // Print de huidige size van de arraylist.
        System.out.println("Size of listOfNames: " + listOfNames.size());

        // Get an element via index, beginnend van 0.
        System.out.println("Get second element: " + listOfNames.get(1));

        // Vervang een element door een nieuw element. Deze method returnt het element dat vervangen wordt.
        System.out.println("\nVoor call van set.");
        printArrayList(listOfNames);
        System.out.println("Set second element to \"Bart\", het element dat gereturned wordt: " + listOfNames.set(1, "Bart"));
        System.out.println("Na call van set.");
        printArrayList(listOfNames);

        // Contains.
        System.out.println("\nZit element \"Bart\" in de list ? :\t" + listOfNames.contains("Bart"));
        System.out.println("Zit element \"Bram\" in de list ? :\t" + listOfNames.contains("Bram"));

        // Remove.
        listOfNames.remove(1);
        System.out.println("\nNa remove van element met index 1.");
        printArrayList(listOfNames);
    }

    // Omzetten van een array van strings naar een List van strings.
    // Gaat enkel met List, niet met ArrayList, omdat asList een List returnt.
    public void convertArrayToArrayList()
    {
        String[] arrayOfStrings = {"Marleen", "Wouter", "Pat", "Ron", "Kaat"};
        List<String> listOfNamesLocal;

        // Static call van asList.
        listOfNamesLocal = Arrays.asList(arrayOfStrings);
        System.out.println("\nDe array omgezet naar een ArrayList.");
        printArrayList(listOfNamesLocal);
    }

    // Omzetten van een arraylist van strings naar een array van strings.
    public void convertArrayListToArray()
    {
        List<String> localListOfNames = new ArrayList<>();
        String[] arrayOfStrings;

        localListOfNames.add("Marleen");
        localListOfNames.add("Wouter");
        localListOfNames.add("Pat");
        localListOfNames.add("Ron");
        localListOfNames.add("Kaat");

        // Note : compacte syntax
        arrayOfStrings = localListOfNames.toArray(new String[localListOfNames.size()]);
        System.out.println("\nDe ArrayList omgezet naar een array.");
        printArray(arrayOfStrings);
    }

    // Sorteer alfabetisch : default sort order bij strings.
    public void sortArrayList()
    {
        ArrayList<String> localListOfNames = new ArrayList<>();

        localListOfNames.add("Marleen");
        localListOfNames.add("Wouter");
        localListOfNames.add("Pat");
        localListOfNames.add("Ron");
        localListOfNames.add("Kaat");

        System.out.println("\nVoor default sort:");
        printArrayList(localListOfNames);
        Collections.sort(localListOfNames);
        System.out.println("Na default sort:");
        printArrayList(localListOfNames);
    }

    // Sorteer volgens eigen criterium : de length van een persoon.
    // 1st manier : comparator
    public void sortPersonsWithComparator()
    {
        ArrayList<Person> listOfPersons = new ArrayList<>();
        listOfPersons.add(new Person(175, "Casper"));
        listOfPersons.add(new Person(194, "Rafael"));
        listOfPersons.add(new Person(170, "Barbara"));
        listOfPersons.add(new Person(161, "Bart"));
        listOfPersons.add(new Person(168, "Geertrui"));

        System.out.println("\nVoor comparator sort:");
        printPersonsComparator(listOfPersons);
        Collections.sort(listOfPersons, new PersonComparator());
        System.out.println("Na comparator sort:");
        printPersonsComparator(listOfPersons);
    }

    // Sorteer volgens eigen criterium : de length van een persoon.
    // 2de manier : comparable
    public void sortPersonsWithComparable()
    {
        ArrayList<PersonComparable> listOfPersons = new ArrayList<>();
        listOfPersons.add(new PersonComparable(175, "Casper"));
        listOfPersons.add(new PersonComparable(194, "Rafael"));
        listOfPersons.add(new PersonComparable(170, "Barbara"));
        listOfPersons.add(new PersonComparable(161, "Bart"));
        listOfPersons.add(new PersonComparable(168, "Geertrui"));

        System.out.println("\nVoor comparable sort:");
        printPersonsComparable(listOfPersons);
        Collections.sort(listOfPersons);
        System.out.println("Na comparable sort:");
        printPersonsComparable(listOfPersons);
    }

    // Heel nuttige methods (utility methods), altijd eerst schrijven !
    public void printArrayList(List<String> list)
    {
        System.out.println("ArrayList = -----------------------------------");
        // Eerste manier : met een iterator van de class ArrayList.
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println("\tName: " + iterator.next());
        }

        // Tweede manier : met een forloop
        // for (String name : list)
        // {
        //     System.out.println("Name :\t" + name);
        // }
    }

    public void printArray(String[] array)
    {
        System.out.println("Array = ---------------------------------------");
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("\tName: " + array[i]);
        }
    }

    public void printPersonsComparator(List<Person> list)
    {
        System.out.println("Persons = -----------------------------------");
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
    }

    public void printPersonsComparable(List<PersonComparable> list)
    {
        System.out.println("Persons = -----------------------------------");
        Iterator<PersonComparable> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
    }
}
