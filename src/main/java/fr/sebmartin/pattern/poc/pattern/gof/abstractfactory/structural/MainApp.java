package fr.sebmartin.pattern.poc.pattern.gof.abstractfactory.structural;

import java.io.IOException;

/**
 * Abstract Factory pattern -- Structural example
 *
 * @author seb
 * @version 1.0 du 20/05/13 à 21:29
 */
public class MainApp {

    /**
     * MainApp startup class for Structural
     * Abstract Factory Design Pattern.
     *
     * @param args arguments
     */
    public static void main(String[] args) throws IOException {
        // Abstract Factory #1
        AbstractFactory factory1 = new ConcretFactory1();
        Client client1 = new Client(factory1);
        client1.run();

        // Abstract Factory #2
        AbstractFactory factory2 = new ConcretFactory2();
        Client client2 = new Client(factory2);
        client2.run();

        // Wait for user input
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
    }


}

/**
 * The 'AbstractFactory' abstract class
 */
abstract class AbstractFactory{
    public abstract AbstractProductA createProductA();
    public abstract AbstractProductB createProductB();
}

/**
 * The 'ConcreteFactory1' class
 */
class ConcretFactory1 extends AbstractFactory{

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

/**
 * The 'ConcreteFactory2' class
 */
class ConcretFactory2 extends AbstractFactory{

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}


/***
 * The 'AbstractProductA' abstract class
 */
abstract class AbstractProductA{

}

/***
 * The 'AbstractProductB' abstract class
 */
abstract class AbstractProductB{
    public abstract void interact(AbstractProductA a);
}

/**
 * The 'ProductA1' class
 */
class ProductA1 extends AbstractProductA{

}

/**
 * The 'ProductB1' class
 */
class ProductB1 extends AbstractProductB{

    @Override
    public void interact(AbstractProductA a) {
        System.out.println(this.getClass().getSimpleName() + " interacts with " + a.getClass().getSimpleName());
    }
}

/**
 * The 'ProductA2' class
 */
class ProductA2 extends AbstractProductA{

}

/**
 * The 'ProductB2' class
 */
class ProductB2 extends AbstractProductB{

    @Override
    public void interact(AbstractProductA a) {
        System.out.println(this.getClass().getSimpleName() + " interacts with " + a.getClass().getSimpleName());
    }
}

/**
 * The 'Client' class. Interaction environment for the products.
 */
class Client{
    private AbstractProductA abstractProductA;
    private AbstractProductB abstractProductB;

    Client(AbstractFactory factory) {
        abstractProductA = factory.createProductA();
        abstractProductB = factory.createProductB();
    }

    public void run() {
        abstractProductB.interact(abstractProductA);
    }
}