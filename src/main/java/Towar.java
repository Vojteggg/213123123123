public class Towar{
    private String nazwa;
    private int VAT;
    private Double brutto;

    private Double ilosc;


    Towar(String nazwa,int VAT,Double brutto){
        this.nazwa=nazwa;
        this.VAT = VAT;
        this.brutto=brutto;
    }

    private Towar towar;
    public Double sumacalkowita (Towar towar, Double ilosc){
        Double sumaCalkowita = towar.brutto*ilosc;
        return sumaCalkowita;
    }


    public String toString(Towar towar) {
        return nazwa +" "+VAT +" "+brutto +" "+ilosc;
    }

    public String getName(Towar towar){
        return towar.nazwa;
    }
    public Double getPrice(Towar towar){
        return towar.brutto;
    }
    public int getVAT(Towar towar){
        return towar.VAT;
    }
}

