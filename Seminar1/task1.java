// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

package Seminar1;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        try{
            System.out.print("Введите натуральное число: ");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            sc.close();
            System.out.println("Треугольное число равно " + getSum(number));
            System.out.println("Факториал равен " + getFactorial(number));
        }
        catch(Exception e) {
            System.out.println("Введено не натуральное число.");
        }
    }
    // Функция возвращает сумму до n
    public static int getSum(int num){
        int sum = 1;
        for (int i = 2; i <= num ; i++){
            sum += i;
        } 
        return sum;
    }
    // функция возвращает факториал числа n
    public static int getFactorial(int num){
        int fact = 1;
        for (int i = 2; i <= num ; i++){
            fact *= i;
        } 
        return fact;
    }
}
