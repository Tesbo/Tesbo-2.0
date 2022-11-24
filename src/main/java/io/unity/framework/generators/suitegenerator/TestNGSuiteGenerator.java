package io.unity.framework.generators.suitegenerator;

import io.unity.framework.data.TestData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestNGSuiteGenerator {


    public void generateSuite(String platform) {

        TestNGSuiteGenerator generator = new TestNGSuiteGenerator();


        try {
            generator.suiteCreate(platform);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    public List<String> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
        final List<String> methods = new ArrayList<>();
        Class<?> klass = type;
        while (klass != Object.class) { // need to traverse a type hierarchy in order to process methods from super types
            // iterate though the list of methods declared in the class represented by klass variable, and add those annotated with the specified annotation
            for (final Method method : klass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotation)) {

                    methods.add(method.getName());
                }
            }
            // move to the upper class in the hierarchy in search for more methods
            klass = klass.getSuperclass();
        }
        return methods;
    }

    public List<String> findAllTestClasses(String dir) {
        List<String> result = null;

        List temp = new ArrayList();
        try {
            Stream<Path> walk = Files.walk(Paths.get(dir + "/testcases"));
            result = walk.map(Path::toFile)
                    .sorted(Comparator.comparing(File::lastModified))
                    .map(p -> p.toString()) // convert path to string
                    .filter(f -> ((String) f).endsWith(".class"))       // check end with
                    .collect(Collectors.toList());        // collect all matched to a List


        } catch (Exception e) {

        }

        return result;
    }


    void suiteCreate(String platform) throws ClassNotFoundException, MalformedURLException {

        File myFolder = new File("target/test-classes/" + platform);
        TestNGSuiteGenerator generator = new TestNGSuiteGenerator();

        List<String> allClass = generator.findAllTestClasses(myFolder.getAbsolutePath());

        URLClassLoader classLoader = new URLClassLoader(new URL[]{myFolder.toURI().toURL()},
                Thread.currentThread().getContextClassLoader());


        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = documentBuilder.newDocument();

        Element root = document.createElement("suite");
        document.appendChild(root);
        root.setAttribute("name", "regression");


        for (String classPath : allClass) {

            System.out.println(classPath);

            String separator = FileSystems.getDefault().getSeparator();

            String fullClassPath = platform + classPath.split(platform)[1].split(".class")[0].replace(separator, ".");


            Class<?> myClass = Class.forName(fullClassPath, true, classLoader);
            Class ann = Class.forName("org.testng.annotations.Test");

            List<String> methodsList = generator.getMethodsAnnotatedWith(myClass, ann);

            for (String methods : methodsList) {
                Element test = document.createElement("src/test");

                test.setAttribute("name", methods+"_"+ TestData.random_numeric_string(4));

                Element classes = document.createElement("classes");
                test.appendChild(classes);

                Element singleClass = document.createElement("class");
                singleClass.setAttribute("name", fullClassPath);
                classes.appendChild(singleClass);


                Element methodsElment = document.createElement("methods");
                singleClass.appendChild(methodsElment);

                Element includeElement = document.createElement("include");
                includeElement.setAttribute("name", methods);
                methodsElment.appendChild(includeElement);


                root.appendChild(test);
            }


        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("src/test/java/suites/regression.xml"));

        // If you use
        // StreamResult result = new StreamResult(System.out);
        // the output will be pushed to the standard output ...
        // You can use that for debugging

        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        System.out.println("Done creating XML File");

    }


}