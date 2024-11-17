import java.util.HashMap;

class Book { //определяет класс, который представляет книгу
    private String title;
    private String author;
    private int copies;

    public Book(String title, String author, int copies) { //инициализация
        this.title = title;
        this.author = author;
        this.copies = copies;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {

        return copies;
    }

    // Метод для изменения количества копий
    public void setCopies(int copies) {

        this.copies = copies;
    }
}

public class Library { //определяет класс Библиотека
    private HashMap<String, Book> bookMap; // Явное объявление HashMap

    public Library() {
        bookMap = new HashMap<>(); //создает поле bookMap типа HashMap, которое будет хранить книги с ключом ISBN.
    }

    public Book addBook(String isbn, Book book) {

        bookMap.put(isbn, book); // Добавление книги в хэш-таблиц
        return book;
    }

    public Book findBook(String isbn) {

        return bookMap.get(isbn);
    }

    public Book removeBook(String isbn) {

        bookMap.remove(isbn);
        return null;
    }
}