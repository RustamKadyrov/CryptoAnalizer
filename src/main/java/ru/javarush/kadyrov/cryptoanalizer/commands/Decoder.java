package ru.javarush.kadyrov.cryptoanalizer.commands;

import ru.javarush.kadyrov.cryptoanalizer.constant.Constants;

import java.io.*;
import java.util.Scanner;

public class Decoder {

    private static int key;
    public static String source;
    public static String destination = "C:\\Users\\Lenovo\\IdeaProjects\\CryptoAnalizer\\text\\DecodedFile.txt";

    public static void start() {
        printEncoderWelcome();
        setKey();
        setSource();
        decode();
        printEncoderFarewell();
    }

    public static void setKey() {
        // запрашивает ключ в консоли. Проверяет корректное введение ключа.
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.print("Введите ключ (целое число): ");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
                    isExit = true;
            } else {
                String s = scanner.next();
                System.out.printf("Некорректный ввод: '%s'. Введите целое число!\n", s);
            }
        }
        System.out.printf("Ключ %d принят.\n",key);
    }

    public static void setSource (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес исходного файла: ");
        source = scanner.nextLine();
        scanner.close();
        System.out.printf("Приступаю к дешифровке файла (%s)\n", source);
    }

    public static void decode() {
        if (key > Constants.ALPHABET.length)
            key = key%Constants.ALPHABET.length;

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            while (reader.ready()) {
                boolean isCharExist = false;
                char fromFile = (char) reader.read();
                for (int i = 0; i < Constants.ALPHABET.length; i++) {
                    if (fromFile == Constants.ALPHABET[i]) {
                        if (key > i) {
                            writer.write(Constants.ALPHABET[Constants.ALPHABET.length - key - i]);
                            isCharExist = true;
                            break;
                        }
                        writer.write(Constants.ALPHABET[i - key]);
                        isCharExist = true;
                        break;
                    }
                }
                if(!isCharExist)
                    writer.write(fromFile);
            }
        } catch (IOException e){
            e.printStackTrace();
        }




    }

    public static void printEncoderWelcome(){
        System.out.println("====================================");
        System.out.println("Выбрана операция дешифровки файла...");
        System.out.println("====================================");
        System.out.println("Введите корректные данные для дешифровки файла:");
    }

    public static void printEncoderFarewell(){
        System.out.println(Constants.SUCCESSFUL_DECODING);
    }
}
