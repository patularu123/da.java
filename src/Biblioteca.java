
import java.util.*;

public class Biblioteca {
    private int NrCarti;
    private int NrScaune;
    private String name;
    private Integer id;
    public Set<Autor> autors;
    private Condica condica = new Condica();
    public int getNrCarti() {
        return NrCarti;
    }
    public void setNrCarti(int nrCarti) {
        NrCarti = nrCarti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Autor> getAutors() {
        return autors;
    }

    public void setAutors(Set<Autor> autors) {
        this.autors = autors;
    }

    public Condica getCondica() {
        return condica;
    }

    public void setCondica(Condica condica) {
        this.condica = condica;
    }
}
