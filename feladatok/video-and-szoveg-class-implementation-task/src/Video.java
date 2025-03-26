
import java.util.*;

public class Video implements interfaceeeee{
    int hossz;
    String url;
    private Set<String> cimkek = new HashSet<>();

    public Set<String> getCimkek() {
        return cimkek;
    }

    public Video(int hossz, String url) {
        this.hossz = hossz;
        this.url = url;
        if (this.url == null) {
            this.hossz = 0;
        }
    }

    public void valogat(int minHossz) {
        if (url.contains("false")) {
            throw new hibaException("Ez a hir csak kitalacio!");
        }
        cimkek.removeIf(elem -> elem.length() < minHossz);
    }
}
