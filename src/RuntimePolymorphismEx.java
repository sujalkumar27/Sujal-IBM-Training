class Animal{
	void eat() {
		System.out.println("Animal's Eat");
	}
}
class Dog extends Animal{
	void eat() {
		System.out.println("Dog's Eat");
	}
}
class Elephant extends Animal{
	void eat() {
		System.out.println("Elephant's Eat");
	}
}
public class RuntimePolymorphismEx {
	public static void main(String[] args) {
		Animal a;
		a=new Animal();
		a.eat();
		a=new Dog();
		a.eat();
		a=new Elephant();
		a.eat();
	}
}