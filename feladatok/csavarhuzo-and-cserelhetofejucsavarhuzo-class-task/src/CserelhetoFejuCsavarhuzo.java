public class CserelhetoFejuCsavarhuzo extends Csavarhuzo {

    private final int fejMeret;

    private boolean egyhornyuFej = true;

    private boolean phillipsFej = true;

    private boolean imbuszFej = true;

    public CserelhetoFejuCsavarhuzo(int meret, int fejMeret, Csavarfej csavarFej ){
        super(meret, csavarFej);
        this.fejMeret = fejMeret;





    }

    public void fejElhagy(String melyik){
        if(melyik.equals("egyhornyu")){
            egyhornyuFej = false;
        }

        else if(melyik.equals("phillips")){
            phillipsFej = false;
        }

        else if(melyik.equals("imbusz")){
            imbuszFej = false;
        }


    }

    public boolean fejCsere(String melyikre){
        if(super.getCsavarfej().equals(melyikre)){
            return false;
        }

        else if (!megEgyezik(melyikre)) {
            return false;

        }

        return true;

    }

    public boolean megEgyezik(String melyikre){
        if(melyikre.equals(egyhornyuFej)){
            return egyhornyuFej;
        }

        else if(melyikre.equals(phillipsFej)){
            return phillipsFej;
        }


        
        return imbuszFej;
    }



    public int getMeret(){
        return super.getMeret() - fejMeret;
    }

}
