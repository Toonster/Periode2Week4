package be.kdg.person.arraylist;

public class TestArrayList
{
    public static void main(String[] args)
    {
        ArrayListManager arrayListManager = new ArrayListManager();

        arrayListManager.doStuff();

        // arrayListManager.convertArrayToArrayList();
        // arrayListManager.convertArrayListToArray();

        // Sorteren : 3 manieren
        // 1. Sort by default order
        // arrayListManager.sortArrayList();

        // 2. Sort using Comparator
        arrayListManager.sortPersonsWithComparator();

        // 3. Sort using Comparable
        // arrayListManager.sortPersonsWithComparable();
    }
}
