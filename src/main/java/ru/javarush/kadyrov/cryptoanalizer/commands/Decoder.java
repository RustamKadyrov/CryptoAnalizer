package ru.javarush.kadyrov.cryptoanalizer.commands;

import ru.javarush.kadyrov.cryptoanalizer.constants.Constants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Decoder {
    private static final HashMap<Integer,Character> ALPHABET = Constants.ALPHABET;
    private static int key;
    private static Path source;
    private static Path destination = Path.of("C:\\Users\\Lenovo\\IdeaProjects\\CryptoAnalizer\\text\\DecodedByKeyFile.txt");
    private static final char [] chars = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с',
            'т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я','А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л',
            'М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я','.',',','«','»','"','\'',
            ':','!','?',' ','\n','q','w','e','r','t','y','u','i','o','p','[',']','\\','a','s','d','f','g','h','j','k',
            'l',';','z','x','c','v','b','n','m','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z','(',')','1','2','3','4','5','6','7','8','9','0' };


    public static void start() {
        printDecoderWelcome();
        setSourceFile();
//        setDestinationFile();
        setKey();
        decode2();
        printDecoderFarewell();
        System.out.println("Are files identical == " + areFilesIdentical(source, destination));
    }

    public static void setKey() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ключ (целое число): ");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
                if (key == ALPHABET.size() || key == 0) {
                    System.out.println("Пожалуйста, введите другой ключ.");
                } else
                    break;
            } else {
                System.out.println("\nНекорректный ввод. Введите целое число!");
            }
        }
    }

    public static void setSourceFile (){
        Path path;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите адрес исходного файла с расширением .txt: ");
            try {
                path = Path.of(scanner.nextLine());
                if (Files.exists(path)) {
                    source = path;
                    if (path.toString().endsWith(".txt"))
                        break;
                    else
                        System.out.println("Исходный файл должен быть с расширением .txt. Повторите ввод.");

                } else {
                    System.out.println("Введены некорректные данные. Повторите ввод.");
                }
            } catch (InvalidPathException e) {
                System.out.println("Введены некорректные данные. Повторите ввод.");
            }
        }
    }

    public static void setDestinationFile (){
        Path path;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите абсолютный адрес для дешифрованного файла с расширением .txt: ");
            try {
                path = Path.of(scanner.nextLine());
                if (path.isAbsolute()) {
                    if (path.toString().endsWith(".txt")){
                        destination = path;
                        break;
                    } else
                        System.out.println("Файл должен быть с расширением .txt. Повторите ввод.");
                } else {
                    System.out.println("Введены некорректные данные. Повторите ввод.");
                }
            } catch (InvalidPathException e) {
                System.out.println("Введены некорректные данные. Повторите ввод.");
            }
        }
    }


    public static void decode() {
//        if (key > ALPHABET.size())
//            key = key % ALPHABET.size();
//        // логика и реализация шифрования
//        try(BufferedReader reader = new BufferedReader(new FileReader(source.toString()));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(destination.toString()))) {
//            while (reader.ready()) {
//                char charFromSource = (char) reader.read();
//                char replacing;
//                if (ALPHABET.containsValue(charFromSource)) {
//
//                    for (Integer mapKey: ALPHABET.keySet()) {
//                        if (ALPHABET.get(key).equals(charFromSource)) {
//                            if (mapKey + key >= ALPHABET.size()) {
//                                replacing = ALPHABET.get(mapKey + key - ALPHABET.size());
//                            } else {
//                                replacing = ALPHABET.get(mapKey + key);
//                            }
//                        }
//                    }
//                    writer.write(replacing);
//                } else
//                    writer.write(i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void decode2() {
        Date start = new Date();


        if (key > chars.length)
            key = key % chars.length;
        // логика и реализация шифрования
        try(BufferedReader reader = new BufferedReader(new FileReader(source.toString()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination.toString()))) {
            while (reader.ready()) {
                int i = reader.read();
                char charFromSource = (char) i;
                char replacing;
                boolean isCharExists = false;
                for (int j = 0; j < chars.length && !isCharExists; j++) {
                    if (charFromSource == chars[j]) {
                        isCharExists = true;
                        if (key <= j) {
                            replacing = chars[j - key];
                            writer.write(replacing);
                        } else {
                            replacing = chars[chars.length - (key - j)];
                            writer.write(replacing);
                        }
                    }
                }
                if(!isCharExists)
                    writer.write(charFromSource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date end = new Date();
        System.out.printf("Decoding successfully finished in %d ms\n",end.getTime()- start.getTime());
    }

    public static void printDecoderWelcome(){
        System.out.println("====================================");
        System.out.println("Выбрана операция дешифровки файла...");
        System.out.println("====================================");
        System.out.println("Введите корректные данные для дешифровки файла:");
    }

    public static void printDecoderFarewell(){
        System.out.println(Constants.SUCCESSFUL_DECODING);
    }


//    public static void decode() {
//        if (key > Constants.ALPHABET.length)
//            key = key%Constants.ALPHABET.length;
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(source));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
//            while (reader.ready()) {
//                boolean isCharExist = false;
//                char fromFile = (char) reader.read();
//                for (int i = 0; i < Constants.ALPHABET.length; i++) {
//                    if (fromFile == Constants.ALPHABET[i]) {
//                        if (key > i) {
//                            writer.write(Constants.ALPHABET[Constants.ALPHABET.length - key - i]);
//                            isCharExist = true;
//                            break;
//                        }
//                        writer.write(Constants.ALPHABET[i - key]);
//                        isCharExist = true;
//                        break;
//                    }
//                }
//                if(!isCharExist)
//                    writer.write(fromFile);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//
//
//
//
//    }

    public static boolean areFilesIdentical(Path original, Path Decoded){
        try(BufferedInputStream sourceFile = new BufferedInputStream(new FileInputStream(source.toString()));
            BufferedInputStream encodedFile = new BufferedInputStream(new FileInputStream(source.toString()))) {
            int i;
            while ((i = sourceFile.read()) != -1) {
               if (i != encodedFile.read()) {
                   return false;
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  true;
    }


}
