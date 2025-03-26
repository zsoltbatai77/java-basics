public class VideoMagno{
    public static void lejatszas(BesorolassalRendelkezo lejatszando, int maxEletkor){
        if (lejatszando.getKorhatarBesorolas() > maxEletkor){
            System.out.println("Sajnalom, de a korhatar miatt ezt nem jatszhatom le.\n");
        } else if (lejatszando instanceof Sorozat) {
            System.out.println("Lejatszasra kerult a(z) " + ((Sorozat) lejatszando).getNev() + " cimu sorozat.\n");
        } else if (lejatszando instanceof Zeneszam) {
            System.out.println("Meghallgattuk a kovetkezo szamot: " + ((Zeneszam) lejatszando).getEloado() + " - " + ((Zeneszam) lejatszando).getSzamCim() + "\n");
        }
    }
}
