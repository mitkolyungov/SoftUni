import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int plantsCount = Integer.parseInt (scanner.nextLine ());

        List<Integer> plantsList = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());

        ArrayDeque<Integer> tempStack = new ArrayDeque<> ();

        int dayCounter = 0;


        while (true) {

            dayCounter++;
            boolean isDead = false;

            // it is for saving the plants with more GMO
            for (int i = 0; i < plantsCount - 1; i++) {

                if (plantsList.get (i + 1) > plantsList.get (i)) {
                    tempStack.push (i + 1);
                    isDead = true;
                }
            }


            // it is for removing the plants
            int deadCount = tempStack.size ();
            for (int i = 0; i < deadCount; i++) {
                int index = tempStack.poll ();
                plantsList.remove (index);
            }

            plantsCount = plantsList.size ();

            // it is for checking if it is found another plant
            if (!isDead) {
                System.out.println (dayCounter - 1);
                break;
            }
        }
    }
}
