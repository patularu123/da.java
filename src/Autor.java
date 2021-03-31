import java.util.*;
public class Autor extends Persoana {
    private String CitatMemorabil;
    private String GenLiterar;
    public ArrayList<Carte> books;
    protected String firstName;
    protected String lastName;
    protected Date dateOfBirth;

    public Autor(String _firstName, String _lastName) {
        super(_firstName, _lastName);
        books = new ArrayList<>();
    }

    public void setGenLiterar(String GenLiterar)
    {
        this.GenLiterar=GenLiterar;
    }
    public void addBook(Carte _book) {
        books.add(_book);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public  void setCitatMemorabil(String CitatMemorabil)
    {
        this.CitatMemorabil=CitatMemorabil;
    }

    public void showBooks() {
        for (Carte book : books)
            System.out.println(book);
    }
    @Override
    double CalculeazaSalariu()
    {
        switch (GenLiterar.toUpperCase())
        {
            case "LIRIC":
                return Salariu + Salariu*0.5;
            case "EPIC":
                return Salariu*3;
            case "DRAMATIC":
                return Salariu*2;
            default: return  Salariu;
        }
    }
    @Override
    public String toString() {
        return super.toString()+'\n'+"Citatul reprezentativ pentru acest autor este:'"+CitatMemorabil+"'. Genul Literar reprezentativ este :"+ GenLiterar+" si a obtinut salariul de baza "+Salariu+" lei";
    }
}
