package lesson6.visual;

import java.util.Scanner;

public class Visual {
    public void print(String str){
        System.out.println(str);
    }

    public String userInputDataList(){
        System.out.println("Вводите значения чисел списка через <пробел>");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
