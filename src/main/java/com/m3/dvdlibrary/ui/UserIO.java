package com.m3.dvdlibrary.ui;

import java.time.LocalDate;

public interface UserIO {

    void println(String msg);

    void print(String msg);

    int readInt(String prompt, int min, int max);

    String readString(String prompt);

    String readString(String prompt, String def);

    LocalDate readLocalDate(String prompt);
}
