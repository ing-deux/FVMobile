package uci.fvm.model;

/**
 * Created by Diosbel E. Lima on 08/04/2017.
 */

public class Editorial {
    private String name_edit;
    private String description_edit;
    private int thumbnail;

    public Editorial(String name_edit, String description_edit, int thumbnail){
        this.name_edit=name_edit;
        this.description_edit=description_edit;
        this.thumbnail=thumbnail;
    }

    public String getName_edit() {
        return name_edit;
    }

    public String getDescription_edit() {
        return description_edit;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}