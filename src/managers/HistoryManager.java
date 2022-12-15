/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class HistoryManager {
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;

    public HistoryManager() {
        scanner = new Scanner(System.in);
        readerManager = new ReaderManager();
        bookManager = new BookManager();
    }
    
    public History takeOnBook(List<Reader> readers, List<Book>  books){
        //из списка читателей выбрать номер читателя
        //из списка книг выбрать номер книги
        //инициировать поля History
        //добавить дату выдачи книги
        System.out.println("Список читателей: ");
        readerManager.printListReaders(readers);
        System.out.print("Выберите номер читателя из списка: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Список книг: ");
        bookManager.printListBooks(books);
        System.out.print("Выберите номер книги из списка: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        History history = new History();
        history.setBook(books.get(numberBook - 1));
        history.setReader(readers.get(numberReader - 1));
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }

    public void printListReadingBooks(List<History> histories) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMMM.yyyy");
        for (int i = 0; i < histories.size(); i++) {
            History history = histories.get(i);
            if(history.getReturnBook() == null)
            System.out.printf("%d. %s. Выдана: %s г. Читает: %s %s. Телефон: %s%n"
                    ,i+1
                    ,history.getBook().getTitle()
                    ,sdf.format(history.getTakeOnBook())
                    ,history.getReader().getFirstname()
                    ,history.getReader().getLastname()
                    ,history.getReader().getPhone()
            );
            
        }
    }

    public List<History> returnBook(List<History> histories) {
        //выбрать номер истории с выданной книгой из списка
        //прописать дату возврата в историю
        System.out.println("Список выданных книг: ");
        this.printListReadingBooks(histories);
        System.out.println("Выберите номер возвращаемой книги из списка: ");
        int numberHistory = scanner.nextInt(); scanner.nextLine();
        histories.get(numberHistory - 1).setReturnBook(new GregorianCalendar().getTime());
        return histories;
    }
}
