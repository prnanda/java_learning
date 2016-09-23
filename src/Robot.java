public class Robot {

    private int id;

    public Robot(int id){
        this.id = id;
    }

    public void start(){
        System.out.println("Starting robot " + id );
        Brain brain = new Brain();
        brain.think();
    }

    //Inner class. Has access to the instance variables
    private class Brain{
        public void think(){
            System.out.println("Robot " + id + " thinking.");
        }
    }

    //Since this is static, it can't access the instance variables
    static class Battery {
        public void charge(){
            System.out.println("Battery charging....");
        }
    }
}
