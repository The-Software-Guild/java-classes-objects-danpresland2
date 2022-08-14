package org.example;

import java.util.List;

public interface DVDLibaryDao {

    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    DVD getDVD(String title) throws DVDLibraryDaoException;

    DVD removeDVD(String title) throws DVDLibraryDaoException;


}
