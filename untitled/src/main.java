import java.util.Scanner;

public class main {
    static String operation;
    static boolean itsRomanNumbers = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("EXIT")) {
            String result = calc(input);
            System.out.println(result);
            input = scanner.nextLine();
        }
    }

    public static String calc(String input) {
        String[] arrayValues = handlingExpression(input);
        String result = calculations(arrayValues);
        if (itsRomanNumbers){
            result = Converter.fromArabicToRoman((result));
        }
        return result;
    }

    static String[] handlingExpression(String input) {
        String ExpressionNotSpace = input.replaceAll(" ", "");
        String[] values = splitIntoParts(ExpressionNotSpace);
        CheckNumberSystems(values);
        if (itsRomanNumbers) {
            String[] romanToArabicNumbers = Converter.fromRomanToArabic(values);
            checkOneToTen(romanToArabicNumbers);
            checkZeroAndNegative(romanToArabicNumbers);
            return romanToArabicNumbers;
        }
        else {
            checkIsNumerics(values);
            checkForAnInteger(values);
            checkOneToTen(values);
        }
        return values;
    }

    static String[] splitIntoParts(String inputNotSpace) {
        String[] mathOperations = {"+", "-", "*", "/"};
        for (String operator : mathOperations) {
            String[] values = inputNotSpace.split(String.valueOf("\\" + operator));
            if (values.length == 2) {
                operation = operator;
                return values;
            }
        }
        throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда " +
                " и один оператор (+, -, /, *");
    }
    static void CheckNumberSystems(String[] values) {
        boolean num1 = RomanNumerals.getAllRomanValues().contains(values[0]);
        boolean num2 = RomanNumerals.getAllRomanValues().contains(values[1]);
        if (num1 == num2 && num1) {
            itsRomanNumbers = true;
        } else if (num1 != num2) {
            throw new RuntimeException("используются одновременно разные системы счисления");
        } else {
            itsRomanNumbers = false;
        }}

    static void checkOneToTen (String[] numbers){
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10){
        }else{
            throw new RuntimeException("Калькулятор принимает на вход числа от 1 до 10 включительно");
        }
    }

    static void checkZeroAndNegative(String[] values) {
        int romeNum1 = Integer.parseInt(values[0]);
        int romeNum2 = Integer.parseInt(values[1]);
        if (itsRomanNumbers && romeNum2 >= romeNum1 && operation.equals("-")) {
            throw new RuntimeException("Результатом операции в римской системе счислений не может быть" +
                    " нуль или отрицательное число");
        }
    }

    static void checkForAnInteger(String[] values){
        double num1 = Double.parseDouble(values[0]);
        double num2 = Double.parseDouble(values[1]);
        if (num1 % 1 != 0 || num2 % 1 != 0){
            throw new RuntimeException("Калькулятор умеет работать только с целыми числами");
        }
    }

    static void checkIsNumerics (String[] values){
        try {
            double num1 = Double.parseDouble(values[0]);
            double num2 = Double.parseDouble(values[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Некорректный ввод данных");
        }
    }

    static String calculations(String[] arrayInput) {
        int num1 = Integer.parseInt(arrayInput[0]);
        int num2 = Integer.parseInt(arrayInput[1]);
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
        }
        return String.valueOf(result);
    }
}
