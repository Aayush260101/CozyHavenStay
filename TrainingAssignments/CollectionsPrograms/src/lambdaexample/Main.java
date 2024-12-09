package lambdaexample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=2,b=10;
		bank pnb=(x)->(10000*a*2/100);
		
		bank hdfc=(x)->(10000*b*2/100);
		System.out.println(pnb.calculateinterest(a));
		System.out.println(hdfc.calculateinterest(b));
	}

}
