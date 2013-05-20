package fr.sebmartin.pattern.poc.pattern.gof.abstractfactory.realworld;

import java.io.IOException;

/**
 * Abstract Factory pattern -- Real World example
 *
 * @author seb
 * @version 1.0 du 20/05/13 à 21:47
 */
public class MainApp {
    public static void main(String[] args) throws IOException {
        // Create and run the African animal world
        ContinentFactory africa = new AfricaFactory();
        AnimalWorld world = new AnimalWorld(africa);
        world.runFoodChain();

        // Create and run the American animal world
        ContinentFactory america = new AmericaFactory();
        world = new AnimalWorld(america);
        world.runFoodChain();

        // Wait for user input
        //noinspection ResultOfMethodCallIgnored
        System.in.read();

    }
}


/**
 * The 'AbstractFactory' abstract class
 */
abstract class ContinentFactory {
    public abstract Herbivore createHerbivore();
    public abstract Carnivore createCarnivore();
}

/**
 * The 'ConcreteFactory1' class
 */
class AfricaFactory extends ContinentFactory {

    @Override
    public Herbivore createHerbivore() {
        return new Wildebeest();
    }

    @Override
    public Carnivore createCarnivore() {
        return new Lion();
    }
}

/**
 * The 'ConcreteFactory2' class
 */
class AmericaFactory extends ContinentFactory {

    @Override
    public Herbivore createHerbivore() {
        return new Bison();
    }

    @Override
    public Carnivore createCarnivore() {
        return new Wolf();
    }
}


/***
 * The 'AbstractProductA' abstract class
 */
abstract class Herbivore {

}

/***
 * The 'AbstractProductB' abstract class
 */
abstract class Carnivore {
    public abstract void eat(Herbivore a);
}

/**
 * The 'ProductA1' class
 */
class Wildebeest extends Herbivore {

}

/**
 * The 'ProductB1' class
 */
class Lion extends Carnivore {

    @Override
    public void eat(Herbivore a) {
        System.out.println(this.getClass().getSimpleName() + " eats " + a.getClass().getSimpleName());
    }
}

/**
 * The 'ProductA2' class
 */
class Bison extends Herbivore {

}

/**
 * The 'ProductB2' class
 */
class Wolf extends Carnivore {

    @Override
    public void eat(Herbivore a) {
        System.out.println(this.getClass().getSimpleName() + " eats " + a.getClass().getSimpleName());
    }
}

/**
 * The 'Client' class. Interaction environment for the products.
 */
class AnimalWorld {
    private Herbivore herbivore;
    private Carnivore carnivore;

    AnimalWorld(ContinentFactory factory) {
        herbivore = factory.createHerbivore();
        carnivore = factory.createCarnivore();
    }

    public void runFoodChain() {
        carnivore.eat(herbivore);
    }
}

