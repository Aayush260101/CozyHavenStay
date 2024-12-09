package HomeAutomationSystem;

public class WithoutFacadeClass {	
	    public static void main(String[] args) {
	        Light light = new Light();
	        AC ac = new AC();
	        Security security = new Security();

	        System.out.println("Arriving home...");
	        light.turnOn();
	        ac.turnOn();
	        security.deactivate();
	        
	        System.out.println("Leaving home...");
	        light.turnOff();
	        ac.turnOff();
	        security.activate();
	    }
	}


