import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Sistem {
    Sistem() {
    }

    public void menu()  {
        List<Sectiune> sectiuni = new ArrayList<>();
        List<Autor> autori = new ArrayList<>();
        List<Carte> carti = new ArrayList<>();
        String[] GenuriLiterare={"Liric","Epic","Dramatic","Comedie","Nuvela"};
        Carte book;
        String bookName;
        String authorFirstName;
        String authorLastName;
        Date publishDate;
        Autor author;
        String firstName;
        String lastName;
        int choice;

        int id;

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Choose an option:");
            System.out.println("1) Add a new book");
            System.out.println("2) See all books in a section");
            System.out.println("3) See the books written by an author");
            System.out.println("4) See all the authors in the library");
            System.out.println("5) See all the books in the library");
            System.out.println("6) Edit a book info");
            System.out.println("7) Edit author name");
            System.out.println("8) Exit");

            System.out.println("\nEnter your option: ");
            choice = scanner.nextInt();

            //System.out.println(chosen);
            try {
                switch (choice) {
                    case 1:
                        AuditService auditService = new AuditService();
                        auditService.WriteActionsToCSVFile("addBook");

                        System.out.println("     ----- Add a new book -----");
                        System.out.println("Enter the name of the book");
                        bookName = scanner.next();
                        System.out.println("Enter the name of the author");
                        authorFirstName = scanner.next();
                        authorLastName = scanner.next();
                        System.out.println("Enter the publish date of the book");
                        publishDate = new Date(scanner.next());
                        Carte _book = new Carte(bookName, authorFirstName, authorLastName, publishDate);
                        Autor _author = new Autor(authorFirstName, authorLastName);
                        Random random=new Random();
                        _author.setSalariu(random.nextInt(1000));
                        _author.setCitatMemorabil("A fi sau a nu fi");
                        _author.addBook(_book);
                        _author.setGenLiterar(GenuriLiterare[random.nextInt(4)]);

                        autori.add(_author);
                        carti.add(_book);
                        System.out.println("Select the category of the book: ");
                        System.out.println("1) Epic");
                        System.out.println("2) Liric");
                        System.out.println("3) Comedie");
                        System.out.println("4) Dramatic");
                        System.out.println("5) Basm");
                        System.out.println("6) Nuvela");
                        System.out.println("Enter the number of the category: ");
                        id = scanner.nextBigDecimal().intValue();
                        boolean ok = false;
//                        Category category = new Category(_book, AllCategories.values()[id]);
                        if (sectiuni.size() > 0){
                            for (Sectiune _section : sectiuni)
                                if(_section.getSectionName() == AllCategories.values()[id]){
                                    _section.addBook(_book);
                                    ok = true;
                                    break;
                                }
                        }
                        if(!ok){
                            Sectiune section = new Sectiune(AllCategories.values()[id-1], id);
                            section.addBook(_book);
                            sectiuni.add(section);
                        }

                        break;

                    case 2:
                        AuditService auditService1 = new AuditService();
                        auditService1.WriteActionsToCSVFile("selectTheSection");
                        System.out.println("     ----- Select the section you want to see -----");

                        System.out.println("1) Epic");
                        System.out.println("2) Liric");
                        System.out.println("3) Comedie");
                        System.out.println("4) Dramatic");
                        System.out.println("5) Basm");
                        System.out.println("6) Nuvela");
                        System.out.println("Enter the number of the category: ");
                        id = scanner.nextBigDecimal().intValue();
                        ok = false;
                        if(sectiuni.size() == 0)
                            System.out.println("Nu ati creat nicio sectiune inca!");
                        else{
                            for (Sectiune _section : sectiuni)
                                if(_section.getSectionId() == id){
                                    ok = true;
                                    _section.showBooks();
                                }
                        }
                        if(!ok)
                            System.out.println("Nu exista nicio carte in sectiunea aleasa!");

                        break;

                    case 3:
                        AuditService auditService2 = new AuditService();
                        auditService2.WriteActionsToCSVFile("writeTheNameAuthor");
                        System.out.println("     -----Write the name of the author-----");
                        System.out.println("Enter the Author's Name:");
                        String first = scanner.next();
                        String last = scanner.next();
                        for (Autor __author : autori)
                            if (__author.getFirstName().equals(first) && __author.getLastName().equals(last))
                                __author.showBooks();
                        break;

                    case 4:
                        AuditService auditService3 = new AuditService();
                        auditService3.WriteActionsToCSVFile("displayTheAuthors");
                        System.out.println("The authors with books in this library are:\n ");
                        for (Autor a : autori)
                        {
                            System.out.println(a);
                            a.getSalariu();
                        }
                        break;

                    case 5:
                        System.out.println("The list of books in this library is: \n");
                        for (Carte b : carti)
                            System.out.println(b);
                        break;

                    case 6:
                        int idBook;
                        boolean exista = false;
                        System.out.println("What book are you looking for?");
                        System.out.println("Enter book's name: ");
                        String _bookName = scanner.next();
                        for (Carte b : carti)
                            if (b.getBookName().equals(_bookName)){
                                exista = true;
                                break;
                            }
                        if(!exista)
                            System.out.println("The book you enter does not exist! Try Again...");
                        else{

                            System.out.println("Choose Action:");
                            System.out.println("1) Change Book Name");
                            System.out.println("2) Change Book's Author");
                            id = scanner.nextBigDecimal().intValue();

                            switch (id) {
                                case 1:
                                    System.out.println("Enter New Name: ");
                                    String __bookName = scanner.next();
                                    System.out.println("Are you sure you want to change the name to " + __bookName + " ? (y/n)");
                                    if (scanner.next().equals("y") || scanner.next().equals("Y"))
                                        for (Carte b : carti)
                                            if (b.getBookName().equals(_bookName))
                                                b.setBookName(__bookName);
                                    break;
                                case 2:
                                    System.out.println("Enter New Author Name ( first name + last name ): ");
                                    String _first = scanner.next();
                                    String _last = scanner.next();
                                    String f = "";
                                    String l = "";
                                    System.out.println("Are you sure you want to change the author to " + _first + " " + _last + " ? (y/n)");
                                    if (scanner.next().equals("y") || scanner.next().equals("Y"))
                                        for (Carte b : carti)
                                            if (b.getBookName().equals(_bookName)){
                                                f = b.getAuthorFirstName();
                                                l = b.getAuthorLastName();
                                                b.setAuthorName(_first, _last);}
                                    for(Autor a: autori)
                                        if(a.getFirstName().equals(f) && a.getLastName().equals(l)){
                                            a.setFirstName(_first);
                                            a.setLastName(_last);
                                        }
                                    break;

                            }
                        }
                        break;
                    case 7:
                        exista = false;
                        System.out.println("What author are you looking for?");
                        System.out.println("Enter author's name: ");
                        String _authorFirstName = scanner.next();
                        String _authorLastName = scanner.next();
                        for (Autor a : autori)
                            if (a.getFirstName().equals(_authorFirstName) && a.getLastName().equals(_authorLastName)){
                                exista = true;
                                break;
                            }
                        if(!exista)
                            System.out.println("The author you enter does not exist! Try Again...");
                        else {
                            System.out.println("Enter a New Name for the author (first name + last name): ");
                            _authorFirstName = scanner.next();
                            _authorLastName = scanner.next();
                            System.out.println("Are you sure you want to change the name to -> " + _authorFirstName + " " + _authorLastName + " ? (y/n)");
                            if (scanner.next().equals("y") || scanner.next().equals("Y")){
                                for (Autor a : autori)
                                    if (a.getFirstName().equals(_authorFirstName) && a.getLastName().equals(_authorLastName)){
                                        a.setFirstName(_authorFirstName);
                                        a.setLastName(_authorLastName);
                                    }
                                for (Carte b : carti)
                                    if (b.getAuthorFirstName().equals(_authorFirstName) && b.getAuthorLastName().equals(_authorLastName)){
                                        b.setAuthorName(_authorFirstName, _authorLastName);
                                    }
                            }
                        }
                        break;
                    case 8:
                        loop = false;
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, try again");
            }

        }
    }

    }

