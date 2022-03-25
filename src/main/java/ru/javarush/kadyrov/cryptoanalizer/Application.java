package ru.javarush.kadyrov.cryptoanalizer;
import ru.javarush.kadyrov.cryptoanalizer.commands.Analizer;
import ru.javarush.kadyrov.cryptoanalizer.commands.BrutForce;
import ru.javarush.kadyrov.cryptoanalizer.commands.Encoder;
import ru.javarush.kadyrov.cryptoanalizer.commands.Decoder;
import ru.javarush.kadyrov.cryptoanalizer.constant.Constants;

import java.util.Scanner;

public class Application {
    public static void run(){
        printAppWelcome();
        chooseCommand();
    }

    public static void printAppWelcome(){
        System.out.println(Constants.WELCOME);
        System.out.println(Constants.COMMAND_OPTIONS);
    }

    public static void chooseCommand(){
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        int command = 0;
        while (!isExit) {
            System.out.print("Введите номер операции: ");
           if (scanner.hasNextInt()) {
               command = scanner.nextInt();
               if (command < 0 || command > 4)
                   System.out.println("Операции с номером " + command + " не существует! Введите корректный номер!");
               else
                   isExit = true;
           } else{
               System.out.println("Некорректный ввод! Введите целое число!");
               scanner.next();
           }
        }
        scanner.close();


            switch (command) {
                case 1 -> Encoder.start();
                case 2 -> Decoder.start();
                case 3 -> BrutForce.start();
                case 4 -> Analizer.start();
                case 0 -> printFarewell();
            }


    }

    public static void printFarewell(){
        System.out.println(Constants.FAREWELL);
    }




}
