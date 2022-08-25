package com.m3.dvdlibrary.dto;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return Objects.equals(title, dvd.title) && Objects.equals(releaseDate, dvd.releaseDate) && Objects.equals(mpaaRating, dvd.mpaaRating) && Objects.equals(directorsName, dvd.directorsName) && Objects.equals(studio, dvd.studio) && Objects.equals(userNote, dvd.userNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, mpaaRating, directorsName, studio, userNote);
    }

    public Long getAge() {
        return ( LocalDate.now().toEpochDay() - getReleaseDate().toEpochDay() ) / 365;
    }
}
