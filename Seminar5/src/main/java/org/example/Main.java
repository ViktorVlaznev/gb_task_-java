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

package org.example;

import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static HashMap<String, List<String>> phoneBook = new HashMap<>();
    public static void main(String[] args) {
        // Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
        // что 1 человек может иметь несколько телефонов.
        addInPhoneBook();
        findInPhoneBook("Иванова");
        System.out.println();
        //   Пусть дан список сотрудников:Иван Иванов
        //   Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
        getEmployeesNameMap();
//      Реализовать алгоритм пирамидальной сортировки (HeapSort).
        int[] array = {134, 65, 4, 89, 89, 2, 69, 1346, 562, 34};
        printArray(array);
        getHeapSort(array);
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
//    Реализовать алгоритм пирамидальной сортировки (HeapSort).
    public static void sort(int arr[]) {
        int n = arr.length;
        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        // Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Вызываем метод heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Метод преобразования в двоичную кучу поддерева с корневым узлом i, что является
    // индексом в arr[]. n - размер кучи
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2
        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;
        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void getHeapSort(int[] arr) {
        sort(arr);
        System.out.println("Sorted array is");
        printArray(arr);
    }
}
