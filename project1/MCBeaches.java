public class MCBeaches implements Comparable<MCBeaches> {
    // Fields
    private String beachName;
    private String townName;
    private int zip;
    private String phoneNumber;
    private double dailyFee;
    private boolean hasLifeguard;
    private String parkwaySouthExit;
    private String parkwayNorthExit;
    private double latitude;
    private double longitude;
    private String website;


    // Constructors
    public MCBeaches() {
        this("Allenhurst","Allenhurst",07711,"7325312757l",10,false,"102","100A",40.23437,73.99571,"http://www.allenhurstnj.org/");
    }

    public MCBeaches(String beachName, String townName, int zip, String phoneNumber, double dailyFee, boolean hasLifeguard, String parkwaySouthExit, String parkwayNorthExit, double latitude, double longitude, String website) {
        this.beachName = beachName;
        this.townName = townName;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.dailyFee = dailyFee;
        this.hasLifeguard = hasLifeguard;
        this.parkwaySouthExit = parkwaySouthExit;
        this.parkwayNorthExit = parkwayNorthExit;
        this.latitude = latitude;
        this.longitude = longitude;
        this.website = website;
    }


    // Getters and Setters
    public String getBeachName() {
        return beachName;
    }

    public void setBeachName(String beachName) {
        this.beachName = beachName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(double dailyFee) {
        this.dailyFee = dailyFee;
    }

    public boolean isHasLifeguard() {
        return hasLifeguard;
    }

    public void setHasLifeguard(boolean hasLifeguard) {
        this.hasLifeguard = hasLifeguard;
    }

    public String getParkwaySouthExit() {
        return parkwaySouthExit;
    }

    public void setParkwaySouthExit(String parkwaySouthExit) {
        this.parkwaySouthExit = parkwaySouthExit;
    }

    public String getParkwayNorthExit() {
        return parkwayNorthExit;
    }

    public void setParkwayNorthExit(String parkwayNorthExit) {
        this.parkwayNorthExit = parkwayNorthExit;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void displayContactInformation() {
        System.out.format("%s beach in %s, NJ. Phone: %s. Website: %s\n", beachName, townName, phoneNumber, website);
    }

    // Tostring
    @Override
    public String toString() {
        return String.format("%s in %s, NJ. Zip: %d. Phone: %s. Daily Fee: $%.2f. Lifeguard: %b. Parkway South Exit: %s. Parkway North Exit: %s. Latitude: %.5f. Longitude: %.5f. Website: %s", beachName, townName, zip, phoneNumber, dailyFee, hasLifeguard, parkwaySouthExit, parkwayNorthExit, latitude, longitude, website);
    }

    @Override
    public int compareTo(MCBeaches otherBeach) {
        if (latitude < otherBeach.latitude) {
            return 1;
        } else if (latitude > otherBeach.latitude) {
            return -1;
        } else {
            return 0;
        }
    }
}
