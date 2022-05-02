package ru.javarush.kadyrov.cryptoanalizer.constants;

import java.util.HashMap;

public class Constants {
    public static final HashMap <Integer, Character> ALPHABET = initializeAlphabet();
    public static final String APP_WELCOME = "Добро пожаловать в программу шифровки и дешифровки текстовых файлов";
    public static final String COMMAND_OPTIONS = "Список доступных операций:\n" + """
            1 - шифровка текста
            2 - дешифровка текста
            3 - взлом текста методом bruteforce
            4 - взлом текста криптоанализатором
            0 - выход""".indent(25);
    public static final String APP_FAREWELL = "До свидания! Спасибо что воспользовались нашим сервисом!";
    public static final String SUCCESSFUL_ENCODING = "Операция шифровки успешно завершена. Зашифрованный файл " +
                                                     "\"EncodedFile.txt\" в папке text";
    public static final String SUCCESSFUL_DECODING = "Операция дешифровки успешно завершена. Дешифрованный файл " +
                                                     "\"DecodedFile.txt\" в папке text";
    public static final String SUCCESSFUL_BRUTFORCE = "Взлом методом BrutForce успешно завершен. Взломанный файл " +
            "\"BrutCrackedFile.txt\" в папке text";
    public static final String SUCCESSFUL_ANALIZER = "Взлом шифра криптоанализатором успешно завершен. " +
            "Зашифрованный файл \"AnalizerCrakcedFile.txt\" в папке text";

    private static HashMap <Integer, Character> initializeAlphabet() {
        char [] chars = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с',
                'т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я','А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л',
                'М','Н','О','П','Р','C','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я','.',',','«','»','"','\'',
                ':','!','?',' ','\n','q','w','e','r','t','y','u','i','o','p','[',']','\\','a','s','d','f','g','h','j','k',
                'l',';','z','x','c','v','b','n','m','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
                'Q','R','S','T','U','V','W','X','Y','Z','(',')','1','2','3','4','5','6','7','8','9','0' };
        HashMap<Integer, Character> hashmap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            hashmap.put(i, chars[i]);
        }
        return hashmap;
    }


}
