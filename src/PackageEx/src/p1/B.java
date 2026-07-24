package p1;

public class B {
	public int y=20;
	public void m2() {
		System.out.println("Hello B");
		//p1.A a=new p1.A();//package name is optional
		A a=new A();
		System.out.println(a.x);
		System.out.println(a.g);
		a.m1();
	}
}
