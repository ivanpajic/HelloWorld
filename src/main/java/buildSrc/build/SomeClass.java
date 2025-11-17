package buildSrc.build;

public class SomeClass {
	
	
	public static SomeClass getSomething() {
		return new SomeClass();
	}
	
	public static void main(String[] args) {
		var variableX = getSomething();
	}
}
// change for shelving - make a change here
