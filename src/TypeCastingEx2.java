class TypeCastingEx2{ 
    public static void main(String []s){
        System.out.println(12);//Integer Literal is by-default int
        System.out.println(6.3);//FloatingPoint Literal is by-default double

        //float a=6.3;//error
        //float a=(float)6.3;//allowed
        //float a=6.3f;//allowed
        float a=6.3F;//allowed
        System.out.println(a);

        //double b=6.3;//allowed
        //double b=6.3d;//allowed
        double b=6.3D;//allowed
        System.out.println(b);

        //long x=3000000000;//error
        //long x=3000000000l;//allowed
        long x=3000000000L;
        System.out.println(x);
    }
}