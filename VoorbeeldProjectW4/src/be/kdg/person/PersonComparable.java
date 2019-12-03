package be.kdg.person;

// Class die gebruikt wordt om personen te sorteren op lengte.
// Implementeert interface Comparable.
// Je moet de class waarop je wil sorteren meegeven in het prototype van de interface : Comparable<PersonComparable>

public class PersonComparable implements Comparable<PersonComparable>
{
    private int length;
    private String name;

    public PersonComparable(int length, String name)
    {
        this.length = length;
        this.name = name;
    }

    public int compareTo(PersonComparable person)
    {
        // Zo deden we het vroeger :
        // return this.length - person.length;
        return Integer.compare(length, person.length);
    }

    @Override
    public String toString()
    {
        return String.format("Persoon: %-8s heeft als lengte: %3d", name, length) ;
    }
}
