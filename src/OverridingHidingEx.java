class A{
	int x=10;
	static int h=15;
	void m1() {
		System.out.println("Hello A");
	}
	static void m2(){
		System.out.println("Hi A");
	}
}
class B extends A{
	String x="jkh";  //Data Hiding
	//int x=90; 	 //Data Hiding
	static int h=35; //Data Hiding
	int y=20;
	void m1() { //Method overriding
		System.out.println("Hello B");
	}
	static void m2(){ //Method Hiding
		System.out.println("Hi B");
	}
}
public class OverridingHidingEx {
	public static void main(String[] args) {
		A.m2();
		B.m2();
		B b=new B();
		System.out.println(b.x);
		System.out.println(b.y);
		b.m1();
		B.m2();
	}

}