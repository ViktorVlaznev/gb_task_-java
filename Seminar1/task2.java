// Вывести все простые числа от 1 до 1000
package Seminar1;

import java.math.BigInteger;

public class task2 {
    public static void main(String[] args) {

        int maxNumber = 1000;

        for (int i = 1; i < maxNumber; i++) {

            Integer integer = i;
            BigInteger bigInteger = BigInteger.valueOf(integer);
            boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(integer));
            if (probablePrime) System.out.println(i); 
                
        }       
    }
}
