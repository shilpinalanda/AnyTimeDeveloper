
public class Test {

	public static void main(String[] args) {
		System.out.println("Hello Main Method");
        main(10);
        main(10,20);
	}
	 static void main(int a) {
		System.out.println("Value of a: "+a);

	}
	static void main(int a,int b) {
		System.out.println("Value of a: "+a);
		System.out.println("Value of b: "+b);

	}

}
