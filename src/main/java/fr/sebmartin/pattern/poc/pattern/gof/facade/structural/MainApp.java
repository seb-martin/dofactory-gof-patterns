package fr.sebmartin.pattern.poc.pattern.gof.facade.structural;

import java.io.IOException;

/**
 * Facade pattern -- Structural example
 *
 * @author seb
 * @version 1.0 du 18/05/13 à 02:12
 */
public class MainApp {

    /**
     * Entry point into console application.
     *
     * @param args arguments
     */
    public static void main(String[] args) throws IOException {
        Facade facade = new Facade();

        facade.methodA();
        facade.methodB();

        // Wait for user
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
    }
}

/**
 * The 'Subsystem ClassA' class
 */
class SubSystemOne{
    public void methodOne() {
        System.out.println(" SubSystemOne Method");
    }
}

/**
 * The 'Subsystem ClassB' class
 */
class SubSystemTwo{
    public void methodTwo() {
        System.out.println(" SubSystemTwo Method");
    }
}

/**
 * The 'Subsystem ClassC' class
 */
class SubSystemThree{
    public void methodThree() {
        System.out.println(" SubSystemThree Method");
    }
}

/**
 * The 'Subsystem ClassD' class
 */
class SubSystemFour{
    public void methodFour() {
        System.out.println(" SubSystemFour Method");
    }
}

/**
 * The 'Facade' class
 */
class Facade{
    private SubSystemOne one;
    private SubSystemTwo two;
    private SubSystemThree three;
    private SubSystemFour four;

    Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }

    public void methodA() {
        System.out.println("\nMethodA() ---- ");
        one.methodOne();
        two.methodTwo();
        four.methodFour();
    }

    public void methodB() {
        System.out.println("\nMethodB() ---- ");
        two.methodTwo();
        three.methodThree();
    }
}