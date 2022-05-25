import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VacationMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        int groupOfPeople = Integer.parseInt (((input.readLine ())));
        String typeOfGroup = input.readLine ();
        String dayOfWeek = input.readLine ();

        double totalPrice = 0;

        if (typeOfGroup.equals ("Students")){
            if (dayOfWeek.equals ("Friday")){
                totalPrice = groupOfPeople*8.45;
            }else if (dayOfWeek.equals ("Saturday")){
                totalPrice = groupOfPeople*9.80;
            }else if (dayOfWeek.equals ("Sunday")){
                totalPrice = groupOfPeople*10.46;
            }
            if (groupOfPeople>=30){
                totalPrice*=0.85;
            }
        }else if (typeOfGroup.equals ("Business")){
            if (groupOfPeople>=100){
                groupOfPeople-=10;
            }
            if (dayOfWeek.equals ("Friday")){
                totalPrice = groupOfPeople*10.90;
            }else if (dayOfWeek.equals ("Saturday")){
                totalPrice = groupOfPeople*15.6;
            }else if (dayOfWeek.equals ("Sunday")){
                totalPrice = groupOfPeople*16;
            }


        }else if (typeOfGroup.equals ("Regular")){
            if (dayOfWeek.equals ("Friday")){
                totalPrice = groupOfPeople*15;
            }else if (dayOfWeek.equals ("Saturday")){
                totalPrice = groupOfPeople*20;
            }else if (dayOfWeek.equals ("Sunday")){
                totalPrice = groupOfPeople*22.50;
            }

            if (groupOfPeople>=10 && groupOfPeople<=20){
                totalPrice*=0.95;
            }
        }
        System.out.printf ("Total price: %.2f",totalPrice);

    }
}
