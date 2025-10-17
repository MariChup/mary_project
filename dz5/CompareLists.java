package org.example.dz5;
import java.util.ArrayList;
import java.util.LinkedList;

public class CompareLists {

    public static void main(String[] args) {


        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= 999_999; i++) {
            arrayList.add(i);
        }


        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);


        int middle = arrayList.size() / 2;
        long startTime = System.nanoTime();

        for (int i = 0; i < 500_000; i++) {
            arrayList.add(middle, i);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        long arrayInsertMs= duration / 1_000_000;
        System.out.println("ArrayList insert duration: " + arrayInsertMs + " ms");


        int middle2 = linkedList.size() / 2;
        long startTime2 = System.nanoTime();

        for (int i = 0; i < 500_000; i++) {
            linkedList.add(middle2, i);
        }

        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        long linkedInsertMs = duration2 / 1_000_000;
        System.out.println("LinkedList insert duration: " + linkedInsertMs + " ms");



        long startTime3 = System.nanoTime();
        arrayList.get(middle);
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;
        long arrayGetMs=duration3;
        System.out.println("ArrayList getMiddleEl duration: " + arrayGetMs + " ns");

        long startTime4 = System.nanoTime();
        linkedList.get(middle2);
        long endTime4 = System.nanoTime();
        long duration4 = endTime4 - startTime4;
        long linkedGetMs=duration4;
        System.out.println("LinkedList getMiddleEl duration: " + linkedGetMs + " ns");



        long startTime5 = System.nanoTime();
        arrayList.remove(middle);
        long endTime5 = System.nanoTime();
        long duration5 = endTime5 - startTime5;
        long arrayRemoveMs=duration5;
        System.out.println("ArrayList removeMiddleEl duration: " + arrayRemoveMs + " ns");

        long startTime6 = System.nanoTime();
        linkedList.remove(middle2);
        long endTime6 = System.nanoTime();
        long duration6 = endTime6 - startTime6;
        long linkedRemoveMs=duration6;
        System.out.println("LinkedList removeMiddleEl duration: " + linkedRemoveMs + " ns");


        System.out.println("\n--- Выводы ---");
        System.out.println("Вставка: " + (arrayInsertMs < linkedInsertMs ? "ArrayList быстрее" : "LinkedList быстрее"));
        System.out.println("Получение: " + (arrayGetMs < linkedGetMs ? "ArrayList быстрее" : "LinkedList быстрее"));
        System.out.println("Удаление: " + (arrayRemoveMs < linkedRemoveMs ? "ArrayList быстрее" : "LinkedList быстрее"));



    }
}
