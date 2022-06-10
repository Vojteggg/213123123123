public class sellingDate {
    Integer day;
    Integer month;
    int year;
    sellingDate(Integer day, Integer month, int year){
        this.day=day;
        this.year=year;
        this.month=month;
    }
    @Override
    public String toString() {
        return day+"."+month+"."+year+"r.";
    }
}
