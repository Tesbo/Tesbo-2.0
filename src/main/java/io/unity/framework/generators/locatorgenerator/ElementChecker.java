package io.unity.framework.generators.locatorgenerator;

import io.unity.framework.generators.locatorgenerator.xPathValidator;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class ElementChecker {

    public ArrayList getElementList(Element element) {
        xPathGenerator generator = new xPathGenerator();
        xPathValidator validator = new xPathValidator();
        ArrayList list = new ArrayList();


        if (element.hasText()) {

            String xpathWithNode = generator.generateXpathBasedOnText(element);
            if (validator.isxPathIsVisible(xpathWithNode)) {
                list.add(xpathWithNode);
            }

        } else if (checkForAttributeIsAvailable(element, "name")) {

            String xpathWithNode = generator.generateXpathBasedOnName(element);
            if (validator.isxPathIsVisible(xpathWithNode)) {
                list.add(xpathWithNode);
            }

        } else if (checkForAttributeIsAvailable(element, "id")) {

            String xpathWithNode = generator.generateXpathBasedOnId(element);
            if (validator.isxPathIsVisible(xpathWithNode)) {
                list.add(xpathWithNode);
            }

        } else if (checkForAttributeIsAvailable(element, "aria-label")) {

            if (validator.isxPathIsVisible(generator.generateXpathBasedOnAriaLabel(element))) {
                list.add(generator.generateXpathBasedOnAriaLabel(element));
            }

        } else if (checkForAttributeIsAvailable(element, "placeholder")) {
            if (validator.isxPathIsVisible(generator.generateXpathBasedOnPlaceholder(element))) {
                list.add(generator.generateXpathBasedOnPlaceholder(element));
            }

        } else if (checkForAttributeIsAvailable(element, "class")) {

            if (validator.isxPathIsVisible(generator.generateXpathBasedOnClass(element))) {
                list.add(generator.generateXpathBasedOnClass(element));
            }
        }


        return list;
    }


    public boolean checkForAttributeIsAvailable(Element element, String attributeName) {
        // System.out.println("Attributes   " + element.attributes());

        Attributes attributes = element.attributes();

        boolean bool = false;
        for (Attribute a : attributes.asList()) {
            if (a.getKey().equals(attributeName)) {
                bool = true;
                break;
            }
        }

        return bool;
    }


}
