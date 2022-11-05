package io.tesbo.framework.generators.locatorgenerator;

import org.jsoup.nodes.Element;

public class ElementFilterHelper {

    /*Checking node is representing a element which is considerable or not
    *currently it's checking for the button, link, text area, input
    *
    */
    public boolean checkForValidElement(Element element) {
        boolean isValidElement = false;

        if (checkForButton(element) | checkForLink(element) | checkForTextarea(element) | checkForInput(element) | checkForHeader(element)) {
            isValidElement = true;
        }
        return isValidElement;
    }

    public Boolean checkForButton(Element element) {
        Boolean bool = false;

        if (element.nodeName().equals("button")) {
            bool = true;
        }
        return bool;
    }

    public Boolean checkForLink(Element element) {
        Boolean bool = false;

        if (element.nodeName().equals("a")) {
            bool = true;
        }
        return bool;
    }

    public Boolean checkForInput(Element element) {
        Boolean bool = false;

        if (element.nodeName().equals("input")) {
            bool = true;
        }
        return bool;
    }

    public Boolean checkForSelect(Element element) {
        Boolean bool = false;

        if (element.nodeName().equals("Select")) {
            bool = true;
        }
        return bool;
    }

    public Boolean checkForTextarea(Element element) {
        Boolean bool = false;

        if (element.nodeName().equals("textarea")) {
            bool = true;
        }
        return bool;
    }

    public Boolean checkForHeader(Element element)
    {
        Boolean bool = false;

        if (element.nodeName().equals("h1") | element.nodeName().equals("h2") | element.nodeName().equals("h3") | element.nodeName().equals("h4") | element.nodeName().equals("h5") | element.nodeName().equals("h6") |element.nodeName().equals("p") ) {
            bool = true;
        }
        return bool;
    }



}
