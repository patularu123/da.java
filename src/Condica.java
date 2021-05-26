import java.util.Date;
public class Condica {
    private Date date;
    private String meserie;
    private String ora;
    private boolean motivated;

    public Condica() {
        this.date = date;
        this.meserie = meserie;
        this.motivated = false;
    }

    public void setMotivated() {
        this.motivated = true;
    }

    public Date getDate() {
        return date;
    }

    public boolean isMotivated() {
        return motivated;
    }

    public String getSubject() {
        return meserie;

    }
}
