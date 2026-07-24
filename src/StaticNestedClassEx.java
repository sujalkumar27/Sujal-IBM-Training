class AA{ //outer or upper class
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
	 static class B{ //static nested class 
		int h=45;
		static int g=55;
		void m() {
//			System.out.println(x);//error
//			System.out.println(y);//error
			System.out.println(z);
			System.out.println(h);
		}
	}
}
public class StaticNestedClassEx {
	public static void main(String[] args) {
		System.out.println(AA.z);
		System.out.println(AA.B.g);
		//B b=new B();//error
		AA.B b=new AA.B();
		System.out.println(b.h);
		//System.out.println(a.h);//error
		b.m();
		//System.out.println(b.x);//error
		AA a=new AA();
		System.out.println(a.x);
		a.m1();
	}
}