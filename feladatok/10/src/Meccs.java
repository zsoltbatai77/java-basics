public class Meccs{
    private final Csapat elsoCsapat;
    private final Csapat masodikCsapat;

    public Meccs(Csapat elsoCsapat, Csapat masodikCsapat) {
        this.elsoCsapat = elsoCsapat;
        this.masodikCsapat = masodikCsapat;
    }

    public Csapat getElsoCsapat() {
        return elsoCsapat;
    }

    public Csapat getMasodikCsapat() {
        return masodikCsapat;
    }

    public Csapat gyoztes(){
        if (getElsoCsapat().compareTo(getMasodikCsapat()) > 0){
            return elsoCsapat;
        } else {
            return masodikCsapat;
        }
    }
}
