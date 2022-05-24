import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheatrePromotionMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        String typeOfDay = input.readLine ();
        int age = Integer.parseInt (input.readLine ());
        int price = 0;

        if (age>=0 && age<=18){
            if (typeOfDay.equals ("Weekday")){
                price = 12;
            }else if (typeOfDay.equals ("Weekend")){
                price = 15;
            }else if (typeOfDay.equals ("Holiday")){
                price = 5;
            }
        }else if (18<age && age<=64){
            if (typeOfDay.equals ("Weekday")){
                price = 18;
            }else if (typeOfDay.equals ("Weekend")){
                price = 20;
            }else if (typeOfDay.equals ("Holiday")){
                price = 12;
            }
        }else if (age>64 && age<=122){
            if (typeOfDay.equals ("Weekday")){
                price = 12;
            }else if (typeOfDay.equals ("Weekend")){
                price = 15;
            }else if (typeOfDay.equals ("Holiday")){
                price = 10;
            }
        }

        if (price>0){
            System.out.printf("%d$",price);
        }else {
            System.out.println ("Error!");
        }
    }
}
