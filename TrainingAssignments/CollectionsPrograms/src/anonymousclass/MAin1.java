package anonymousclass;

import java.util.Scanner;

public class MAin1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter roll");
		int roll=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name");
		String name=sc.nextLine();
		I1 obj = new I1()
		{
			public int getRoll()
			{
				return roll;
			}
			public String getName()
			{
				return name;
			}
		};
		System.out.println(obj.getRoll());
		System.out.println(obj.getName());

	}

}
