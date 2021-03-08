package uci.fvm.model;

/**
 * Created by Diosbel E. Lima on 08/04/2017.
 */

public class Book {
    private String name;
    private String description;
    private String gender;
    private int thumbnail;
    private byte recommended;


    public Book(String name, String description, String gender, int thumbnail) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    public byte getRecommended() {
        return recommended;
    }
}