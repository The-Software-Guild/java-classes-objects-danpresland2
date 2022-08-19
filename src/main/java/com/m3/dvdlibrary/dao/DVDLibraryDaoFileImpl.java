package com.m3.dvdlibrary.dao;

import com.m3.dvdlibrary.dto.DVD;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibaryDao {

    private Map<String, DVD> dvds = new HashMap<>();

    public static final String LIBRARY_FILE = "src/main/resources/library.txt";
    public static final String DELIMITER = "::";


    @Override
    public DVD addDVD(String title, DVD dvd) {
        if (dvds.containsKey(title)) return dvds.get(title);
        else return dvds.put(title, dvd);
    }

    @Override
    public ArrayList<DVD> getAllDVDs() {
        return new ArrayList<>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        if (!dvds.containsKey(title)) throw new DVDLibraryDaoException("DVD not found");
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) {
        return dvds.remove(title);
    }


    private String marshallDVD(DVD aDVD){
        String dvdAsText = aDVD.getTitle() + DELIMITER;

        dvdAsText += aDVD.getReleaseDate().toString() + DELIMITER;
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
        dvdAsText += aDVD.getDirectorsName() + DELIMITER;
        dvdAsText += aDVD.getStudio() + DELIMITER;
        dvdAsText += aDVD.getUserNote();

        return dvdAsText;
    }


    private DVD unmarshallDVD(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];
        LocalDate releaseDate = LocalDate.parse(dvdTokens[1]);
        String mpaaRating = dvdTokens[2];
        String directorsName = dvdTokens[3];
        String studio = dvdTokens[4];
        String userNote = dvdTokens[5];

        DVD dvdFromFile = new DVD(title, releaseDate, directorsName, studio);

        dvdFromFile.setMpaaRating(mpaaRating);
        dvdFromFile.setUserNote(userNote);

        return dvdFromFile;
    }


    public void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new DVDLibraryDaoException("Could not load library data into memory", e);
        }

        String currentLine;
        DVD currentDVD;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();
    }


    public void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save library.", e);
        }

        String dvdAsText;
        ArrayList<DVD> dvdList = this.getAllDVDs();

        for (DVD currDVD : dvdList) {
            dvdAsText = marshallDVD(currDVD);
            out.println(dvdAsText);
            out.flush();
        }

        out.close();

    }

}