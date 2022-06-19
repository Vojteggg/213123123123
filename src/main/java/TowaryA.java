public class TowaryA {
    private Towar towar ;
    private Double ilosc;
    public Double sumacalkowita (Towar towar, Double ilosc){
        Double sumaCalkowita = towar.brutto*ilosc;
        return sumaCalkowita;
    }
}
