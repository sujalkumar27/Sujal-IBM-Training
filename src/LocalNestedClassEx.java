class AAA{ //outer/upper class
	int x=10;
	private int y=20;
	static int z=30;
	void m1() {
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		class B{ //local nested class 
			int h=45;
			static int g=55;
			void m() {
				System.out.println(x);
				System.out.println(y);
				System.out.println(z);
				System.out.println(h);
			}
		}
		//System.out.println(h);//error
		System.out.println(B.g);
		B b=new B();
		System.out.println(b.h);
		//System.out.println(b.x);//error
		b.m();
	}
	void m2() {
		//B b=new B();//error
	}
}
public class LocalNestedClassEx {
	public static void main(String[] args) {
		System.out.println(AAA.z);
		//B b=new B();//error
		//AAA.B b=new AAA.B();//error
		AAA a=new AAA();
		//AAA.B b=a.new B();//error
		System.out.println(a.x);
		a.m1();
	}
}