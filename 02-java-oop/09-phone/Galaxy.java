public class Galaxy extends Phone implements Ringable{
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring(){
        return "Ring Ring Ring~~~";
    }

    @Override
    public String unlock(){
        return "Click";
    }

    @Override
    public void displayInfo(){
        System.out.println("Galaxy " + this.versionNumber + " from " + this.carrier);
    }
}
