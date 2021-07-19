public abstract class Phone {
    protected String versionNumber;
    protected int batteryPercentage;
    protected String carrier;
    protected String ringTone;
    protected int count;
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
        count++;
    }

    public abstract void displayInfo();

    //------------------  Getters  ----------------//
    public String getVersionNumber(){
        return versionNumber;
    }

    public int getBatteryPercentage(){
        return batteryPercentage;
    }

    public String getCarrier(){
        retuen carrier;
    }

    public String getRingTone(){
        return ringTone;
    }

    //------------------  Setters  ----------------//
    public void setVersionNumber(String versionNumber){
        this.versionNumber = versionNumber;
    }

    public void setBatteryPercentage(int batteryPercentage){
        this.batteryPercentage = batteryPercentage;
    }

    public void setCarrier(String carrier){
        this.carrier = carrier;
    }

    public void setRingTone(String ringTone){
        this.ringTone = ringTone;
    }
}
