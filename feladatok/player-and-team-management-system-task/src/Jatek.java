import java.util.Arrays;
import java.util.Objects;

public class Jatek {

    private String nev;
    private String[] genre;


    public Jatek(String nev) {
        this.nev = nev;
        this.genre = new String[3];
    }

    public Jatek(String nev, String... genres) {
        this.nev = nev;
        this.genre = new String[3];
        for (int i = 0; i < genres.length && i < 3; i++) {
            this.genre[i] = genres[i];
        }
    }


    public void addGenre(String name) {
        for (int i = 0; i < this.genre.length; i++) {
            if (this.genre[i] == null) {
                this.genre[i] = name;
                return;
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public String getNev() {
        return nev;
    }

    public String[] getGenre() {
        return genre;
    }


}
