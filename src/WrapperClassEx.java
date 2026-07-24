//wrapper classes used to convert primitive data types into objects
//Wrapper classes are immutable means once we create an object of wrapper class we cannot change its value
public class WrapperClassEx {
    public static void main(String[] args) {
        // Primitive data types
        int num = 10;
        double decimal = 20.5;
        char character = 'A';
        boolean bool = true;

        // Converting primitive data types to wrapper class objects (Boxing)
        Integer wrappedNum = Integer.valueOf(num);
        Double wrappedDecimal = Double.valueOf(decimal);
        Character wrappedCharacter = Character.valueOf(character);
        Boolean wrappedBool = Boolean.valueOf(bool);

        // Displaying the wrapper class objects
        System.out.println("Wrapped Integer: " + wrappedNum);
        System.out.println("Wrapped Double: " + wrappedDecimal);
        System.out.println("Wrapped Character: " + wrappedCharacter);
        System.out.println("Wrapped Boolean: " + wrappedBool);

        // Converting wrapper class objects back to primitive data types (Unboxing)
        int unboxedNum = wrappedNum.intValue();
        double unboxedDecimal = wrappedDecimal.doubleValue();
        char unboxedCharacter = wrappedCharacter.charValue();
        boolean unboxedBool = wrappedBool.booleanValue();

        // Displaying the unboxed primitive data types
        System.out.println("Unboxed Integer: " + unboxedNum);
        System.out.println("Unboxed Double: " + unboxedDecimal);
        System.out.println("Unboxed Character: " + unboxedCharacter);
        System.out.println("Unboxed Boolean: " + unboxedBool);

        // Demonstrating immutability of wrapper classes
        Integer anotherWrappedNum = wrappedNum; // another reference to the same object
        wrappedNum = Integer.valueOf(20); // creating a new object, original remains unchanged

        System.out.println("Original Wrapped Integer after change attempt: " + anotherWrappedNum); // still 10
        System.out.println("New Wrapped Integer: " + wrappedNum); // now 20
    }
}

//some questions on wrapper class are
//1. What are wrapper classes in Java?
//Answer: Wrapper classes in Java are used to convert primitive data types into objects. Each primitive type has a corresponding wrapper class (e.g., int -> Integer, double -> Double, char -> Character, boolean -> Boolean).
//2. Why are wrapper classes used in Java?
//Answer: Wrapper classes are used to provide a way to use primitive data types as objects. This is useful in scenarios where objects are required, such as in collections (e.g., ArrayList, HashMap) that can only store objects.




