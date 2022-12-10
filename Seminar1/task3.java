// Реализовать простой калькулятор

package Seminar1;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        try{
            double firstNumber = scanNumber("Введите первое число: ");
            double secondNumber = scanNumber("Введите второе число: ");
            System.out.println(firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
            System.out.println(firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
            System.out.println(firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
            System.out.println(firstNumber + " / " + secondNumber + " = " + (firstNumber / secondNumber));
        }
        catch(Exception e) {
            System.out.println("Введено не число.");
        }
    }
    // функция запроса числа от пользователя
    public static double scanNumber(String text){
        System.out.print(text);
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        return number;
    }
}
