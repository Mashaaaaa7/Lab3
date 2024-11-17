public class Main {

    public static void main(String[] args) {
        Library library = new Library(); //создает объект Library

        // Добавление книг
        library.addBook("978-0143034231", new Book("1984", "George Orwell", 5));
        library.addBook("978-0141439501", new Book("Pride and Prejudice", "Jane Austen", 2));

        // Поиск книги
        Book foundBook = library.findBook("978-0143034231");
        if (foundBook != null) { //проверяет, найдена ли книга.
            System.out.println("Найдена книга: " + foundBook.getTitle() + " by " + foundBook.getAuthor() + ", " + foundBook.getCopies() + " copies");
        } else {
            System.out.println("Книга не найдена." + foundBook.getTitle() + " by " + foundBook.getAuthor() + ", " + foundBook.getCopies() + " copies");
        }

        Book foundBook2 = library.findBook("978-0141439501");
        if (foundBook2 != null) {
            System.out.println("Найдена книга: " + foundBook2.getTitle() + " by " + foundBook2.getAuthor() + ", " + foundBook2.getCopies() + " copies");
        } else {
            System.out.println("Книга не найдена.");
        }

        // Удаление книги
        library.removeBook("978-0141439501");

        // Поиск удаленной книги
        foundBook = library.findBook("978-0143034231");
        if (foundBook != null) {
            System.out.println("Книга найдена: " + foundBook.getTitle() + " by " + foundBook.getAuthor() +  ", " + foundBook.getCopies() + " copies");
        } else {
            System.out.println("Книга не найдена.");
        }


        foundBook2 = library.findBook("978-0141439501");
        if (foundBook2 != null) {
            System.out.println("Книга найдена: " + foundBook2.getTitle() + " by " + foundBook2.getAuthor() +  ", " + foundBook.getCopies() + " copies");
        } else {
            System.out.println("Книга не найдена.");
        }
    }
}