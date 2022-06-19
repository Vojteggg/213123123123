public class Towar extends TowaryA{
    private String nazwa;
    private int VAT;
    protected Double brutto;
    private String jm;


    Towar(String nazwa,int VAT,Double brutto, String jm){
        this.nazwa=nazwa;
        this.VAT = VAT;
        this.brutto=brutto;
        this.jm=jm;
    }
    
}
