package fr.sebmartin.pattern.poc.pattern.gof.factorymethod.structural;

import java.io.IOException;

/**
 *  Factory Method pattern -- Structural example
 *
 * @author seb
 * @version 1.0 du 02/06/13 à 22:34
 */
public class MainApp {
    /**
     * MainApp startup class for Structural
     * Factory Method Design Pattern.
     *
     * @param args arguments
     */
    public static void main(String[] args) throws IOException {
        // An array of creators
        Creator[] creators = new Creator[2];

        creators[0] = new ConcretCreatorA();
        creators[1] = new ConcretCreatorB();

        // Iterate over creators and create products
        for (Creator creator : creators) {
            Product product = creator.factoryMethod();
            System.out.println(String.format("Created %s", product.getClass().getSimpleName()));
        }

        // Wait for user input
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
    }
}

/**
 * The 'Product' abstract class
 */
abstract class Product{
}

/**
 * A 'ConcreteProduct' class
 */
class ConcretProductA extends Product{
}

/**
 * A 'ConcreteProduct' class
 */
class ConcretProductB extends Product{
}

/**
 * The 'Creator' abstract class
 */
abstract class Creator{
    public abstract Product factoryMethod();
}

/**
 * A 'ConcreteCreator' class
 */
class ConcretCreatorA extends Creator{
    @Override
    public Product factoryMethod() {
        return new ConcretProductA();
    }
}

/**
 * A 'ConcreteCreator' class
 */
class ConcretCreatorB extends Creator{
    @Override
    public Product factoryMethod() {
        return new ConcretProductB();
    }
}

