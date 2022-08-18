package com.m3.dvdlibrary.dao;

import com.m3.dvdlibrary.dto.DVD;

import java.util.List;

public interface DVDLibaryDao {

    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    DVD getDVD(String title) throws DVDLibraryDaoException;

    DVD removeDVD(String title) throws DVDLibraryDaoException;


}
