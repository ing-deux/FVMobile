package uci.fvm.model;

import java.util.List;

/**
 * Created by Diosbel E. Lima on 08/04/2017.
 */

public class Controller {
    private List<Editorial> editorials;
    private List<Book> books;
    private List<Author> authors;

    public Controller(List<Book> books, List<Author> authors, List<Editorial> editorials) {
        this.editorials = editorials;
        this.books = books;
        this.authors = authors;
    }

    public List<Editorial> getEditorials() {
        return editorials;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}

