package ru.javarush.kadyrov.cryptoanalizer;
import ru.javarush.kadyrov.cryptoanalizer.commands.CryptoAnalizer;
import ru.javarush.kadyrov.cryptoanalizer.commands.BrutForce;
import ru.javarush.kadyrov.cryptoanalizer.commands.Encoder;
import ru.javarush.kadyrov.cryptoanalizer.commands.Decoder;
import ru.javarush.kadyrov.cryptoanalizer.constants.Constants;


import java.util.Scanner;

public class Application {
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
        int command;
        while (true) {
            Scanner scanner = new Scanner((System.in));
            System.out.print("Введите номер операции (целое число 1 - 4 либо 0 для выхода):");
            if (scanner.hasNextInt()) {
                command = scanner.nextInt();
                if (command < 0 || command > 4)
                    System.out.println("Операции с номером " + command + " не существует. Повторите ввод.\n"
                            + Constants.COMMAND_OPTIONS);
                else
                    break;
            } else {
                System.out.println("\nНекорректный ввод данных.\n" + Constants.COMMAND_OPTIONS);
            }
        }
        return command;
    }

    public static void executeOperation(int commandNumber) {
        switch (commandNumber) {
            case 1 -> Encoder.start();
            case 2 -> Decoder.start();
            case 3 -> BrutForce.start();
            case 4 -> CryptoAnalizer.start();
            case 0 -> doNothing();
        }
    }

    public static void printFarewell(){
        System.out.println(Constants.APP_FAREWELL);
    }
    public static void doNothing(){}




}
