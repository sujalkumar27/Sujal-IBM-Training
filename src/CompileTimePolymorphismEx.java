class Addition{
	void add(int a,int b) {
		int r=a+b;
		System.out.println("Addition: "+r);
	}
	String add(String a,String b) {
		String r=a+b;
		return r;
	}
	void add(double a,double b) {
		double r=a+b;
		System.out.println("Sum: "+r);
	}
}
public class CompileTimePolymorphismEx {
	public static void main(String[] args) {
		Addition a=new Addition();
		a.add(45, 2);
		a.add(2.3, 6.5);
		String r=a.add("Hello", "Hi");
		System.out.println("Concatination: "+r);
	}

}
