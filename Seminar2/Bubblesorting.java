// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
package Seminar2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Bubblesorting {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        int[] arrayInitial = {3,4,1,7,34,2,7};
        PrintWriter writer = new PrintWriter("bubbleSorting.txt", "UTF-8");
        System.out.println(Arrays.toString(arrayInitial));
        System.out.println(Arrays.toString(bubbleSortingwithlog(arrayInitial)));
        writer.close();
    }
    /**
     * функция сортирует массив пузырьковым методом, промежуточные результаты записывает в лог
     * @param массив
     * @return отсортированный массив
     */
    private static int[] bubbleSortingwithlog(int[] array) {
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                recordArrayinFile(array, "bubbleSorting.txt", count++);
            }
        }
        return array;
    }
    /**
     * функция записывает массив в файл
     * @param массив, путь к файлу
     * @return запись в файл
     */
    private static void recordArrayinFile(int[] array, String path, int num) {
        try {
            String strAdd = num + ": " + Arrays.toString(array) + "\n";
            Files.write(Paths.get(path), strAdd.getBytes(), StandardOpenOption.APPEND);
        }
        catch (final IOException e) {
            System.out.println(e);
        }
    }
}
