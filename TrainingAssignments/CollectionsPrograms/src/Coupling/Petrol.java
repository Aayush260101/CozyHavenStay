package Coupling;

public class Petrol {
	public void petrolengine() {
		System.out.println("Petrol Engine");
	}
}

class vehicle{
	Petrol petrol;
	
	vehicle(){
		this.petrol= new Petrol();
	}
	public void refuel() {
		petrol.petrolengine();
	}
}

