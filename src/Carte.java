import java.util.*;
public class Carte implements Comparable{
    protected String bookName;
    protected String authorFirstName;
    protected String authorLastName;
    protected Date publishDate;
    public ArrayList<Carte> books;
    public ArrayList<Autor> autori;

    public Carte (String _bookName, String _authorFirstName, String _authorLastName, Date _publishDate){
        bookName = _bookName;
        authorFirstName = _authorFirstName;
        authorLastName = _authorLastName;
        publishDate = _publishDate;
    }
    public ArrayList<Autor> getAutori() {
        return autori;
    }
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorName(String authorFirstName, String authorLastName) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setAutori(ArrayList<Autor> autori) {
        this.autori = autori;
    }
    public void addBook(Carte _book) {
        books.add(_book);
    }
    public void showBooks() {
        for (Carte book : books)
            System.out.println(book);
    }
    @Override
    public int compareTo(Object o) {
        Carte tmp = ((Carte) o);

        if ( bookName.equals(tmp.bookName))
            return authorLastName.compareTo(tmp.authorLastName);
        return bookName.compareTo(tmp.bookName);
    }

    @Override
    public String toString() {
        return bookName + " scrisa de " + authorFirstName + " " + authorLastName + " ";
    }
}
