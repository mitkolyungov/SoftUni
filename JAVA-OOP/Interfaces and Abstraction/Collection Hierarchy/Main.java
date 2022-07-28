import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        AddCollection addCollection = new AddCollection ();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection ();
        MyList myList = new MyListImpl ();

        String[] items = scanner.nextLine ().split (" ");

        addAndPrint (items, addCollection);
        addAndPrint (items, addRemoveCollection);
        addAndPrint (items, myList);

        int removedOperations = scanner.nextInt ();

        removeAndPrint(removedOperations,addRemoveCollection);
        removeAndPrint(removedOperations,myList);

    }

    private static void addAndPrint(String[] items, Addable collection) {
        for (String item : items) {
            System.out.print (collection.add (item) + " ");
        }
        System.out.println ();
    }

    private static void removeAndPrint(int removedOperations, AddRemovable collection){
        for (int i = 0; i < removedOperations; i++) {
            System.out.print(collection.remove ()+" ");
        }
        System.out.println ();
    }
}
