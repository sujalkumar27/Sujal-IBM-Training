class AAA {
	int x=10;
	void m1() {
		System.out.println("Hello A");
	}
	AAA() { 
		System.out.println("Hi A");
	}
}
class BBB extends AAA {
	int y=20;
	void m2() {
		System.out.println("Hello B");
	}
	BBB() { //super();//optional[because java compiler will add super();]
		System.out.println("Hi B");
	}
}
public class InheritanceWithConstructorEx1 {
	public static void main(String[] args) {
		BBB b1=new BBB();
		BBB b2=new BBB();
	}
}