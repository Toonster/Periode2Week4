import java.util.*;

public class Woorden {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type een zin: ");
        String zin = input.nextLine();
        final String[] woorden = zin.split("[ ,.!?]");
        List<String> lijst1 = voegWoordenToe(woorden);
        List<String> lijst2 = voegWoordenToeRandom(lijst1);
        StringBuilder output = new StringBuilder();
        output.append(lijst2.get(0).substring(0, 1).toUpperCase()).append(lijst2.get(0).substring(1));
        for (int i = 1; i < lijst2.size(); i++) {
            output.append(" ").append(lijst2.get(i));
        }
        System.out.println(output);
    }

    public static List<String> voegWoordenToe(String[] woorden) {
        List<String> lijstMetWoorden = new LinkedList<>();
        Collections.addAll(lijstMetWoorden, woorden);
        return lijstMetWoorden;
    }

    public static List<String> voegWoordenToeRandom(List<String> lijst) {
        List<String> lijstMetWoordenRandom = new ArrayList<>();
        Random random = new Random();
        for (Iterator<String> iterator = lijst.iterator(); iterator.hasNext(); ) {
            int randomIndex = random.nextInt(lijst.size());
            lijstMetWoordenRandom.add(lijst.get(randomIndex));
            lijst.remove(randomIndex);
        }
        return lijstMetWoordenRandom;
    }
}
