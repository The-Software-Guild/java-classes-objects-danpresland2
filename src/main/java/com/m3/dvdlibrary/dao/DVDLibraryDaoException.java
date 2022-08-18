package com.m3.dvdlibrary.dao;

public class DVDLibraryDaoException extends Exception {

    public DVDLibraryDaoException(String msg){
        super(msg);
    }

    public DVDLibraryDaoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
