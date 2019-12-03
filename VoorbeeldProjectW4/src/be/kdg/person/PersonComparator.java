package be.kdg.person;

import java.util.Comparator;

// Class die gebruikt wordt om personen te sorteren op lengte.
// Implementeert interface Comparator, waarin slechts 1 method zit.
// Je moet de class waarop je wil sorteren meegeven in het prototype van de interface : Comparator<Person>

public class PersonComparator implements Comparator<Person>
{
    public int compare(Person person, Person otherPerson)
    {
        // Zo deden we het vroeger :
        // return person.getLength() - otherPerson.getLength();
        return Integer.compare(person.getLength(), otherPerson.getLength());
     }
}
