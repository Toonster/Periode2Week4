package be.kdg.person.linkedlist;

import be.kdg.person.Person;
import be.kdg.person.PersonComparable;
import be.kdg.person.PersonComparator;

import java.util.*;

public class LinkedListManager
{
    // Declaratie van een lijst van Strings.
    private LinkedList<String> listOfNames = null;

    public LinkedListManager()
    {
        listOfNames = new LinkedList<>();

        listOfNames.add("Casper");
        listOfNames.add("Rafael");
        listOfNames.add("Barbara");
        listOfNames.add("Bart");
        listOfNames.add("Geertrui");
    }

    public void doStuff()
    {
        System.out.println("De listOfNames:");
        printLinkedList(listOfNames);

        // Print de huidige size van de linkedlist.
        System.out.println("\nSize of listOfNames: " + listOfNames.size());

        // addFirst
        System.out.println("\nVoor addFirst:");
        printLinkedList(listOfNames);
        listOfNames.addFirst("Wouter");
        System.out.println("Na addFirst:");
        printLinkedList(listOfNames);

        // addLast
        System.out.println("\nVoor addLast:");
        printLinkedList(listOfNames);
        listOfNames.addLast("Bram");
        System.out.println("Na addLast:");
        printLinkedList(listOfNames);

        // addAll
        // Maak eerst een newList, en voeg die achteraan listOfNames toe.
        LinkedList<String> newList = new LinkedList<>();
        newList.add("Ron");
        newList.add("Kaat");
        System.out.println("\nlistOfNames voor addAll:");
        printLinkedList(listOfNames);
        listOfNames.addAll(newList);
        System.out.println("listOfNames na addAll:");
        printLinkedList(listOfNames);

        // set overschrijft het element op de opgegeven index
        System.out.println("\nlistOfNames voor set:");
        printLinkedList(listOfNames);
        listOfNames.set(2, "Pat");
        System.out.println("\nlistOfNames na set:");
        printLinkedList(listOfNames);

        // remove an element
        System.out.println("\nlistOfNames voor remove element met index 2:");
        printLinkedList(listOfNames);
        listOfNames.remove(2);
        System.out.println("\nlistOfNames na remove element met index 2:");
        printLinkedList(listOfNames);

        // Print the listOfNames in reverse order
        System.out.println("\nlistOfNames in reverse:");
        printLinkedListReverse(listOfNames);

        // subList
        List<String> subList = listOfNames.subList(2, 5);
        System.out.println("\nSublist from 2 to 5: 3 elementen (index 2, 3  en 4):");
        printLinkedList(subList);
        System.out.println("listOfNames na subList:");
        printLinkedList(listOfNames);

        // clear
        subList.clear();
        System.out.println("\nsublist na clear:");
        printLinkedList(subList);
    }

    // Omzetten van een array van strings naar een List van strings.
    public void convertArrayToLinkedList()
    {
        String[] arrayOfStrings = {"Marleen", "Wouter", "Pat", "Ron", "Kaat"};
        LinkedList<String> listOfNamesLocal;

        // Static call van asList.
        listOfNamesLocal = new LinkedList<>(Arrays.asList(arrayOfStrings));
        System.out.println("\nDe array omgezet naar een LinkedList.");
        printLinkedList(listOfNamesLocal);
    }

    // Omzetten van een linkedList van strings naar een array van strings.
    public void convertLinkedListToArray()
    {
        LinkedList<String> listOfNamesLocal = new LinkedList<>();
        String[] arrayOfStrings = new String[5];

        listOfNamesLocal.add("Marleen");
        listOfNamesLocal.add("Wouter");
        listOfNamesLocal.add("Pat");
        listOfNamesLocal.add("Ron");
        listOfNamesLocal.add("Kaat");

        // Note : compacte syntax
        arrayOfStrings = listOfNamesLocal.toArray(new String[listOfNamesLocal.size()]);
        System.out.println("\nDe LinkedList omgezet naar een array.");
        printLinkedList(listOfNamesLocal);
    }

    // Sorteer alfabetisch : default sort order.
    public void sortLinkedList()
    {
        LinkedList<String> listOfNamesLocal = new LinkedList<>();

        listOfNamesLocal.add("Marleen");
        listOfNamesLocal.add("Wouter");
        listOfNamesLocal.add("Pat");
        listOfNamesLocal.add("Ron");
        listOfNamesLocal.add("Kaat");

        System.out.println("\nVoor default sort:");
        printLinkedList(listOfNamesLocal);
        Collections.sort(listOfNamesLocal);
        System.out.println("Na default sort:");
        printLinkedList(listOfNamesLocal);
    }

    // Sorteer volgens eigen criterium : de length van een persoon.
    // 1st manier : comparator
    public void sortPersonsWithComparator()
    {
        LinkedList<Person> listOfPersons = new LinkedList<>();
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
        LinkedList<PersonComparable> listOfPersons = new LinkedList<>();
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
    public void printLinkedList(List<String> list)
    {
        System.out.println("linkedList = -----------------------------------");
        // Eerste manier : met een iterator.
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println("\tName: " + iterator.next());
        }

        // Tweede manier : met een forloop
        // for (Object name : list)
        // {
        //      System.out.println("Name :\t" + name);
        // }
    }

    // Zet eerst de iterator achteraan de lijst.
    public void printLinkedListReverse(List<String> list)
    {
        System.out.println("linkedList Reverse = -----------------------------------");
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious())
        {
            System.out.println("\tName: " + iterator.previous());
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
