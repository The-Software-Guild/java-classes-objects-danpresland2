package com.m3.dvdlibrary.ui;

import java.time.LocalDate;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    private final Scanner myScanner = new Scanner(System.in);


    @Override
    public void println(String msg) {
        System.out.println(msg);
    }

    @Override
    public void print(String msg) {
        System.out.print(msg);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        print(prompt);

        int value;
        do {
            value = myScanner.nextInt();
            myScanner.nextLine();//clear newline character from scanner
        } while (value < min || value > max);

        return value;
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return myScanner.nextLine();
    }

    @Override
    public String readString(String prompt, String def) {
        String str = readString(String.format(prompt, def));
        return str.equals("") ? def : str;
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        return LocalDate.parse(readString(prompt));
    }
}
