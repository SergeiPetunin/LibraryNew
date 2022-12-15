/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import managers.interfaces.SaveManagerInterface;

/**
 *
 * @author Melnikov
 */
public class DataManager  implements SaveManagerInterface{
    private final String FILENAME_BOOKS = "files/MyBooks";
    private final String FILENAME_READERS = "files/MyReaders";
    private final String FILENAME_HISTORIES = "files/MyHistories";
    private final File file;
    public DataManager() {
        file = new File("files");
        file.mkdirs();
    }
    
    @Override
    public void saveBooks(List<Book>  books){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_BOOKS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    public List<Book>  loadBooks() {
        List<Book>  books = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_BOOKS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return books;
    }

    @Override
    public void saveReaders(List<Reader> readers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_READERS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(readers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    @Override
    public List<Reader> loadReaders() {
        List<Reader> readers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_READERS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readers = (List<Reader>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return readers;
    }
    @Override
    public void saveHistories(List<History> histories) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_HISTORIES);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(histories);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    @Override
    public List<History> loadHistories() {
        List<History> histories = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_HISTORIES);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            histories = (List<History>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return histories;
    }
}
