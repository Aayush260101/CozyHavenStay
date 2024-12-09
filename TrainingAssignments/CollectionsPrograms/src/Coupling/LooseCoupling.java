package Coupling;

public class LooseCoupling {
	public static void main(String args[]) {
		EngineType petrolengine=new Petroleng();
		Vehicle1 xyz = new Vehicle1(petrolengine);
		xyz.engine();
		
		EngineType dieselengine=new DieselEng();
		Vehicle1 abc = new Vehicle1(dieselengine);
		abc.engine();
	}
}
