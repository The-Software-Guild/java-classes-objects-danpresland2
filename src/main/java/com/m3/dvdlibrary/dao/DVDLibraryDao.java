package com.m3.dvdlibrary.dao;

import com.m3.dvdlibrary.dto.DVD;

import java.time.LocalDate;
import java.util.List;

public interface DVDLibraryDao {

    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    DVD getDVD(String title) throws DVDLibraryDaoException;

    DVD removeDVD(String title) throws DVDLibraryDaoException;


    List<DVD> searchByStudio(String studio);

    List<DVD> searchByDirector(String director);

    List<DVD> searchByRating(String rating);

    List<DVD> searchByTitle(String title);

    List<DVD> searchBySinceDate(LocalDate date);

    DVD findOldestMovie();

    DVD findNewestMovie();

    Double findAverageMovieAge();
}
