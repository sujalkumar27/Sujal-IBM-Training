@FunctionalInterface
interface AAA{
	int add(int a,int b);
}
public class LambdaExpressionEx3 {

	public static void main(String[] args) {
		//Lambda Expression
		AAA a=(x,y)->{
			int r=x+y;
			return r;
		};
		int s=a.add(8,9);
		System.out.println("Sum: "+s);
	}

}