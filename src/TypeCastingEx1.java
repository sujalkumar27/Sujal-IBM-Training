
class TypeCastingEx1{ 
    public static void main(String []s){
        char a='h';
        int b=a;//implicit or upcasting
        System.out.println(a);
        System.out.println(b);

        int x=104;
        //char y=x;//error
        char y=(char)x;//explicit or downcasting
        System.out.println(x);
        System.out.println(y);
    }
} 