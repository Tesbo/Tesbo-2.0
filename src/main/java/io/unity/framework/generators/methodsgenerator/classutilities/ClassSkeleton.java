package io.unity.framework.generators.methodsgenerator.classutilities;


import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.tinylog.Logger;


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassSkeleton {

    JavaClassSource java_class;

    public ClassSkeleton(JavaClassSource java_class) {
        this.java_class = java_class;
    }

    public String get_package_name(String destination_path, String type) {
        String package_path = destination_path.replace(FileSystems.getDefault().getSeparator(), ".");
        String package_name = "";
        if (type.equals("web")) {
            package_name = "web.object_repository" + package_path.split("web.object_repository")[1];
        }
        if (type.equals("mobile")) {
            package_name = "mobile.object_repository" + package_path.split("mobile.object_repository")[1];

        }

        return package_name;
    }


    public void create_skeleton(String destination_path, String className, String type) {

        String package_name = get_package_name(destination_path, type);
        Logger.info("Setting up the package name :" + package_name);
        java_class.setPackage(package_name).setName(className);


        java_class.addImport("io.unity.performaction.autoweb.Element");
        java_class.addImport("io.unity.performaction.autoweb.Verify");
        java_class.addImport("org.openqa.selenium.WebDriver");
        java_class.addImport("org.testng.Assert");

        Logger.info("Adding Required class Imports :" + java_class.getImports());
        Logger.info("Adding Constructor");
        java_class.addMethod().setConstructor(true).setParameters("WebDriver driver").setBody("this.driver = driver;\n" +
                "        element = new Element(driver);\n" +
                "        verify = new Verify(driver);").setPublic();


        ClassVariableBuilder class_object = new ClassVariableBuilder(java_class);

        class_object.create_driver_class_variable();
        class_object.create_element_class_variable();
        class_object.create_verify_class_variable();


    }

    public void write_java_file(String destination_path, JavaClassSource java_class) {
        Logger.info("Creating a Java File on :" + destination_path);
        try {
            FileWriter fw = new FileWriter(destination_path);
            fw.write(java_class.toString());
            fw.close();

        } catch (Exception e) {
            Logger.error(e);
        }

        System.out.println("Class File Generated =================> " + destination_path);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null,
                destination_path);

        move_file(destination_path);
    }

    public void move_file(String java_file) {

        String source_class_file = java_file.replace(".java", ".class");

        String target_file_path_replace = FileSystems.getDefault().getSeparator() + "src" + FileSystems.getDefault().getSeparator() + "src/test" + FileSystems.getDefault().getSeparator() + "java";
        String destination_file_path_replace = FileSystems.getDefault().getSeparator() + "target" + FileSystems.getDefault().getSeparator() + "test-classes";
        String destination_file_path = source_class_file.replace(target_file_path_replace, destination_file_path_replace);


        Path temp = null;
        try {

            //temp = Files.move(Paths.get(source_class_file), Paths.get(destination_file_path), StandardCopyOption.REPLACE_EXISTING);

            //   temp = Files.move(new File(source_class_file).toPath(), new File(destination_file_path).toPath(), StandardCopyOption.REPLACE_EXISTING);

            FileUtils.moveFile(new File(source_class_file), new File(destination_file_path));

        } catch (FileExistsException e) {
            try {
                Files.delete(Paths.get(source_class_file));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (temp != null) {
            System.out.println("File renamed and moved successfully");
        } else {

            File file = new File(Paths.get(destination_file_path).toString());
            if (!file.exists()) {
                throw new RuntimeException("File Not Moved ");
            }
        }
    }

    public String get_class_file_directory(String destination_path) {

//  /Users/viralpatel/Viral/object_repository_generator/src/test/java/web/object_repository/login_page/registration/search_page.java
//  /Users/viralpatel/Viral/object_repository_generator/target/test-classes/web/object_repository/login_page/registration

        String target_destination = destination_path.replace("/src/test/java", "/target/test-classes").replace(".java", ".class");

        System.out.println("==========target=======> " + target_destination);

        return target_destination;
    }

}
