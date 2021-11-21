import array_list.ArrayList;
import common.ListInterface;
import linked_list.LinkedList;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        //тестирование класса ArrayList

        System.out.println();
        System.out.println("*******************************************");
        System.out.println("ArrayList TESTING");

        ListInterface<Integer> bigArray = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            bigArray.add((int)(Math.random()*20));
        }

        System.out.println("\ninition array");
        bigArray.display();

        System.out.println("\ntesting method 'add'");
        bigArray.add(11);
        bigArray.add(12);
        bigArray.add(13);
        bigArray.add(14);
        bigArray.add(15);
        bigArray.add(16);
        bigArray.add(17);
        bigArray.display();

        System.out.println("\ntesting method 'get(5)'");
        System.out.println(bigArray.get(5));

        System.out.println("\ntesting method 'indexOf(15)'");
        System.out.println(bigArray.indexOf(15));

        System.out.println("\ntesting method 'remove(3)'");
        bigArray.remove(Integer.valueOf(3));
        bigArray.display();

        System.out.println("\ntesting method 'insert(5, 111)'");
        bigArray.insert(5, 111);
        bigArray.display();

        //тестирование класса ArrayList

        System.out.println();
        System.out.println("*******************************************");
        System.out.println("LinkedList TESTING");

        ListInterface<Integer> linkArray = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkArray.add((int)(Math.random()*20));
        }

        System.out.println("\ninition array");
        linkArray.display();

        System.out.println("\ntesting method 'add'");
        linkArray.add(11);
        linkArray.add(12);
        linkArray.add(13);
        linkArray.add(14);
        linkArray.add(15);
        linkArray.add(16);
        linkArray.add(17);
        linkArray.display();

        System.out.println("\ntesting method 'get(5)'");
        System.out.println(linkArray.get(5));

        System.out.println("\ntesting method 'indexOf(15)'");
        System.out.println(linkArray.indexOf(15));

        System.out.println("\ntesting method 'remove(3)'");
        linkArray.remove(Integer.valueOf(3));
        linkArray.display();

        System.out.println("\ntesting method 'insert(5, 111)'");
        linkArray.insert(5, 111);
        linkArray.display();


    }
}
