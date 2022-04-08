package ru.javarush.kadyrov.cryptoanalizer;
import ru.javarush.kadyrov.cryptoanalizer.commands.Analizer;
import ru.javarush.kadyrov.cryptoanalizer.commands.BrutForce;
import ru.javarush.kadyrov.cryptoanalizer.commands.Encoder;
import ru.javarush.kadyrov.cryptoanalizer.commands.Decoder;
import ru.javarush.kadyrov.cryptoanalizer.constant.Constants;


import java.util.Scanner;

public class   Application {
    public static void run(){
        printAppWelcome();
        executeOperation(getCommand());
        printFarewell();
    }

    public static void printAppWelcome(){
        System.out.println(Constants.APP_WELCOME);
        System.out.println(Constants.COMMAND_OPTIONS);
    }

    public static int getCommand() {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        int command = 0;
        while (!isExit) {
            System.out.print("Введите номер операции: ");
            if (scanner.hasNextInt()) {
                command = scanner.nextInt();
                if (command < 0 || command > 4)
                    System.out.println("Операции с номером " + command + " не существует!\n" + Constants.COMMAND_OPTIONS);
                else
                    isExit = true;
            } else {
                System.out.println("Некорректный ввод! Введите целое число!");
                scanner.next();
            }
        }
        return command;
    }

    public static void executeOperation(int commandNumber) {
        switch (commandNumber) {
            case 1 -> Encoder.start();
            case 2 -> Decoder.start();
            case 3 -> BrutForce.start();
            case 4 -> Analizer.start();
            case 0 -> doNothing();
        }
    }

    public static void printFarewell(){
        System.out.println(Constants.APP_FAREWELL);
    }
    public static void doNothing(){}




}
