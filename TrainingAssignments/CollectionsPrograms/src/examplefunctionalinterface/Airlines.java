package examplefunctionalinterface;
@FunctionalInterface
public interface Airlines {
     void welcome();
     default void food()
     {
    	 System.out.println("We provide food also");
     }
     default void drinks()
     {
    	 System.out.println("We provide drinks also");
     }
     
}
