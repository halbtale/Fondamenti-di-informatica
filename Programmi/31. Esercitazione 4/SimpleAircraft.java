public class SimpleAircraft {
    private String model;
    private String airport;
    private double km;
    private double maxKm;
    private double maxL;
    private double maxH;
    private String state;
    private SimpleAirRoute currentAirRoute;

    public SimpleAircraft(String m, String a, double maxL, double maxH, double maxKm) {
        this.model = m;
        this.airport = a;
        this.maxL = maxL;
        this.maxH = maxH;
        this.maxKm = maxKm;
        this.state = "LANDED";
        this.km = 0;
    }

    public double getMileage() {
        return km;
    }

    public String getState() {
        return this.state;
    }

    public boolean setSchedule(SimpleAirRoute ar) {
        if (state == "LANDED") {
            if (ar.getAirRouteLength() <= maxL && ar.getAirRouteMaxAltitude() <= maxH && km <= maxKm) {
                this.currentAirRoute = ar;
                this.state = "SCHEDULED";
                return true;
            }
        }
        return false;
    }

    public boolean takeOff() {
        if (state == "SCHEDULED") {
            state = "FLYING";
            return true;
        }
        return false;
    }

    public boolean land() {
        if (state == "FLYING") {
            km += currentAirRoute.getAirRouteLength();
            airport
        }
        return false;
    }

    public boolean goHangar() {
        return false;
    }

    public String toString() {
        return null;
    }
}
