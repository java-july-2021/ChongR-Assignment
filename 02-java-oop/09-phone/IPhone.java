public class IPhone extends Phone implements Ringable{
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring(){
        return "Opening~";
    }

    @Override
    public String unlock(){
        return "Crack";
    }

    @Override
    public void displayInfo(){
        System.out.println("iPhone" + this.versionNumber + " from " + this.carrier);
    }
}
