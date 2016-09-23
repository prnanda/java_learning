
public class Droid {
    int batteryLevel;

    public Droid(){
        batteryLevel = 100;
    }

    public void activate(){
        System.out.println("Activated. How can I help you?");
        batteryLevel-=5;
        System.out.println("Battery level is: " + batteryLevel + " percent.");
    }

    public void chargeBattery(int hours){
        System.out.println("Droid charging...");
        batteryLevel+=hours;
        if (batteryLevel > 100){
            batteryLevel = 100;
        }
        else {
            System.out.println(batteryLevel);
        }

    }

    public int checkBatteryLevel(){
        System.out.println(batteryLevel);
        return batteryLevel;
    }





}
