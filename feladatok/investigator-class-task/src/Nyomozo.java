public class Nyomozo {

    public String nev;
    private String[] gyanusitottak;
    private int[] nyomok;

    public Nyomozo(String[] gyanusitottak, int[] nyomok) {

        this.gyanusitottak = gyanusitottak;
        this.nyomok = nyomok;
        this.nev = "Columbo";

    }

    public Nyomozo(String nev, String[] gyanusitottak, int[] nyomok) {

        this.nev = nev;
        this.gyanusitottak = gyanusitottak;
        this.nyomok = nyomok;
    }

    public String[] getGyanusitottak() {
        return gyanusitottak;
    }

    public int[] getNyomok() {
        return nyomok;
    }

    public void setGyanusitottak(String[] gyanusitottak) {
        this.gyanusitottak = gyanusitottak;
    }

    public void setNyomok(int[] nyomok) {
        this.nyomok = nyomok;
    }

    public boolean nyomotFelhasznal(int index) {
        if (index < 0 || index >= nyomok.length) {
            return false;
        }

        int[] ujNyomok = new int[nyomok.length - 1];
        int ujIndex = 0;

        for (int i = 0; i < nyomok.length; i++) {
            if (i == index) {
                continue;
            }

            ujNyomok[ujIndex] = nyomok[i];
            ujIndex++;
        }
        this.nyomok = ujNyomok;
        return true;
    }

    public boolean felmentoBizonyitek(String kit) {
        boolean benneVan = false;
        boolean torolt = false;
        for (String gyanusitott : gyanusitottak) {
            if (gyanusitott.equals(kit)) {
                benneVan = true;
            }
        }
        if (benneVan == false) {
            return false;

        }

        String[] ujGyanusitottak = new String[gyanusitottak.length - 1];
        int ujIndex = gyanusitottak.length - 2;


        for (int i = gyanusitottak.length - 1; i >= 0; i--) {
            if (gyanusitottak[i].equals(kit) && torolt == false) {
                torolt = true;
                continue;

            }

            ujGyanusitottak[ujIndex] = gyanusitottak[i];
            ujIndex--;
        }
        this.gyanusitottak = ujGyanusitottak;
        return true;
    }

    public void inditek() {
        if (gyanusitottak.length > 0) {
            String utolso = "";
            for (int i = 0; i < gyanusitottak.length; i++) {
                if (i == 0) {
                    utolso = gyanusitottak[i];

                }
                if (i > 0) {
                    gyanusitottak[i - 1] = gyanusitottak[i];
                }

            }
            gyanusitottak[gyanusitottak.length - 1] = utolso;
        }
    }

    public void nyomokatRendez() {
        int elso = 0;
        int utolso = nyomok.length - 1;

        while (elso < utolso) {

            int temp = nyomok[elso];
            nyomok[elso] = nyomok[utolso];
            nyomok[utolso] = temp;

            elso++;
            utolso--;
        }

    }

    public void alibikEliminalasa() {
        if (nyomok.length >= 3) {
            int ujMeret = nyomok.length - nyomok.length / 3;
            int[] ujNyomok = new int[ujMeret];
            int ujIndex = 0;

            for (int i = 0; i < nyomok.length; i++) {
                if ((i + 1) % 3 != 0 || i == 1) {
                    ujNyomok[ujIndex++] = nyomok[i];
                }
            }
            this.nyomok = ujNyomok;
        }
    }


    public boolean bajbanVan() {
        boolean torolt = false;
        boolean vanBenne = false;
        for (int i = 0; i < nyomok.length; i++) {
            if (nyomok[i] == 1 && torolt == false) {
                torolt = true;
                vanBenne = true;
                nyomotFelhasznal(i);
                felmentoBizonyitek(this.nev);
            }

        }
        if (vanBenne == false) {
            return false;
        }
        return true;
    }


}
