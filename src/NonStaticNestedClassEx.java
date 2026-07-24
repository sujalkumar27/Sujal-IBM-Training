class A{ //outer or upper class
	int x=10;
	private int y=20;
	static int z=30;
	void m1() {
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		//System.out.println(h);//error
		System.out.println(B.g);
		B b=new B();
		System.out.println(b.h);
		b.m();
	}
	class B{ //non-static nested class (inner class)
		int h=45;
		static int g=55;
		void m() {
			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
			System.out.println(h);
		}
	}
}
public class NonStaticNestedClassEx {
	public static void main(String[] args) {
		//System.out.println(B.g);//error
		System.out.println(A.B.g);
		System.out.println(A.z);
		//B b=new B();//error
		A a=new A();
		A.B b=a.new B();
		System.out.println(b.h);
		b.m();
		//System.out.println(a.h);//error
		//System.out.println(b.x);//error
		System.out.println(a.x);
		a.m1();
	}
}