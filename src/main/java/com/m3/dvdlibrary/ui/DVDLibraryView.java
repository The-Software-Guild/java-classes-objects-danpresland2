package com.m3.dvdlibrary.ui;

import com.m3.dvdlibrary.dto.DVD;

import java.time.LocalDate;
import java.util.List;

public class DVDLibraryView {

    private final UserIO io;

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
                3. Edit DVD
                4. List DVDs
                5. Display DVD
                6. Search for DVD
                7. Load library
                8. Save library
                0. Quit."""
                );

        return io.readInt("Enter choice :: ", 0, 8);
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

        DVD currentDVD = new DVD(title, releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setUserNote(userNote);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(studio);

        return currentDVD;
    }

    public DVD editDVD(DVD dvd) {
        String title = dvd.getTitle();
        LocalDate releaseDate = dvd.getReleaseDate();
        String mpaaRating = dvd.getMpaaRating();
        String directorsName = dvd.getDirectorsName();
        String studio = dvd.getStudio();
        String userNote = dvd.getUserNote();

        displayBanner(title);

        String newMpaaRating = io.readString("mpaa Rating '%s' -> ", mpaaRating);
        String newDirectorsName = io.readString("Directors Name '%s' -> ", directorsName);
        String newStudio = io.readString("Studio '%s' -> ", studio);
        String newUserNote = io.readString("User notes '%s' -> ", userNote);

        DVD editedDVD = new DVD(title, releaseDate);
        editedDVD.setMpaaRating(newMpaaRating);
        editedDVD.setDirectorsName(newDirectorsName);
        editedDVD.setStudio(newStudio);
        editedDVD.setUserNote(newUserNote);

        return editedDVD;
    }

    public void displayErrorMessage(String eMsg) {
        io.println(decoratedBanner("ERROR"));
        io.println(eMsg);
    }

    public void displayCreateDVDBanner(){
        displayBanner("CREATE DVD");

    }

    public void displayCreateSuccessBanner(){
        displayBanner("DVD CREATED SUCCESSFULLY");

    }

    public void displayDVDAlreadyExistsBanner() {
        displayBanner("DVD NOT CREATED : TITLE ALREADY EXISTS");
    }

    public void displayRemoveDVDBanner() {
        displayBanner("REMOVE DVD");

    }

    public String getDVDTitleChoice() {
        return io.readString("Title :: ");
    }

    public void displayRemoveResult(DVD removedDVD) {
        if (removedDVD == null) io.println("[!] DVD not found and not removed.");
        else io.println(String.format("[!] DVD \"%s\" removed successfully.", removedDVD.getTitle()));
    }

    public void displayDisplayAllBanner() {
        displayBanner("DISPLAY ALL");

    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD tempDVD : dvdList){
            System.out.println(tempDVD.getTitle());
        }
    }

    public void displayDisplayDVDBanner() {
        displayBanner("DISPLAY DVD");

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
        displayBanner("unknown command");

    }


    public void displayExitBanner() {
        displayBanner("bye x");

    }

    public void displaySearchDVDBanner() {
        displayBanner("SEARCH FOR DVD");
    }

    public void displayBanner(String msg) {
        io.println("\n" + decoratedBanner(msg));
    }

    public void displayEditDVDBanner() {
        displayBanner("EDIT DVD");
    }
}