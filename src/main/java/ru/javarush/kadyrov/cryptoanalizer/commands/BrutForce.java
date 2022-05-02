package ru.javarush.kadyrov.cryptoanalizer.commands;

import ru.javarush.kadyrov.cryptoanalizer.constants.Constants;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class BrutForce {

    private static final HashMap<Integer,Character> ALPHABET = Constants.ALPHABET;
    private static int key;
    private static Path source;
    private static Path destination = Path.of("C:\\Users\\Lenovo\\IdeaProjects\\CryptoAnalizer\\text\\BrutCrackedFile.txt");
    private static final char [] chars = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с',
            'т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я','А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л',
            'М','Н','О','П','Р','C','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я','.',',','«','»','"','\'',
            ':','!','?',' ','\n','q','w','e','r','t','y','u','i','o','p','[',']','\\','a','s','d','f','g','h','j','k',
            'l',';','z','x','c','v','b','n','m','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z','(',')','1','2','3','4','5','6','7','8','9','0' };
    private static final String [] prepositions = {" около ", " через ", " перед ", " между ", " под ", " над ", " про ",
            " при ", " без ", " на ", " за ", " по ", " из ", " до "};


    public static void start() {
        printBrutForceWelcome();
        setSourceFile();
//        setDestinationFile();
//        setExampleFile();
//        brutForce2();
        encode(30);
        printBrutForceFarewell();
    }

//    public static void setExampleFile() {
//        Path path;
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Введите адрес проверочного файла с расширением .txt: ");
//            try {
//                path = Path.of(scanner.nextLine());
//                if (Files.exists(path)) {
//                    source = path;
//                    if (path.toString().endsWith(".txt"))
//                        break;
//                    else
//                        System.out.println("Исходный файл должен быть с расширением .txt. Повторите ввод.");
//
//                } else {
//                    System.out.println("Введены некорректные данные. Повторите ввод.");
//                }
//            } catch (InvalidPathException e) {
//                System.out.println("Введены некорректные данные. Повторите ввод.");
//            }
//        }
//    }

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
            System.out.print("Введите абсолютный адрес для расшифрованного файла с расширением .txt: ");
            try {
                path = Path.of(scanner.nextLine());
                if (path.isAbsolute()) {
                    if (path.toString().endsWith(".txt")){
                        destination = path;
                        break;
                    } else
                        System.out.println("Исходный файл должен быть с расширением .txt. Повторите ввод.");
                } else {
                    System.out.println("Введены некорректные данные. Повторите ввод.");
                }
            } catch (InvalidPathException e) {
                System.out.println("Введены некорректные данные. Повторите ввод.");
            }
        }
    }

    public static void brutForce2() {
        Date start = new Date();
        boolean isExit = false;

        for (int key = 1; key < chars.length - 1 && !isExit; key++) {
            encode(key);
            BrutForce.key = key;
            int matchesCount = 0;
            try (BufferedReader reader  = new BufferedReader(new FileReader(destination.toString()))) {
                while (reader.ready() && matchesCount < 20) {
                    String s = reader.readLine();
                    for (int i = 0; i < prepositions.length; i++) {
                    if (s.matches(prepositions[i]))
                        if (i < 4)
                            matchesCount += 9;
                    else if (i < 8)
                        matchesCount += 3;
                    else
                        matchesCount += 1;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("MatchesCount = " + matchesCount + "      " + "key = " + key);
            if (matchesCount > 20)
                isExit = true;

        }
        Date end = new Date();
        System.out.printf("BrutForce successfully finished in %d ms\n",end.getTime()- start.getTime());
        System.out.println("key = " + key);
    }

    public static void printBrutForceWelcome(){
        System.out.println("==================================================");
        System.out.println("Выбрана операция взлома шифра методом BrutForce...");
        System.out.println("==================================================");
    }

    public static void printBrutForceFarewell(){
        System.out.println(Constants.SUCCESSFUL_BRUTFORCE);
    }

    private static void encode (int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source.toString()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination.toString()))) {
            while (reader.ready()) {
                int i = reader.read();
                char charFromSource = (char) i;
                char replacing;
                boolean isCharExists = false;
                for (int j = 0; j < chars.length; j++) {
                    if (charFromSource == chars[j]) {
                        isCharExists = true;
                        if (j + key > chars.length - 1) {
                            replacing = chars[j + key - chars.length];
                            writer.write(replacing);
                            break;
                        } else {
                            replacing = chars[j + key];
                            writer.write(replacing);
                            break;
                        }
                    }
                }
                if (!isCharExists)
                    writer.write(charFromSource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
