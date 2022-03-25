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
        setSource();
        setKey();
        encode();
    }

    public static void setKey() {
    // запрашивает ключ в консоли. Проверяет корректное введение ключа.

    }

    public static void setSource (){
        // запрашивает имя файла в консоли. Проверяет корректное введение имени файла.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес исходного файла: ");
        source = scanner.nextLine();
        scanner.close();
    }

    public static void encode() {
        // логика и реализация шифрования
    }

    public static void printEncoderWelcome(){
        System.out.println("==============================");
        System.out.println("Выбрана операция шифрования...");
        System.out.println("==============================");
        System.out.println("Введите корректные данные для шифрования файла");
    }



}
