package be.kdg.person.linkedlist;

public class TestLinkedList
{
    public static void main(String[] args)
    {
        LinkedListManager linkedListManager = new LinkedListManager();

        linkedListManager.doStuff();

        linkedListManager.convertArrayToLinkedList();
        linkedListManager.convertLinkedListToArray();

        // Sorteren : 3 manieren
        // 1. Sort by default order
        linkedListManager.sortLinkedList();

        // 2. Sort using Comparator
        linkedListManager.sortPersonsWithComparator();

        // 3. Sort using Comparable
        linkedListManager.sortPersonsWithComparable();
    }
}
