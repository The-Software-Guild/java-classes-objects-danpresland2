package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    private Scanner myScanner = new Scanner(System.in);


    @Override
    public void println(String msg) {
        System.out.println(msg);
    }

    @Override
    public void print(String msg) {
        System.out.print(msg);
    }

    @Override
    public double readDouble(String prompt) {
        return 0;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        return 0;
    }

    @Override
    public float readFloat(String prompt) {
        return 0;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        return 0;
    }

    @Override
    public int readInt(String prompt) {
        return 0;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        print(prompt);
        int value = myScanner.nextInt();
        myScanner.nextLine();//clear newline character
        return value;
    }

    @Override
    public long readLong(String prompt) {
        return 0;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        return 0;
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return myScanner.nextLine();
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        return LocalDate.parse(readString(prompt));
    }
}
