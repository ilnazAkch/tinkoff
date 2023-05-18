package ru.tinkoff.edu.bot;

import java.util.ArrayList;

public class ListDB {
    static ArrayList<String> list = new ArrayList<>();

    public static void add_val(String link) {
        list.add(link);
    }

    public static String get_val() {
        return list.toString();
    }
}
