package newcastbots;

public class Model {

    private static Object JPY = 0.0;
    private static Object EUR = 0.0;
    private static Double USD = 0.0;
    private static Double GBP = 0.0;
    //private String name;
    private Double base;
    private double rates;


   /* public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = USD;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
        this.GBP = GBP;
        this.EUR = EUR;
        this.JPY = JPY;
    }
}

