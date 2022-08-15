package org.example;

public class App {
    public static void main(String[] args) {

        UserIO io = new UserIOConsoleImpl();

        DVDLibraryView view = new DVDLibraryView(io);

        DVDLibraryDaoFileImpl dao = new DVDLibraryDaoFileImpl();

        DVDLibraryController controller = new DVDLibraryController(dao, view);

        controller.run();
    }
}