package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String command = scanner.nextLine ();

        while (!command.equals ("Beast!")) {
            String animalType = command;

            String[] tokens = scanner.nextLine ().split ("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt (tokens[1]);
            String gender = tokens[2];

            try {
                switch (animalType) {
                    case "Cat":
                        Cat cat = new Cat (name, age, gender);
                        System.out.println (cat);

                        break;
                    case "Dog":
                        Dog dog = new Dog (name, age, gender);
                        System.out.println (dog);

                        break;
                    case "Frog":
                        Frog frog = new Frog (name, age, gender);
                        System.out.println (frog);

                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten (name, age);
                        System.out.println (kitten);

                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat (name, age);
                        System.out.println (tomcat);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println (ex.getMessage ());
            }

            command = scanner.nextLine ();
        }
    }
}
