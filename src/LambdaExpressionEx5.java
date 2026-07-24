@FunctionalInterface
interface Abc{
	void xyz();
}
public class LambdaExpressionEx5 {

	public static void main(String[] args) {
		Abc a=()-> 
		//System.out.println("Hii");
		System.out.println("Hello"); 
		a.xyz();
		a.xyz();
	}

}