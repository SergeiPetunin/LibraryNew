/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Melnikov
 */

public class Book implements Serializable{
    private String title;
    private List<Author> authors = new ArrayList<>(); 

    public Book() {
        
    }

    public Book(String title, List<Author> authors) {
        this.title = title;
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{"
                + "title=" + title 
                + ", authors=" + Arrays.toString(authors.toArray())
                + '}';
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
    
    public void removeAuthor(int indexRmAuthor){
        this.authors.remove(indexRmAuthor);
    }
    
    
    
}
