package com.m3.dvdlibrary.dto;

import java.time.LocalDate;

public class DVD {

    private final String title;
    private final LocalDate releaseDate;
    private String mpaaRating;
    private String directorsName;
    private String studio;
    private String userNote;

    public DVD(String title, LocalDate releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }


    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
