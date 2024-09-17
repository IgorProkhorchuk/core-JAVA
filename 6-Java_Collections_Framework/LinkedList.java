/*
 * Linked list example
 * Iteration through LinkedList example
 */

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList {
        public static void main(String[] args) {
            LinkedList<String> list = new LinkedList<>();
            list.add("Glory");
            System.out.println(list);
            list.add("For");
            System.out.println(list);
            list.add("Ukraine");
            System.out.println(list);

            ListIterator<String> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    String element = iterator.next();
                    if (element.equals("Ukraine")) {
                        iterator.set("Heroes");
                        break;
                    }
                }
            System.out.println(list);
            }
}
