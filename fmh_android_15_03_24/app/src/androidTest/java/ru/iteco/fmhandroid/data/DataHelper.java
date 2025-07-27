package ru.iteco.fmhandroid.data;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataHelper {
    public String validLogin = "login2";
    public String validPassword = "password2";
    public String invalidInput = "test";
    public String specialSimbols = "|!%~&№:;'^";
    public String registrPassword = "PaSsWoRD2";


    public static String allNewsTitle = "ALL NEWS";


    public static String newsPageTitle = "News";
    public static String category_1 = "День рождения";
    public static String controlPanelTitle = "Control panel";
    public static String textTitle = "Test";
    public static String newNews = "Текст новой новости";


    public static String futureDate(int input) {
        String pattern = "dd.MM.yyyy";
        String date = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern(pattern));
        return date;
    }

    public static String futureTimeMinute(int input) {
        String pattern = "HH:mm";
        String time = LocalTime.now().plusMinutes(input).format(DateTimeFormatter.ofPattern(pattern));
        return time;
    }


    public static String versionText = "Version:";
//


    public static String loveTitle = "Love is all";
    public static int num = 2;
}


