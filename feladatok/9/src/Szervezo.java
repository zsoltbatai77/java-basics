import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Szervezo {

    private List<Jatekos> jatekosok;
    private List<Csapat> csapatok;

    public Szervezo() {
        jatekosok = new ArrayList<>();
        csapatok = new ArrayList<>();
    }

    public void addJatekos(Jatekos jatekos) {
        jatekosok.add(jatekos);
    }

    public void addCsapat(Csapat csapat) {
        csapatok.add(csapat);
    }

    public void gyakoroltat(Map<Jatek, Integer> mibolMennyit) throws SecurityException {
        for (Jatekos jatekos : jatekosok) {
            try {
                for (Map.Entry<Jatek, Integer> entry : mibolMennyit.entrySet()) {
                    jatekos.jatszik(entry.getKey(), entry.getValue());
                }
            } catch (NemSzeretiException e) {
                throw new SecurityException("Az egyik jatekos tul valogatos.");
            }
        }
    }


    public void beoszt() throws Exception {
        for (Jatekos jatekos : jatekosok) {
            boolean sikeres = false;
            int kompatibilisCsapatokSzama = 0;

            for (Csapat csapat : csapatok) {
                if (csapat.getCelJatek().equals(jatekos.getKedvenc())) {
                    kompatibilisCsapatokSzama++;
                    try {
                        csapat.jatekostHozzaad(jatekos);
                        sikeres = true;
                        break;
                    } catch (IndexOutOfBoundsException e) {

                    }
                }
            }

            if (!sikeres) {
                if (kompatibilisCsapatokSzama == 0) {
                    throw new Exception("Az egyik jatekosnak nem sikerult megfelelo csapatot talalni.");
                } else {
                    throw new Exception("Az egyik jatekosnak " + kompatibilisCsapatokSzama + " csapatot talalt, de mind tele van.");
                }
            }
        }
    }


}
