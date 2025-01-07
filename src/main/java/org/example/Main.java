package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));

        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));

        System.out.println(numberToWords(123));
        System.out.println(numberToWords(1010));
        System.out.println(numberToWords(-12));
    }

    // isPalindrome
    public static boolean isPalindrome(int number) {
        int realNumber = number;
        number = Math.abs(number);

        int reverse = 0;
        while (number > 0) {
            int lastNumber = number % 10;
            reverse = (reverse * 10) + lastNumber;
            number = number / 10;
        }

        return reverse == Math.abs(realNumber);
    }
    // reverseNumber
    public static int reverseNumber(int number) {
        int reverse = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number /= 10;
        }
        return reverse;
    }

    // isPerfectNumber
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        return sum == number;
    }

    // numberToWords
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        //sayı sıfırsa sadece "zero" dönsün.
        if (number == 0) {
            return words[0];
        }

        // Sayıyı stringe dönüştürerek her basamağını kelimeye dönüştürelim
        StringBuilder result = new StringBuilder();
        String numberStr = Integer.toString(number); // Sayıyı stringe çevir

        // Her basamağı kelimeye dönüştür
        for (int i = 0; i < numberStr.length(); i++) {
            char digit = numberStr.charAt(i);
            result.append(words[digit - '0']).append(" ");
        }

        // Fazla boşlukları temizleyip döndür
        return result.toString().trim();
    }
}
