
class AAAA{
	int x=10;
	{
		System.out.println("Hello A");
	}
	AAAA() {
		System.out.println("Hi A");
	}
}
class BBBB extends AAAA {
	int y=20;
	{
		System.out.println("Hello B");
	}
	BBBB() {
		System.out.println("Hi B");
	}
}
public class InheritanceWithInitializeBlockEx {
	public static void main(String[] args) {
		BBBB b1=new BBBB();
	}
}