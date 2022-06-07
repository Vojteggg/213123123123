public class sellingDate {
    int day;
    int month;
    int year;
    sellingDate(int day, int month, int year){
        this.day=day;
        this.year=year;
        this.month=month;
    }

    @Override
    public String toString() {
        return day+"."+month+"."+year+"r.";
    }
}
