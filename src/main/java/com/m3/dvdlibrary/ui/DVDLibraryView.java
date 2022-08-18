package com.m3.dvdlibrary.ui;

import com.m3.dvdlibrary.dto.DVD;

import java.time.LocalDate;
import java.util.List;

public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io){
        this.io = io;
    }

    public  int printMenuAndGetSelection(){
        io.println("\n" + "*".repeat(50));
        io.println("""
                ╭—————————————╮
                │   Choices   │
                ╰—————————————╯
                1. Create DVD
                2. Remove DVD
                3. List DVDs
                4. Display DVD
                5. Search for DVD
                6. Load library
                7. Save library
                0. Quit."""
                );

        return io.readInt("Enter choice :: ", 1, 5);
    }

    private String decoratedBanner(String msg) {
        return " %1$s %2$s %1$s ".formatted("-----", msg);
    }

    public DVD getNewDVD() {
        String title = io.readString("Title :: ");
        LocalDate releaseDate = io.readLocalDate("Release Date :: ");
        String mpaaRating = io.readString("mpaa Rating :: ");
        String directorsName = io.readString("Directors Name :: ");
        String studio = io.readString("Studio :: ");
        String userNote = io.readString("User notes :: ");

        DVD currentDVD = new DVD(title, releaseDate, directorsName, studio);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setUserNote(userNote);

        return currentDVD;
    }

    public void displayErrorMessage(String eMsg) {
        io.println(decoratedBanner("ERROR"));
        io.println(eMsg);
    }

    public void displayCreateDVDBanner(){
        displayBannerOpen("CREATE DVD");

    }

    public void displayCreateSuccessBanner(){
        displayBannerOpen("DVD CREATED SUCCESSFULLY");

    }


    public void displayRemoveDVDBanner() {
        displayBannerOpen("REMOVE DVD");

    }

    public String getDVDTitleChoice() {
        return io.readString("Title :: ");
    }

    public void displayRemoveResult(DVD removedDVD) {
        if (removedDVD == null) io.println("[!] DVD not found and not removed.");
        else io.println(String.format("[!] DVD \"%s\" removed successfully.", removedDVD.getTitle()));
    }

    public void displayDisplayAllBanner() {
        displayBannerOpen("DISPLAY ALL");

    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD tempDVD : dvdList){
            System.out.println(tempDVD.getTitle());
        }
    }

    public void displayDisplayDVDBanner() {
        displayBannerOpen("DISPLAY DVD");

    }

    public void displayDVD(DVD dvd) {
        io.println("——————————");

        io.println(dvd.getTitle());
        io.println(dvd.getReleaseDate().toString());
        io.println(dvd.getMpaaRating());
        io.println(dvd.getDirectorsName());
        io.println(dvd.getStudio());
        io.println(dvd.getUserNote());

        io.println("——————————");
    }

    public void displayUnknownCommandBanner() {
        displayBannerOpen("unknown command");

    }


    public void displayExitBanner() {
        displayBannerOpen("bye x");

    }

    public void displaySearchDVDBanner() {
        displayBannerOpen("SEARCH FOR DVD");
    }

    public void displayBannerOpen(String msg) {
        io.println("\n" + decoratedBanner(msg));
    }
}