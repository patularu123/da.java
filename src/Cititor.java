public class Cititor extends Persoana{
    private String GenLiterar;
    public Cititor(String NumePersoana,String Prenume,String GenLiterar)
    {
        super(NumePersoana,Prenume);
        this.GenLiterar=GenLiterar;
    }

    public String getGenLiterar() {
        return GenLiterar;
    }

    public void setGenLiterar(String genLiterar) {
        GenLiterar = genLiterar;
    }
    public String CartiCumparate()
    {
        return super.getNumePersoana()+" isi permite sa cumpere "+Salariu/30+" carti din salariu";
    }
    @Override
    public String toString() {
        return super.toString()+" Genul literar,pe care il citeste este :"+GenLiterar;
    }
}
