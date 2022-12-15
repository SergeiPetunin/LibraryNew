/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import managers.interfaces.SaveManagerInterface;

/**
 *
 * @author pupil
 */
public class BaseManager implements SaveManagerInterface{
    
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public BaseManager() {
        emf = Persistence.createEntityManagerFactory("LibraryNEWPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public void saveBooks(List<Book>books) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            for (int j = 0; j < book.getAuthors().size(); j++) {
                Author author = book.getAuthors().get(j);
                if(author.getId() == null) {
                    em.persist(author);
                }else{
                    em.merge(author);
                }
            }
            if(book.getId() == null) {
                em.persist(book);
            }else{
                em.merge(book);
            }
        }
        em.getTransaction().commit();
    }
    
    @Override
    public List<Book> loadBooks() {
        return em.createQuery("SELECT b FROM Book b")
                .getResultList();
    }
    
        //----------------------------------------------------------------

    
    @Override
    public void saveReaders(List<Reader>readers) {
        for (int i = 0; i < readers.size(); i++) {
            Reader reader = readers.get(i);
            if(reader.getId() == null) {
                em.persist(reader);
            }else{
                em.merge(reader);
            }
        }
        em.getTransaction().commit();
    }
    
    @Override
    public List<Reader> loadReaders() {
        return em.createQuery("SELECT r FROM Reader r")
                .getResultList();
    }
    
        //----------------------------------------------------------------
    
    @Override
    public void saveHistories(List<History>histories) {
        for (int i = 0; i < histories.size(); i++) {
            History history = histories.get(i);
            if(history.getId() == null) {
                em.persist(history);
            }else{
                em.merge(history);
            }
        }
        em.getTransaction().commit();
    }
    
    @Override
    public List<History> loadHistories() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }

}
