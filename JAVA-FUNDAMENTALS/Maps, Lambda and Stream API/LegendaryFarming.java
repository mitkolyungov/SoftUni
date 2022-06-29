import java.util.*;

public class LegendaryFarming {

    static final String shards = "shards";
    static final String fragments = "fragments";
    static final String motes = "motes";

    static Map<String, Integer> keyMaterials = new LinkedHashMap<> ();

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Integer> junkMaterials = new LinkedHashMap<> ();

        keyMaterials.put (shards, 0);
        keyMaterials.put (fragments, 0);
        keyMaterials.put (motes, 0);

        boolean isRunning = true;
        do {

            String[] info = scanner.nextLine ().split ("\\s+");

            for (int i = 0; i < info.length; i += 2) {
                String material = info[i + 1].toLowerCase ();
                int quantity = Integer.parseInt (info[i]);

                if (keyMaterials.containsKey (material)) {
                    keyMaterials.put (material, keyMaterials.get (material) + quantity);

                    if (isThereAWinner (material)) {
                        isRunning = false;
                        break;
                    }

                } else {
                    junkMaterials.putIfAbsent (material, 0);
                    junkMaterials.put (material, junkMaterials.get (material) + quantity);
                }
            }

        } while (isRunning);

        keyMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

        junkMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static boolean isThereAWinner(String material) {
        switch (material) {
            case shards: {
                return isShadowmourneWinner ();
            }
            case fragments: {
                return isValanyrWinner ();
            }
            case motes: {
                return isDragonwrathWinner ();
            }
        }

        return false;
    }

    private static boolean isDragonwrathWinner() {
        if (keyMaterials.get (motes) >= 250) {
            keyMaterials.put (motes, keyMaterials.get (motes) - 250);
            System.out.printf ("%s obtained!%n", "Dragonwrath");
            return true;
        }
        return false;
    }

    private static boolean isValanyrWinner() {
        if (keyMaterials.get (fragments) >= 250) {
            keyMaterials.put (fragments, keyMaterials.get (fragments) - 250);
            System.out.printf ("%s obtained!%n", "Valanyr");
            return true;
        }
        return false;
    }

    private static boolean isShadowmourneWinner() {
        if (keyMaterials.get (shards) >= 250) {
            keyMaterials.put (shards, keyMaterials.get (shards) - 250);
            System.out.printf ("%s obtained!%n", "Shadowmourne");
            return true;
        }
        return false;
    }
}
