package com.m3.dvdlibrary.controller;

import com.m3.dvdlibrary.dao.DVDLibraryDaoException;
import com.m3.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.m3.dvdlibrary.dto.DVD;
import com.m3.dvdlibrary.ui.DVDLibraryView;

import java.time.LocalDate;
import java.util.ArrayList;

public class DVDLibraryController {

    private final DVDLibraryView view;
    private final DVDLibraryDaoFileImpl dao;

    public DVDLibraryController(DVDLibraryDaoFileImpl dao, DVDLibraryView view){
        this.dao = dao;
        this.view = view;
    }

    public void run(){
        boolean keepGoing = true;
        int menuSelection;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1 -> createDVD();
                    case 2 -> removeDVD();
                    case 3 -> editDVD();
                    case 4 -> listDVDs();
                    case 5 -> displayDVD();
                    case 6 -> searchDVD();
                    case 7 -> loadLibrary();
                    case 8 -> saveLibrary();
                    case 0 -> keepGoing = false;
                    default -> unknownCommand();
                }
            }
            exitMessage();

        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVD();
        DVD createDVDResult = dao.addDVD(newDVD.getTitle(), newDVD);

        if (createDVDResult.equals(newDVD)) view.displayCreateSuccessBanner();
        else view.displayDVDAlreadyExistsBanner();
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD removedDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedDVD);
    }

    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();

        String dvdTitle = view.getDVDTitleChoice();
        DVD uneditedDVD = dao.getDVD(dvdTitle);

        DVD editedDVD = view.editDVD(uneditedDVD);

        dao.removeDVD(dvdTitle);
        dao.addDVD(dvdTitle, editedDVD);

    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();

        ArrayList<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void displayDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();

        String dvdTitle = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(dvdTitle);
        view.displayDVD(dvd);
    }

    private void searchDVD() throws DVDLibraryDaoException {
        view.displaySearchDVDBanner();

        view.displaySearchTypes();
        int searchType = view.getSearchType();

        switch (searchType) {
            case 1 -> searchByTitle();
            case 2 -> searchSinceDate();
            case 3 -> searchByMPAARating();
            case 4 -> searchByDirector();
            case 5 -> searchByStudio();
            case 6 -> findAverageMovieAge();
            case 7 -> findNewestMovie();
            case 8 -> findOldestMovie();
            default -> unknownCommand();
        }
    }

    private void searchByStudio() {
        String studio = view.getSearchTerm("Studio :: ");
        view.displayDVDList(dao.searchByStudio(studio));
    }

    private void searchByDirector() {
        String director = view.getSearchTerm("Director :: ");
        view.displayDVDList(dao.searchByDirector(director));
    }

    private void searchByMPAARating() {
        String rating = view.getSearchTerm("Rating :: ");
        view.displayDVDList(dao.searchByRating(rating));
    }

    private void searchByTitle() {
        String dvdTitle = view.getDVDTitleChoice();
        view.displayDVDList(dao.searchByTitle(dvdTitle));
    }

    private void searchSinceDate() {
        LocalDate date = view.getDate();
        view.displayDVDList(dao.searchBySinceDate(date));
    }

    private void findAverageMovieAge() {
        view.displayAverageMovieAge(dao.findAverageMovieAge());
    }

    private void findNewestMovie() {
        view.displayDVD(dao.findNewestMovie());
    }

    private void findOldestMovie() {
        view.displayDVD(dao.findOldestMovie());
    }

    private void loadLibrary() throws DVDLibraryDaoException {
        dao.loadLibrary();
    }

    private void saveLibrary() throws DVDLibraryDaoException {
        dao.writeLibrary();
    }


    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage(){
        view.displayExitBanner();
    }



}
