/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class BookManager {
    private final Scanner scanner;

    public BookManager() {
        scanner = new Scanner(System.in);
    }
    
    public Book createBook(){
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Укажите количество авторов: ");
        int countAuthorsInBook = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countAuthorsInBook; i++) {
            
            book.addAuthor(createAuthor(i+1));
        }
        return book;
    }
    private Author createAuthor(int numberAuthor) {
        Author author = new Author();
        System.out.println("Введите имя "+numberAuthor+" автора: ");
        author.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию "+numberAuthor+" автора: ");
        author.setLastname(scanner.nextLine());
        return author;
    }
    public void printListBooks(List<Book>  books){
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.printf(i+1+". %s. ",b.getTitle());
            for (int j = 0; j < b.getAuthors().size(); j++) {
                System.out.printf("%s %s. ",
                        b.getAuthors().get(j).getFirstname(),
                        b.getAuthors().get(j).getLastname());
                }
                System.out.println();
            }
    }

    public List<Book> changeBook(List<Book> books) {
        System.out.println("Список книг: ");
        this.printListBooks(books);
        System.out.print("Выберите номер книги для редактирования: ");
        int numBookForEdit = scanner.nextInt();scanner.nextLine();
        System.out.println("Название книги: "+books.get(numBookForEdit - 1).getTitle());
        System.out.println("Изменить название книги? (y/n)");
        String edit = scanner.nextLine();
        if(edit.equals("y")){
            System.out.print("Введите новое название книги: ");
            books.get(numBookForEdit - 1).setTitle(scanner.nextLine());
        }
        System.out.println("Авторов у книги "+books.get(numBookForEdit - 1).getAuthors().size());
        System.out.println("Изменить авторов? (y/n)");
        edit = scanner.nextLine();
        if(edit.equals("y")){
            System.out.println("Изменить количество авторов? (y/n)");
            edit = scanner.nextLine();
            if(edit.equals("y")){
                // Меняем количество авторов
                System.out.print("Введите новое количество авторов: ");
                int newCountAuthorsInBook = scanner.nextInt();
                scanner.nextLine();
                // количество авторов может быть больше или меньше.
                if(newCountAuthorsInBook < books.get(numBookForEdit - 1).getAuthors().size()){
                    //если меньше, выводим нумерованный список авторов и просим указать какого удалить
                    // вычисляем на сколько меньше 
                    int deltaAuthors = books.get(numBookForEdit - 1).getAuthors().size() - newCountAuthorsInBook;
                    for (int n = 0; n < deltaAuthors; n++) {
                        //удаляем лишних (deltaAuthors) авторов из книги
                        for (int i = 0; i < books.get(numBookForEdit - 1).getAuthors().size(); i++) {
                            System.out.println(
                                        i+1+". "+books.get(numBookForEdit - 1).getAuthors().get(i).getFirstname()+" "+
                                                books.get(numBookForEdit - 1).getAuthors().get(i).getLastname());
                            }
                        System.out.println("Какого автора удалить? ");
                        int numDeleteAuthor = scanner.nextInt();
                        scanner.nextLine();
                        books.get(numBookForEdit - 1).removeAuthor(numDeleteAuthor-1);
                    }
                }else{
                    for (int i = 0; i < newCountAuthorsInBook; i++) {
                        //если счетчик больше количесвтва авторов
                        if(i >= books.get(numBookForEdit - 1).getAuthors().size()){
                            // добаляем нового автора в книгу
                            Author newAuthor = new Author();
                            System.out.print("Введите имя автора "+(i+1)+": ");
                            newAuthor.setFirstname(scanner.nextLine());
                            System.out.print("Введите фамилию атора "+(i+1)+": ");
                            newAuthor.setLastname(scanner.nextLine());
                            books.get(numBookForEdit - 1).addAuthor(newAuthor);
                        }
                    }
                }
            }
            System.out.print("Изменить данные авторов?: ");
            edit = scanner.nextLine();
            if(edit.equals("y")){
                System.out.println("Список авторов: ");
                for (int i = 0; i < books.get(numBookForEdit - 1).getAuthors().size(); i++) {
                    System.out.printf("%d. %s %s.%n"
                            ,i+1
                            ,books.get(numBookForEdit - 1).getAuthors().get(i).getFirstname()
                            ,books.get(numBookForEdit - 1).getAuthors().get(i).getLastname()
                    );
                }
                System.out.print("Выберите автора для редактирования:");
                int numEditAuthor = scanner.nextInt(); scanner.nextLine();
                System.out.print("Введите имя автора ("+numEditAuthor+"): ");
                books.get(numBookForEdit-1).getAuthors().get(numEditAuthor-1).setFirstname(scanner.nextLine());
                System.out.print("Введите фамилию автора ("+numEditAuthor+"): ");
                books.get(numBookForEdit-1).getAuthors().get(numEditAuthor-1).setLastname(scanner.nextLine());
            }
        }
        
        return books;
        
    }
    private Book changeBookName(Book book) {
        System.out.print("Название книги: ");
        System.out.println(book.getTitle());
        System.out.print("Изменить название книги? (y/n)");
        String edit = scanner.nextLine();
        System.out.println();
        if(edit.equals("y")){
            System.out.print("Введите новое название книги: ");
            book.setTitle(scanner.nextLine());
        }
        return book;
    }

//    private Book deleteAuthorBook(Book book) {
//        for (int i = 0; i < book.getAuthors().length; i++) {
//            System.out.println(
//                    i+1+". "+book.getAuthors()[i].getFirstname()+" "+
//                            book.getAuthors()[i].getLastname());
//        }
//        System.out.println("Какого автора удалить? ");
//        int numDeleteAuthor = scanner.nextInt();
//        scanner.nextLine();
//        book.removeAuthor(numDeleteAuthor);
//        return book;
//    }
//    private Book changeAuthorBook(Book book){
//        for (int i = 0; i < book.getAuthors().length; i++) {
//            // изменяем существующих авторов книги
//            System.out.println(i+1+"-й автор: "
//                +book.getAuthors()[i].getFirstname()+" "+
//                       book.getAuthors()[i].getLastname());
//            System.out.print("Изменить имя автора? (y/n)");
//            String edit = scanner.nextLine();
//            if(edit.equals("y")){
//                System.out.print("Введите новое имя атора: ");
//                book.getAuthors()[i].setFirstname(scanner.nextLine());
//            }    
//            System.out.print("Изменить фамилию автора? (y/n)");
//            edit = scanner.nextLine();
//            if(edit.equals("y")){
//                System.out.print("Введите новую фамилию атора: ");
//                book.getAuthors()[i].setLastname(scanner.nextLine());
//            }    
//        }
//        return book;
//    }
}
