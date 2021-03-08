package uci.fvm.model;

/**
 * Created by Diosbel E. Lima on 08/04/2017.
 */

public class Author {
    private String id;
    private String name;
    private String author_description;


    private int thumbnail;

    public Author(String name, String author_description, int thumbnail) {
        this.name = name;
        this.author_description = author_description;
        this.thumbnail=thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getAuthor_description() {
        return author_description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

}