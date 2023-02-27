package io.unity.framework.init;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.unity.framework.readers.json_file_reader;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;

public class AndroidParallel{
    json_file_reader config = new json_file_reader();
    public WebDriver driver;
    Utility utility = new Utility();
    int i=0;
    final String ip = "127.0.0.1";
    final String base_path = "/wd/hub";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    public AppiumDriverLocalService[] servers = new AppiumDriverLocalService[20];
    int[] ports = new int[20];
    AndroidDriver drivers[] = new AndroidDriver[20];
    DesiredCapabilities capabilities_android[] = new DesiredCapabilities[20];

    public AndroidDriver start_appium_servers() throws MalformedURLException {
        int count=0;
        while(servers[count]!=null){
            System.out.println(capabilities_android[count]+" "+count);
            servers[count].start();
            driver = new AndroidDriver(new URL("http://" + ip+ ":" + ports[count] + "" + base_path), capabilities_android[count]);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            count++;
            return (AndroidDriver) driver;
        }
        return null;
    }
    public void kill_appium_servers(){
        while(servers[i]!=null){
            servers[i].stop();
        }
    }

    public DesiredCapabilities get_capability(String configName,int i){
        JSONObject capabilityListObject = config.get_mobile_parallel_capabilities(configName,i);

        Iterator itr = capabilityListObject.keySet().iterator();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            capabilities.setCapability(key, capabilityListObject.get(key));
        }
        capabilities.setCapability("appium:app", config.get_final_app_path(configName));
        return capabilities;
    }

    public AndroidDriver setup_android_parallel(String configName) throws MalformedURLException {
        System.out.println("In Android Parallel");

       try {
           int i=0;
           while(i<config.getNoOfMobileDevices(configName)) {
               capabilities = get_capability(configName,i);
               capabilities_android[i] = capabilities;
               int port = utility.generateRandomPort();
               String appium_url= "http://" + ip+ ":" + port + "" + base_path;
               System.out.println("Appium URL "+appium_url);
               AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Atul Sharma\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress(ip).withArgument(GeneralServerFlag.BASEPATH,base_path).usingPort(port).build();
               servers[i] = service;
               ports[i] = port;
               i++;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return start_appium_servers();
    }

}
