package my;

public class Demo {

	public static void main(String[] args) {
		p1.A a=new p1.A();
		//System.out.println(a.x);/error
		System.out.println(a.g);
		a.m1();
		p1.B b=new p1.B();
		System.out.println(b.y);
		p2.A aa=new p2.A();
		System.out.println(aa.h);
		aa.m();
		p2.D d=new p2.D();
		System.out.println(d.z);
		d.m3();
		System.out.println(p1.A.y);
	}

}
