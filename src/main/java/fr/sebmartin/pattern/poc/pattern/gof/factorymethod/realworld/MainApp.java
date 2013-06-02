package fr.sebmartin.pattern.poc.pattern.gof.factorymethod.realworld;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *  Factory Method pattern -- Structural example
 *
 * @author seb
 * @version 1.0 du 02/06/13 à 22:34
 */
public class MainApp {
    /**
     * MainApp startup class for Real-World
     * Factory Method Design Pattern.
     *
     * @param args arguments
     */
    public static void main(String[] args) throws IOException {
        // An array of creators
        Document[] documents = new Document[2];

        documents[0] = new Resume();
        documents[1] = new Report();

        // Iterate over creators and create products
        for (Document document : documents) {
            System.out.println("\n" + document.getClass().getSimpleName() + "--");
            for (Page page : document.getPages()) {
                System.out.println(" " + page.getClass().getSimpleName());
            }
        }

        // Wait for user input
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
    }
}

/**
 * The 'Product' abstract class
 */
abstract class Page {
}

/**
 * A 'ConcreteProduct' class
 */
class SkillsPage extends Page {
}

/**
 * A 'ConcreteProduct' class
 */
class EducationPage extends Page {
}

/**
 * A 'ConcreteProduct' class
 */
class ExperiencePage extends Page {
}

/**
 * A 'ConcreteProduct' class
 */
class IntroductionPage extends Page {
}

/**
 * A 'ConcreteProduct' class
 */
class ResultsPage extends Page {
}

/**
 * A 'ConcreteProduct' class
 */
class ConclusionPage extends Page {
}

/**
 * A 'ConcreteProduct' class
 */
class SummaryPage extends Page {
}

/**
 * A 'ConcreteProduct' class
 */
class BibliographyPage extends Page {
}

/**
 * The 'Creator' abstract class
 */
abstract class Document {

    private List<Page> pages = new LinkedList<Page>();

    protected Document() {
        this.createPages();
    }

    List<Page> getPages() {
        return pages;
    }

    public abstract void createPages();
}

/**
 * A 'ConcreteCreator' class
 */
class Resume extends Document {
    @Override
    public void createPages() {
        getPages().add(new SkillsPage());
        getPages().add(new EducationPage());
        getPages().add(new ExperiencePage());
    }
}

/**
 * A 'ConcreteCreator' class
 */
class Report extends Document {
    @Override
    public void createPages() {
        getPages().add(new IntroductionPage());
        getPages().add(new ResultsPage());
        getPages().add(new ConclusionPage());
        getPages().add(new SummaryPage());
        getPages().add(new BibliographyPage());
    }
}

