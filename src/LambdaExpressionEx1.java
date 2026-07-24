import java.util.*;
//	@FunctionalInterface
//interface A{
//	void add();
//}
//public class LambdaExpressionEx1 {
//	public static void main(String[] args) {
//		
////		A a=new A() {
////			public void add() {
////				int x=10,y=20,r=x+y;
////				System.out.println("Sum: "+r);
////			}
////		};
//		
//		//Lambda Expression
//		A a=()->{
//			int x=10,y=20,r=x+y;
//			System.out.println("Addition: "+r);
//		};
//		a.add();
//	}
//
//}
import java.io.*;
import java.util.*;
@FunctionalInterface
interface A{
    boolean isOdd(int num);
}
interface B{
	boolean  isPrime(int num);
}
interface C{
	boolean isPalindrome(int num);
}

public class LambdaExpressionEx1 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
        
        
        A a=(int n)->{
            if(n%2==0) return false;
            return true;
        };
        B b=(int n)->{
            boolean flag=true;
            for(int i=2;i<n/2;i++){
                if(n%i==0){
                   flag=false;
                   break;
                }
            }
            return flag;
        };
        C c=(int n)->{
            String s=Integer.toString(n);
            boolean flag=true;
            for(int i=0;i<s.length()/2;i++){
                if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                     flag=false;
                    break;
                }
                
            }
            return flag;
        }; 
        for(int i=0;i<num;i++){
            int d=sc.nextInt();
            int e=sc.nextInt();
            if(d==1) {
            	boolean flag=a.isOdd(e);
            	if(flag) {
            		System.out.println("ODD");
            	}
            	else {
            		System.out.println("EVEN");
            	}
            }
            else if(d==2) {
            	boolean flag=b.isPrime(e);
            	if(flag) {
            		System.out.println("Prime");
            	}
            	else {
            		System.out.println("Not prime");
            	}
            }
            else {
            	boolean flag=c.isPalindrome(e);
            	if(flag) {
            		System.out.println("Palindrome");
            	}
            	else {
            		System.out.println("not palindrome");
            	}
            }
        }
        
    }
}