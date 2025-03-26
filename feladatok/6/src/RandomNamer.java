import java.util.Random;

public class RandomNamer implements Namer{

    private int length;
    private java.util.Random rnd;

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    public RandomNamer(java.util.Random rnd, int lenght) {
        this.length = lenght;
        this.rnd = rnd;
    }


    @Override
    public void rename(FileSystemEntry entry) {
        StringBuilder uj = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int random = rnd.nextInt(ALPHABET.length());
            char randomChar = ALPHABET.charAt(random);
            uj.append(randomChar);
        }
        entry.setName(uj.toString());
    }
}
