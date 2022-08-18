package com.m3.dvdlibrary;

import com.m3.dvdlibrary.controller.DVDLibraryController;
import com.m3.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.m3.dvdlibrary.ui.DVDLibraryView;
import com.m3.dvdlibrary.ui.UserIO;
import com.m3.dvdlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {

        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDaoFileImpl dao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(dao, view);

        controller.run();
    }
}