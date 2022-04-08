package ru.javarush.kadyrov.cryptoanalizer.commands;

import ru.javarush.kadyrov.cryptoanalizer.Application;
import ru.javarush.kadyrov.cryptoanalizer.constant.Constants;
import ru.javarush.kadyrov.cryptoanalizer.exception.AppExeption;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Encoder {
    private static int key;
    public static int alphabetLength = Constants.ALPHABET.length;
    public static String source;
    public static String destination = "C:\\Users\\Lenovo\\IdeaProjects\\CryptoAnalizer\\text\\EncodedFile.txt";

    public static void start() {
        printEncoderWelcome();
        setKey();
        setSource();
        encode();
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
                if (key == Constants.ALPHABET.length || key == 0) {
                    System.out.println("Шифрование с данным ключем невозможна. Выберите другой ключ.");
                } else
                isExit = true;
            } else {
                String s = scanner.next();
                System.out.printf("Некорректный ввод: '%s'. Введите целое число!\n", s);
            }
        }
        System.out.printf("Ключ %d успешно установлен.\n",key);
    }

    public static void setSource (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес исходного файла: ");
        source = scanner.nextLine();
        scanner.close();
        System.out.printf("Приступаю к шифрованию файла (%s)\n", source);
    }

    public static void encode() {
        if (key > Constants.ALPHABET.length)
            key = key%Constants.ALPHABET.length;

        // логика и реализация шифрования
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            while (reader.ready()) {
                boolean isCharExist = false;
                char fromFile = (char) reader.read();
                for (int i = 0; i < Constants.ALPHABET.length; i++) {
                    if (fromFile == Constants.ALPHABET[i]) {
                        if (i + key >= Constants.ALPHABET.length) {
                            writer.write(Constants.ALPHABET[Constants.ALPHABET.length - key - i]);
                            isCharExist = true;
                            break;
                        }
                        writer.write(Constants.ALPHABET[i + key]);
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
        System.out.println("==============================");
        System.out.println("Выбрана операция шифрования...");
        System.out.println("==============================");
        System.out.println("Введите корректные данные для шифрования файла:");
    }

    public static void printEncoderFarewell(){
        System.out.println(Constants.SUCCESSFUL_ENCODING);
    }



}
