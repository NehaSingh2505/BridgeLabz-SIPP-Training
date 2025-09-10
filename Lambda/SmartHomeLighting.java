import java.util.Scanner;

@FunctionalInterface
interface LightAction {
    void execute();
}

public class SmartHomeLighting {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        LightAction motionTrigger = () -> System.out.println("Lights ON: Motion detected! Warm white lights activated.");
        LightAction timeTrigger = () -> System.out.println("Evening mode: Dim lights to 50% brightness.");
        LightAction voiceTrigger = () -> System.out.println("Voice command: Lights set to party mode with color cycling.");

        System.out.println("--- Smart Home Lighting Automation ---");
        System.out.println("Choose a trigger to activate lights : ");
        System.out.println("1. Motion");
        System.out.println("2. Time of Day");
        System.out.println("3. Voice Command");
        System.out.print("Enter choice : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                motionTrigger.execute();
                break;
            case 2:
                timeTrigger.execute();
                break;
            case 3:
                voiceTrigger.execute();
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }
    }
}
