

class A {
	int x=10;
	static int h=50;
	private int z=30;
	void showZ() {
		System.out.println(z);
	}
	void m1() {
		System.out.println("Hello A");
	}
}
class B extends A{
	int y=20;
	void m2() {
		System.out.println("Hello B");
		System.out.println(x);
		System.out.println(h);
		//System.out.println(z);//error
		showZ();
	}
}
public class InheritanceEx1 {
	public static void main(String[] args) {
		A a=new A();
		a.x=15;
		a.h=15;
		System.out.println(a.x);//15
		System.out.println(a.h);//15
		//System.out.println(a.z);//error
		a.showZ();
		a.m1();
		B b=new B();
		System.out.println(b.x);//10
		System.out.println(b.h);//15
		//System.out.println(b.z);//error
		b.showZ();
		System.out.println(b.y);
		b.m1();
		b.m2();
	}
}