package io.unity.framework.generators.locatorgenerator;

import io.unity.*;

import io.unity.framework.generators.locatorgenerator.Browser;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Scanner;


public class PageObject {


    public void generateLocatorForCurrentPage() {
        System.out.println("Current URL is" + Browser.driver.getCurrentUrl());

        Scanner in = new Scanner(System.in);

        String pageDom = Browser.driver.getPageSource();


        io.unity.Utils utility = new io.unity.Utils();
        String pageTitle = utility.getFormattedTextName(Browser.driver.getTitle()) + ".json";


        JSONObject elementObject = domParser(pageDom);

        System.out.println("Please Provide the locator File Name");
        Scanner commandIn = new Scanner(System.in);
        String command = commandIn.nextLine();

        GeneratePageObjectFile file = new GeneratePageObjectFile();
        file.createPageObjectFile(elementObject, command);


    }

    public JSONObject domParser(String dom) {

        Document doc = Jsoup.parse(dom);

        xPathGenerator generator = new xPathGenerator();


        String currentPath = "";
        Elements allElements =
                doc.getAllElements();

        ElementChecker checker = new ElementChecker();
        JSONObject elementObject = new JSONObject();

        for (Element element : allElements) {

            if (!element.nodeName().equals("#document")) {

                JSONObject object = new JSONObject();

                currentPath = currentPath + "/" + element.nodeName();

                ElementFilterHelper filterHelper = new ElementFilterHelper();
                ElementNameGenerator nameGenerator = new ElementNameGenerator();

                if (filterHelper.checkForValidElement(element)) {

                    JSONObject tinyObject = new JSONObject();
                    System.out.println("Element Node : " + element.nodeName());

                    String name = nameGenerator.generateName(element);
                    String[] element_name = name.split("_");

                    ArrayList list = checker.getElementList(element);
                    list.add(generator.generateAbsolutePath(element));

                    tinyObject.put("platform", "web");
                    if (name.contains("text_box")) {
                        tinyObject.put("element_type", "text_box");
                    } else {
                        tinyObject.put("element_type", element_name[element_name.length - 1]);
                    }
                    tinyObject.put("locator_type", "xpath");

                    tinyObject.put("locator_value", list.get(0));

                    tinyObject.put("objectGenerate", "generate");

                    elementObject.put(name, tinyObject);

                    /*if (list.size() > 0) {
                        elementObject.put("",object);
                    }*/
                    //  System.out.println("baseURl    " + element.cssSelector());

                }
            }


        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println(elementObject);

        return elementObject;
    }


}








