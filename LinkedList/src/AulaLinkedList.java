import javax.sound.sampled.Line;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class AulaLinkedList {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sidney");
        placesToVisit.add("Perth");
        placesToVisit.add("Brisbane");
        addInOrder(placesToVisit, "Adelaide");
        placesToVisit.add("Darwin");
        addInOrder(placesToVisit, "Fernandópolis");
        placesToVisit.add("Melbourne");
        addInOrder(placesToVisit, "Sidney");
        addInOrder(placesToVisit, "Zion");

        printList(placesToVisit);

        placesToVisit.add(1, "Alice Springs");
        placesToVisit.remove(4);
        printList(placesToVisit);

        System.out.println("\nStart over again\n");
        placesToVisit.clear();

        addInOrder(placesToVisit,"Sidney");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit,"Darwin");
        addInOrder(placesToVisit, "Fernandópolis");
        addInOrder(placesToVisit,"Melbourne");
        printList(placesToVisit);

        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()){
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=========== T HE END ===========");
    }

    private static boolean addInOrder (LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareToIgnoreCase(newCity);
            if (comparison == 0){
                System.out.println(newCity + " is already included.");
                return false;
            }
            else if (comparison > 0){
                //pela ordem alfabética deve vir antes
                stringListIterator.previous();//volta 1 "casa" do iterator
                stringListIterator.add(newCity);
                return true;
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        /* OBS: LinkedList works in the space between elements, so if you call next and then previous,
         * the element will be the same since now it is the previous one. ex: https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
         */
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty())
        {
            System.out.println("No cities to visit");
            return;
        }
        printMenu();
        while (!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) trip over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward && listIterator.hasNext())
                        listIterator.next();
                    goingForward = true;
                    if (listIterator.hasNext())
                        System.out.println("Now visiting " + listIterator.next());
                    else {
                        System.out.println("Congratulations, you have finished your list!!");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward && listIterator.hasPrevious())
                        listIterator.previous();
                    goingForward = false;
                    if (listIterator.hasPrevious())
                        System.out.println("Now visiting " + listIterator.previous());
                    else{
                        System.out.println("We are at the begin of the list.");
                        goingForward = true;
                    }

                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:");
        System.out.println("0 - to quit\n" +
                        "1 - go to next city\n" +
                        "2 - bo to previous city\n" +
                        "3 - print menu options");

    }
}
