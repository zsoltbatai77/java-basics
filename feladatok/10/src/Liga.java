import java.io.*;
import java.util.*;

public class Liga {
    private List<Csapat> csapatok;
    private List<Meccs> meccsek;

    public Liga(String directoryName) {
        csapatok = new ArrayList<>();
        meccsek = new ArrayList<>();
        File dir = new File(directoryName);
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith(".csv")) {
                csapatok.add(new Csapat(file.getName().replace(".csv", "")));
            }
        }
    }

    public Liga(List<Csapat> csapatok) {
        this.csapatok = csapatok;
        this.meccsek = new ArrayList<>();
    }

    public List<Meccs> getMeccsek() {
        return meccsek;
    }

    public List<Csapat> getCsapatok() {
        return csapatok;
    }

    public List<Csapat> hianyosCsapatok() {
        List<Csapat> hianyosCsapatok = new ArrayList<>();
        for (Csapat csapat : csapatok) {
            if (!csapat.hianyzoPoziciok().isEmpty()) {
                hianyosCsapatok.add(csapat);
            }
        }
        return hianyosCsapatok;
    }

    public int csapatokKizarasa() {
        List<Csapat> hianyosCsapatok = hianyosCsapatok();
        csapatok.removeAll(hianyosCsapatok);
        return hianyosCsapatok.size();
    }

    public Csapat jatek() {
        while (csapatok.size() > 1) {
            for (int i = 0; i < csapatok.size() - 1; i += 2) {
                Meccs meccs = new Meccs(csapatok.get(i), csapatok.get(i + 1));
                meccsek.add(meccs);
                if (csapatok.get(i) == meccs.gyoztes()) {
                    csapatok.remove(csapatok.get(i + 1));
                } else if (csapatok.get(i + 1) == meccs.gyoztes()) {
                    csapatok.remove(csapatok.get(i));
                }
                csapatok.add(meccs.gyoztes());
            }
        }
        return csapatok.get(0);
    }

    public void eredmenyTabla() {
        try (PrintWriter writer = new PrintWriter(new File("eredmenyTabla.csv"))) {
            StringBuilder sb = new StringBuilder();
            sb.append("ElsoCsapat");
            sb.append(';');
            sb.append("MasodikCsapat");
            sb.append(';');
            sb.append("GyoztesCsapat");
            sb.append('\n');

            for (Meccs meccs : meccsek) {
                sb.append(meccs.getElsoCsapat().getNeve());
                sb.append(';');
                sb.append(meccs.getMasodikCsapat().getNeve());
                sb.append(';');
                sb.append(meccs.gyoztes().getNeve());
                sb.append('\n');
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
