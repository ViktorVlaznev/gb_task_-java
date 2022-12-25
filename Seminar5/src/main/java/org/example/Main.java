//1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//2. Пусть дан список сотрудников:Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
//   Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//   Отсортировать по убыванию популярности.
//3. Реализовать алгоритм пирамидальной сортировки (HeapSort).
//4. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static HashMap<String, List<String>> phoneBook = new HashMap<>();
    public static void main(String[] args) {
        // Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
        // что 1 человек может иметь несколько телефонов.
//        addInPhoneBook();
//        findInPhoneBook("Иванова");
        //   Пусть дан список сотрудников:Иван Иванов
        //   Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
        getEmployeesNameMap();
    }

    /**
     * метод добавляет записи в телефонную книгу
     */
    public static void addInPhoneBook() {
        phoneBook.put("Иванова", List.of("+7(111)111-11-11", "+7(222)222-22-22"));
        phoneBook.put("Петрова", List.of("+7(333)333-33-33", "+7(444)444-44-44"));
        phoneBook.put("Сидорова",List.of("+7(555)555-55-55", "+7(666)666-66-66"));

    }

    /** находит запись об искомом абоненте
     * @param ключ по которому осуществляется поиск
     */
    public static void findInPhoneBook(String surname) {
        System.out.printf("%s: %s", surname, phoneBook.get(surname));
    }
    public static void getEmployeesNameMap() {
        Map<String, Integer> nameMap = new HashMap<>();
        String employees = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Анна Владимирова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов ";
        String[] listOfNamesAndSurnames = employees.split(" ");
        for (int i = 0; i < listOfNamesAndSurnames.length; i += 2) {
            if (nameMap.containsKey(listOfNamesAndSurnames[i])) {
                nameMap.replace(listOfNamesAndSurnames[i], nameMap.get(listOfNamesAndSurnames[i]) + 1);
            } else {
                nameMap.put(listOfNamesAndSurnames[i], 1);
            }
        }
        System.out.println(nameMap);
        Map<String, Integer> sortedMap = nameMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        System.out.println(sortedMap);
    }
}