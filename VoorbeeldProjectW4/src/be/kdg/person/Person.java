package be.kdg.person;

// Class die gebruikt wordt voor je eigen custom sort.
// Basis functionaliteit.
// Sort op de lengte van personen.

public class Person
{
    private int length;
    private String name;

    public Person(int length, String name)
    {
        this.length = length;
        this.name = name;
    }

    public int getLength()
    {
        return length;
    }

    @Override
    public String toString()
    {
        return String.format("Persoon: %-8s heeft als lengte: %3d", name, length) ;
    }
}
