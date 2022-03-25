package ru.javarush.kadyrov.cryptoanalizer.constant;

public class Constants {
    public static final char [] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и','к', 'л', 'м', 'н', 'о', 'п',
                                            'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я',
                                            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '\n'};
    public static final String WELCOME = "Добро пожаловать в ЧЕБУРНЕТ!\nСписок доступных операций:";
    public static final String COMMAND_OPTIONS = """
            1 - зашифровка данных
            2 - дешифровка данных
            3 - взлом текста методом тыка
            4 - взлом текста умным криптоанализатором
            0 - выход""".indent(25);
    public static final String FAREWELL = "До свидания! Спасибо что воспользовались сервисом ЧЕБУРНЕТ!";
    public static final String SUCCESSFUL_ENCODING = "Операция шифровки успешно завершена. Зашифрованный файл " +
                                                     "\"EncodedFile.txt\" в папке text";
    public static final String SUCCESSFUL_DECODING = "Операция шифровки успешно завершена. Зашифрованный файл " +
                                                     "\"DecodedFile.txt\" в папке text";
    public static final String SUCCESSFUL_BRUTFORCE = "Операция взлома методом тыка успешно завершена. Взломанный файл " +
            "\"BrutCrackedFile.txt\" в папке text";
    public static final String SUCCESSFUL_ANALIZER = "Операция шифровки успешно завершена. Зашифрованный файл " +
            "\"AnalizerCrakcedFile.txt\" в папке text";


}
