package com.me;

import java.util.Scanner;

public class Main {

     static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scn.nextLine();
        System.out.print(" = " + calc(input));
    }
    public static String calc(String input) throws Exception {
        int a, b;
        int result;
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;

        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) {
            throw new Exception("Выражение должно содержать знак");
        }

        String[] data = input.split(regexActions[actionIndex]);

        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            if (data.length != 2) {
                throw new Exception("Не больше двух операторов");
            }
            if ((a <= 10) & (a >= 1) & (b >= 1) & (b <= 11)) {
                switch (actions[actionIndex]) {
                    case "+": result = a + b;
                    break;
                    case "-": result = a - b;
                    break;
                    case "*": result = a * b;
                    break;
                    case "/": result = a / b;
                    break;
                    default: throw new Exception("Не найден оператор");
                }
                if (isRoman){
                    return String.valueOf(converter.intToRoman(result));
                } 
            } else {
                throw new Exception("Допустимы входные значения от 1 до 10");
            }
        }  else {
            throw new Exception("Числа не должны быть из разных СС");
        }
        return String.valueOf(result);
    }
}
