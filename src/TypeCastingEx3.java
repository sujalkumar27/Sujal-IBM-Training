public class TypeCastingEx3{
    public static void main(String[] args) {
        //nterview questions on type casting are
        int a=257;
        byte b=(byte)(a);
        System.out.println(b);// 1  (257%256=1) because byte range is -128 to 127
        byte c=127;
        c++;
        System.out.println(c);// -128 (overflow occurs because byte max value is 127)
        byte d=-128;
        d--;
        System.out.println(d);// 127 (underflow occurs because byte min value is -128)

        int e=130;
        byte f=(byte)(e);
        System.out.println(f);// -126 (130-256=-126)

        int g=130;
        short h=(short)(g);
        System.out.println(h);// 130 (short range is -32768 to 32767)

        int i=65537;
        short j=(short)(i);
        System.out.println(j);// 1 (65537-65536=1) because short range is -32768 to 32767

        //most asked interview question is
        int k=5;
        float l=k;
        System.out.println(l);// 5.0 (int to float widening conversion)

        float m=5.5f;
        int n=(int)(m);
        System.out.println(n);// 5 (float to int narrowing conversion, decimal part is truncated)
        //type casting char to int
        char o='A';
        int p=o;
        System.out.println(p);// 65 (ASCII value of 'A')

        //most asked interview question is
        int q=65;
        char r=(char)(q);
        System.out.println(r);// A (character corresponding to ASCII value 65)


    }
}