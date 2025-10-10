package com.example.homework3;

public class Main {

        public static void main(String[] args) {


            Lollipop l1 = new Lollipop("Леденец", 50, 30, "вишня");
            Lollipop l2 = new Lollipop("Леденец", 40, 25, "лимон");

            Chocolate c1 = new Chocolate("Шоколад", 100, 120, "молочный");
            Chocolate c2 = new Chocolate("Шоколад", 80, 90, "горький");

            Cookie co1 = new Cookie("Печенье", 60, 50, "овсяное");
            Cookie co2 = new Cookie("Печенье", 70, 55, "имбирное");


            GiftBox box = new GiftBox();


            box.addSweet(l1);
            box.addSweet(l2);
            box.addSweet(c1);
            box.addSweet(c2);
            box.addSweet(co1);
            box.addSweet(co2);


            System.out.println("Содержимое коробки:");
            box.printAllSweets();


            System.out.println("\nОбщий вес коробки: " + box.getTotalWeight() + " г");
            System.out.println("Общая стоимость коробки: " + box.getTotalPrice() + " руб");

            // Тестируем оптимизацию по весу
            System.out.println("\nОптимизация по весу до 250 г:");
            box.optimizeByWeight(250);
            box.printAllSweets();
            System.out.println("Вес после оптимизации: " + box.getTotalWeight() + " г");

            // Тестируем оптимизацию по цене
            System.out.println("\nОптимизация по цене до 200 г:");
            box.optimizeByPrice(200);
            box.printAllSweets();
            System.out.println("Вес после оптимизации по цене: " + box.getTotalWeight() + " г");
        }
    }


