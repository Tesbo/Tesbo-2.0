package io.unity.framework.generators.methodsgenerator.init;


import io.unity.framework.generators.methodsgenerator.classutilities.ClassMethodsValidator;
import io.unity.framework.generators.methodsgenerator.classutilities.ClassSkeleton;
import io.unity.framework.generators.methodsgenerator.classutilities.GenerateMethods;
import io.unity.framework.generators.methodsgenerator.classutilities.JavaFileReader;
import net.minidev.json.parser.JSONParser;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.tinylog.Logger;
import java.util.List;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] args) {

        EntryPoint generator = new EntryPoint();
        generator.generate("mobile");
    }

    public void generate(String type) {


        ClassMethodsValidator validator = new ClassMethodsValidator();
        GenerateMethods methods = null;
        JavaFileReader file_reader = new JavaFileReader();

        JSONParser parser = new JSONParser();
        try {

            Scanner scanner = new Scanner(System.in);
            Logger.info("Enter Locator file folder");
            String file_path = scanner.nextLine();

            List<String> total_files = validator.look_for_locator_json_file(file_path);
            Logger.info("Total Files Found inside the Folder : " + total_files.size());


            if (total_files.size() > 0) {
                for (String json_file_path : total_files) {
                    Logger.info("Picking file : " + json_file_path);
                    JavaClassSource javaClass = null;
                    ClassSkeleton skeleton = null;
                    String java_class_file_path = validator.create_java_class_file_path(json_file_path);
                    String only_class_name = validator.create_java_class_name_without_extension(json_file_path);
                    Logger.info("Checking for the Class file is available or not");
                    if (!validator.check_java_class_is_exist(java_class_file_path)) {

                        Logger.info("Java Class is not available");
                        javaClass = Roaster.create(JavaClassSource.class);
                        skeleton = new ClassSkeleton(javaClass);
                        Logger.info("Creating a Java class with the name :" + only_class_name);
                        skeleton.create_skeleton(file_path, only_class_name,type);
                        skeleton.write_java_file(java_class_file_path, javaClass);

                    } else {
                        Logger.info("Java Class is available" + only_class_name);
                        Logger.info("Reading Java Class file");
                        javaClass =
                                Roaster.parse(JavaClassSource.class, file_reader.read_java_file(java_class_file_path));
                        skeleton = new ClassSkeleton(javaClass);

                    }

                    methods = new GenerateMethods(javaClass);
                    methods.generate_missing_methods(json_file_path, skeleton.get_package_name(file_path,type) + "." + only_class_name);
                    skeleton.write_java_file(java_class_file_path, javaClass);

                }
            } else {
                Logger.info("Enter the Folder which has the .json file ");

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
