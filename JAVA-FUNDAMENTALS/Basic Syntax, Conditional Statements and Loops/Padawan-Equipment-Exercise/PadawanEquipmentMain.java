import java.util.Scanner;

public class PadawanEquipmentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        double amountOfMoney = Double.parseDouble (scanner.nextLine ());
        int countOfStudents = Integer.parseInt (scanner.nextLine ());
        double pricePerLightsaber = Double.parseDouble (scanner.nextLine ());
        double pricePerRobe = Double.parseDouble (scanner.nextLine ());
        double pricePerBelt = Double.parseDouble (scanner.nextLine ());

        double sumOfSabers = Math.ceil (countOfStudents * 1.1) * pricePerLightsaber;
        double sumOfBelts = (countOfStudents - countOfStudents / 6) * pricePerBelt;

        double totalSum = sumOfBelts + sumOfSabers + pricePerRobe * countOfStudents;

        if (totalSum <= amountOfMoney) {
            System.out.printf ("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            System.out.printf ("George Lucas will need %.2flv more.", totalSum - amountOfMoney);
        }
    }
}
