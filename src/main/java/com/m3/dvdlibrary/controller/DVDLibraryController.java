package com.m3.dvdlibrary.controller;

import com.m3.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.m3.dvdlibrary.dto.DVD;
import com.m3.dvdlibrary.dao.DVDLibraryDaoException;
import com.m3.dvdlibrary.ui.DVDLibraryView;

import java.util.ArrayList;
import java.util.List;

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
                    case 3 -> listDVDs();
                    case 4 -> displayDVD();
                    case 5 -> searchDVD();
                    case 6 -> loadLibrary();
                    case 7 -> saveLibrary();
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
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD removedDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedDVD);
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
        //todo: move search to dao/model?
        view.displaySearchDVDBanner();

        String dvdTitle = view.getDVDTitleChoice();
        List<DVD> results = new ArrayList<>();

        for (DVD dvd : dao.getAllDVDs()){
            if (dvd.getTitle().toLowerCase().contains(dvdTitle.toLowerCase())){
                results.add(dvd);
            }
        }

        view.displayDVDList(results);

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
