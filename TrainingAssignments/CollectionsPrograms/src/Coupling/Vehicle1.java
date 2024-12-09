package Coupling;

public class Vehicle1 {
	EngineType engty;
	public Vehicle1(EngineType engty) {
        this.engty = engty; 
    }

    public void engine() {
        engty.engtype();
    }
}
