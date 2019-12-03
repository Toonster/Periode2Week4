import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Kaart {

    List<Drank> dranken = new LinkedList<>();

    public void voegDrankToe(Drank drank) {
        dranken.add(drank);
    }

    public void voegDrankenToe(Drank[] dranken) {
        this.dranken.addAll(Arrays.asList(dranken));
    }

    public int getAantal() {
        return dranken.size();
    }

    public double getTotaleprijs() {
        double totaleprijs = 0;
        for (Drank drank : dranken) {
            totaleprijs += drank.getPrijs();
        }
        return totaleprijs;
    }

    @Override
    public String toString() {
        return String.format("Kaart: %s\n", dranken);
    }

    public void verwijderDuurderDan(int waarde) {
        dranken.removeIf(drank -> drank.getPrijs() > waarde);
    }

    public Drank duurste() {
        Drank duurste = dranken.get(0);
        for (Drank drank : dranken) {
            if (drank.getPrijs() > duurste.getPrijs()) {
                duurste = drank;
            }
        }
        return duurste;
    }

    public List<Drank> getAlcoholischeDranken() {
        List<Drank> alchoholischeDranken = new ArrayList<>();
        for (Drank drank : dranken) {
            if (drank.isAlcoholisch()) {
                alchoholischeDranken.add(drank);
            }
        }
        return alchoholischeDranken;
    }

/*    public void sorteer() {
        Drank duurste = dranken.get(0);
        for (int i = 1; i < dranken.size(); i++) {
            if (dranken.get(i).getPrijs() >= duurste.getPrijs()) {
                dranken.add(0, dranken.get(i));
                dranken.remove(i + 1);
                duurste = dranken.get(i);
            }
        }
    }*/
}
