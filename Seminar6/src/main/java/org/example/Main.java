/**
 * 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * 2. Создать множество ноутбуков.
 * 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
 * отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * 1. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 * 2. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        createNoutbookSet();
    }

    private static void createNoutbookSet() {
        Notebook l1 = new Notebook(1, "IBM", 2, 128, "Windows 10", "Сиреневый");
        Notebook l2 = new Notebook(2,"Acer", 4, 256, "Windows 11", "Красный");
        Notebook l3 = new Notebook(3,"Apple", 32, 512, "IOS", "Серый");
        Notebook l4 = new Notebook(4,"Sony", 16, 256, "Windows 11", "Черный");

        Set<Notebook> setNotebook = new HashSet<>();
        setNotebook.add(l1);
        setNotebook.add(l2);
        setNotebook.add(l3);
        setNotebook.add(l4);

        System.out.println(setNotebook);
        System.out.println("Выберите функцию:");
        System.out.println("1 - сортировка по ОЗУ");
        System.out.println("2 - сортировка по SSD");
        System.out.println("3 - сортировка по OS");
        Scanner sc = new Scanner(System.in,"ibm866");
        Integer choice = sc.nextInt();
        if(choice == 1){
            boolean flag = true;
            System.out.printf("Введите значение ОЗУ: ");
            Integer ram = sc.nextInt();
            for (Iterator<Notebook> it = setNotebook.iterator(); it.hasNext(); ) {
                Notebook f = it.next();
                if (ram <= f.getRam()) {
                    System.out.println(f.toString());
                    flag = false;
                }
            }
            if(flag){
                System.out.println("Таких ноутбуков нет!");
            }
        }else if(choice == 2){
            boolean flag = true;
            System.out.printf("Введите значение SSD: ");
            Integer ssd = sc.nextInt();
            for (Iterator<Notebook> it = setNotebook.iterator(); it.hasNext(); ) {
                Notebook f = it.next();
                if (ssd <= f.getSsd()) {
                    System.out.println(f.toString());
                    flag = false;
                }
            }
            if(flag){
                System.out.println("Таких ноутбуков нет!");
            }

        }else if(choice == 3){
            boolean flag = true;
            System.out.println("Введите название OS");
            Scanner sc1 = new Scanner(System.in);
            String os = sc1.nextLine();
            for (Iterator<Notebook> it = setNotebook.iterator(); it.hasNext(); ) {
                Notebook f = it.next();
                if (os == f.getOs()) {
                    System.out.println(f.toString());
                    flag = false;
                }
            }
            if(flag){
                System.out.println("Таких ноутбуков нет!");
            }
            sc1.close();
        }

        sc.close();
    }
}
