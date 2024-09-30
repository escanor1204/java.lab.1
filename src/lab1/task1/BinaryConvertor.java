package lab1.task1;

import java.util.Scanner;

public class BinaryConvertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer:");
        System.out.println(intoBinary(scanner.nextInt()));
    }
private static String intoBinary(int number){
    String binaryNumber = "";
    if(number == 0) return "0";
    while(number > 0) {
        int tempNumber = number % 2;
        binaryNumber = tempNumber + binaryNumber;
        number /= 2;
    }

    return binaryNumber;
}
}