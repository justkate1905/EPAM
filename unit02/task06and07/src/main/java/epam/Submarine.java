package epam;

@ClassSummary(summary = "Class for Submarine with inner class")
public class Submarine
{
    private SubmarineMotor motor;

    class SubmarineMotor{

        public void startSailing(){
            System.out.println("Motor is ready!");
        }
    }
    public Submarine(){
        motor = new SubmarineMotor();
        motor.startSailing();
    }
}
