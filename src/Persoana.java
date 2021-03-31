public class Persoana {
    private final String Firstname;
    private final String Secondname;
    protected int Salariu;
    public Persoana(String _Firstname,String _Secondname)
    {
        this.Firstname=_Firstname;
        this.Secondname=_Secondname;
    }
    public String getNumePersoana() {
        return Firstname+" "+Secondname;
    }

    public int getSalariu() {
        return Salariu;
    }

    public void setSalariu(int salariu) {
        Salariu = salariu;
    }

    @Override
    public String toString() {
        return "Numele Persoanei este " + Firstname+ " "+Secondname + " cu salariul de "+Salariu ;
    }
    double CalculeazaSalariu()
    {
        return Salariu;
    }
}
