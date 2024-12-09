package HomeAutomationSystem;

public class FacadeClass {
	
	    private Light light;
	    private AC ac;
	    private Security security;
	    public FacadeClass() {
			
			this.light = new Light();
			this.ac = new AC();
			this.security = new Security();
		}

		public void arriveHome() {
	        System.out.println("Arriving home...");
	        light.turnOn();
	        ac.turnOn();
	        security.deactivate();
	    }

	    public void leaveHome() {
	        System.out.println("Leaving home...");
	        light.turnOff();
	        ac.turnOff();
	        security.activate();
	    }
	}


