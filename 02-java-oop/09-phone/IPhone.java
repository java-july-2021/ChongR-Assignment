public class IPhone extends Phone implements Ringable{
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring(){
        return this.getRingTone();
    }

    @Override
    public String unlock(){
        return "Crack";
    }

    @Override
    public void displayInfo(){
        System.out.println("iPhone" + getVersionNumber() + " from " + getCarrier() 
        + ", the current battery level is " + getBatteryPercentage() + "% and the ring tone is " + getRingTone());
    }
}
