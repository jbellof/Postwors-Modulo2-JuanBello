package com.example.posworks03v2;

public class FizzBuzz {

    public static void main(String[] args) {
        int n = 100; // Cambia el valor de N según tus necesidades
        for (int i = 1; i <= n; i++) {
            System.out.println(fizzBuzz(i));
        }
    }

    public static String fizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }
}

