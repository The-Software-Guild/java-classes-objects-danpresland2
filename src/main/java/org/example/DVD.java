package org.example;

import java.time.LocalDate;

public class DVD {

    private final String title;
    private final LocalDate releaseDate;
    private String mpaaRating;
    private final String directorsName;
    private final String studio;
    private String userNote;

    public DVD(String title, LocalDate releaseDate, String directorsName, String studio) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.directorsName = directorsName;
        this.studio = studio;
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


}
