package ru.javarush.kadyrov.cryptoanalizer.constant;

public class Constants {
    public static final char [] ALPHABET = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с',
            'т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я','А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л',
            'М','Н','О','П','Р','C','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я','.',',','«','»','"','\'',
            ':','!','?',' ','\n','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
            'v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
            'W','X','Y','Z','(',')','1','2','3','4','5','6','7','8','9','0' };
    public static final String APP_WELCOME = "Добро пожаловать в ЧЕБУРНЕТ!";
    public static final String COMMAND_OPTIONS = "Список доступных операций:\n" + """
            1 - зашифровка данных
            2 - дешифровка данных
            3 - взлом текста методом тыка
            4 - взлом текста умным криптоанализатором
            0 - выход""".indent(25);
    public static final String APP_FAREWELL = "До свидания! Спасибо что воспользовались сервисом ЧЕБУРНЕТ!";
    public static final String SUCCESSFUL_ENCODING = "Операция шифровки успешно завершена. Зашифрованный файл " +
                                                     "\"EncodedFile.txt\" в папке text";
    public static final String SUCCESSFUL_DECODING = "Операция дешифровки успешно завершена. Дешифрованный файл " +
                                                     "\"DecodedFile.txt\" в папке text";
    public static final String SUCCESSFUL_BRUTFORCE = "Операция взлома методом тыка успешно завершена. Взломанный файл " +
            "\"BrutCrackedFile.txt\" в папке text";
    public static final String SUCCESSFUL_ANALIZER = "Операция шифровки успешно завершена. Зашифрованный файл " +
            "\"AnalizerCrakcedFile.txt\" в папке text";


}
