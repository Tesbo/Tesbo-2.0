package io.unity.framework.generators.locatorgenerator;

import io.unity.Utils;
import org.jsoup.nodes.Element;

public class ElementNameGenerator {

    Utils utility = new Utils();

    public String generateName(Element element) {


        String name = "unknown_element";

        ElementFilterHelper helper = new ElementFilterHelper();


        if (element.nodeName().equals("input")) {
            name = getNameForInputBox(element);
        }

        if (element.nodeName().equals("a")) {
            name = getNameForLink(element);
        }

        if (element.nodeName().equals("textarea")) {
            name = getNameForTextArea(element);
        }

        if (element.nodeName().equals("button")) {
            name = getNameForButton(element);
        }

        if (helper.checkForHeader(element)) {
            name = getNameFromAttributes(element, "text");
        }

        return name;
    }


    public String getNameForInputBox(Element element) {

        ElementChecker checker = new ElementChecker();
        String name = "unknown_element";

        String elementType = "text_box";
        if (element.nodeName().equals("input")) {
            if (element.attr("type").equals("text")) {
                elementType = "text_box";
            }
            if (element.attr("type").equals("submit")) {
                elementType = "button";
            }
            if (element.attr("type").equals("password")) {
                elementType = "password";
            }
            if (element.attr("type").equals("file")) {
                elementType = "file";
            }
            if (element.attr("type").equals("email")) {
                elementType = "email";
            }
            if (element.attr("type").equals("checkbox")) {
                elementType = "checkbox";
            }

        }

        if (element.hasText()) {
            name = utility.getFormattedTextName(element.text()) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "placeholder")) {
            name = utility.getFormattedTextName(element.attr("placeholder")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "value") && !utility.getFormattedTextName(element.attr("value")).equals("")) {
            name = utility.getFormattedTextName(element.attr("value")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "name")) {
            name = utility.getFormattedTextName(element.attr("name")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "id")) {
            name = utility.getFormattedTextName(element.attr("id")) + "_" + elementType;
            System.out.println(name);
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
            System.out.println(name);
        } else {
            Element element1 = element.parent().siblingElements().first();
            try {
                if (element1.nodeName().equals("label")) {
                    name = utility.getFormattedTextName(element1.text()) + "_" + elementType;
                }
            } catch (Exception e) {

            }
        }


        return name;
    }

    public String getNameForButton(Element element) {

        ElementChecker checker = new ElementChecker();
        String name = "unknown_element";
        String elementType = "button";
        if (element.nodeName().equals("button")) {
            if (element.attr("type").equals("button")) {
                //    elementType = "textField";
            }
        }


        if (element.hasText()) {
            name = utility.getFormattedTextName(element.text()) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "placeholder")) {
            name = utility.getFormattedTextName(element.attr("placeholder")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "value") && !utility.getFormattedTextName(element.attr("value")).equals("")) {
            name = utility.getFormattedTextName(element.attr("value")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "name")) {
            name = utility.getFormattedTextName(element.attr("name")) + "_" + elementType;

        } else if (checker.checkForAttributeIsAvailable(element, "id")) {
            name = utility.getFormattedTextName(element.attr("id")) + "_" + elementType;
            System.out.println(name);
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
            System.out.println(name);
        } else {
            Element element1 = element.parent().siblingElements().first();
            try {
                if (element1.nodeName().equals("label")) {
                    name = utility.getFormattedTextName(element1.text()) + "_" + elementType;
                }
            } catch (Exception e) {

            }
        }


        return name;
    }


    public String getNameForTextArea(Element element) {

        ElementChecker checker = new ElementChecker();
        String name = "unknown_element";
        String elementType = "textarea";
        if (element.nodeName().equals("textarea")) {
            if (element.attr("type").equals("textarea")) {
                //    elementType = "textField";
            }


        }


        if (element.hasText()) {
            name = utility.getFormattedTextName(element.text()) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "placeholder")) {
            name = utility.getFormattedTextName(element.attr("placeholder")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "value") && !utility.getFormattedTextName(element.attr("value")).equals("")) {
            name = utility.getFormattedTextName(element.attr("value")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "name")) {
            name = utility.getFormattedTextName(element.attr("name")) + "_" + elementType;

        } else if (checker.checkForAttributeIsAvailable(element, "id")) {
            name = utility.getFormattedTextName(element.attr("id")) + "_" + elementType;
            System.out.println(name);
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
            System.out.println(name);
        } else {
            Element element1 = element.parent().siblingElements().first();
            try {
                if (element1.nodeName().equals("label")) {
                    name = utility.getFormattedTextName(element1.text()) + "_" + elementType;
                }
            } catch (Exception e) {
            }
        }


        return name;
    }


    public String getNameForLink(Element element) {
        ElementChecker checker = new ElementChecker();
        String name = "unknown_element";
        String elementType = "link";

        if (element.attr("role").equals("button")) {
            elementType = "button";
        }
        if (element.hasText()) {
            name = utility.getFormattedTextName(element.text()) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "placeholder")) {
            name = utility.getFormattedTextName(element.attr("placeholder")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "value") && !utility.getFormattedTextName(element.attr("value")).equals("")) {
            name = utility.getFormattedTextName(element.attr("value")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "name")) {
            name = utility.getFormattedTextName(element.attr("name")) + "_" + elementType;

        } else if (checker.checkForAttributeIsAvailable(element, "id")) {
            name = utility.getFormattedTextName(element.attr("id")) + "_" + elementType;
            System.out.println(name);
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
            System.out.println(name);
        } else {
            Element element1 = element.parent().siblingElements().first();
            try {
                if (element1.nodeName().equals("label")) {
                    name = utility.getFormattedTextName(element1.text()) + "_" + elementType;
                }
            } catch (Exception e) {

            }

        }

        System.out.println("Element Link Name" + name);

        return name;
    }


    public String getNameFromAttributes(Element element, String elementType) {
        ElementChecker checker = new ElementChecker();
        String name = "unknown_element";

        if (element.attr("role").equals("button")) {
            elementType = "button";
        }
        if (element.hasText()) {
            name = utility.getFormattedTextName(element.text()) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "placeholder")) {
            name = utility.getFormattedTextName(element.attr("placeholder")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "value") && !utility.getFormattedTextName(element.attr("value")).equals("")) {
            name = utility.getFormattedTextName(element.attr("value")) + "_" + elementType;
        } else if (checker.checkForAttributeIsAvailable(element, "name")) {
            name = utility.getFormattedTextName(element.attr("name")) + "_" + elementType;

        } else if (checker.checkForAttributeIsAvailable(element, "id")) {
            name = utility.getFormattedTextName(element.attr("id")) + "_" + elementType;
            System.out.println(name);
        } else if (checker.checkForAttributeIsAvailable(element, "aria-label")) {
            name = utility.getFormattedTextName(element.attr("aria-label")) + "_" + elementType;
            System.out.println(name);
        } else {
            Element element1 = element.parent().siblingElements().first();
            try {
                if (element1.nodeName().equals("label")) {
                    name = utility.getFormattedTextName(element1.text()) + "_" + elementType;
                }
            } catch (Exception e) {

            }

        }

        if (elementType.contains("checkbox")) {
            if (name.split("_")[0].length() == 0)
                name = "unknown_name_checkbox";
        }

        return name;
    }
}
