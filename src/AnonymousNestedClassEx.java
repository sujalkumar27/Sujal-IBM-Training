class Xyz{
	void m1() {
		System.out.println("Hello XYZ");
	}
	void m2() {
		System.out.println("Hi XYZ");
	}
}
interface Abc{
	void m1();
	void m2();
}
public class AnonymousNestedClassEx {
	public static void main(String[] args) {
		//without Anonymous Class  
//		class B extends Xyz{
//			void m1() {
//				System.out.println("Hello");
//			}
//		}
//		Xy B()z x=new;
//		x.m1();
//		x.m2();
		
		//with Anonymous Class
		Xyz x=new Xyz(){
			void m1() {
				System.out.println("Hello");
			}
		};
		x.m1();
		x.m2();
		
		Abc a=new Abc() {
			@Override
			public void m1() {
				System.out.println("Hello Incapp");
			}
			@Override
			public void m2() {
				System.out.println("Hi Incapp");
			}
		};
		a.m1();
		a.m2();
		
		Abc a2=new Abc() {
			@Override
			public void m1() {
				System.out.println("fghghfgp");
			}
			@Override
			public void m2() {
				System.out.println("fghfgh");
			}
		};
		a2.m1();
		a2.m2();
	}
}