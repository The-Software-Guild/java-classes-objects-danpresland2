package org.example;

import java.util.ArrayList;
import java.util.List;

public class DVDLibraryController {

    private DVDLibraryView view = new DVDLibraryView();
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryDaoFileImpl dao = new DVDLibraryDaoFileImpl();


    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection){
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        listDVDs();
                        break;
                    case 4:
                        displayDVD();
                        break;
                    case 5:
                        searchDVD();
                        break;
                    case 6:
                        loadLibrary();
                        break;
                    case 7:
                        saveLibrary();
                        break;
                    case 0:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                        break;
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

        List<DVD> dvdList = dao.getAllDVDs();
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
