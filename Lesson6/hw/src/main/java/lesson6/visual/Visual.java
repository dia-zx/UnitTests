package lesson6.visual;

import java.util.Scanner;

public class Visual {    
    public Visual(){
        scanner = new Scanner(System.in);
    }

    private Scanner scanner;

    public static void print(String str){
        System.out.println(str);
    }

    public String userInputDataList(){
        System.out.println("Вводите значения чисел списка через <пробел>");
        return scanner.nextLine();
    }
}
