import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class DrumTest {
	
	public static AppiumDriver<MobileElement> driver; //Este driver es el que contralara los eventos de la automatizacion
	DesiredCapabilities capabilities = new DesiredCapabilities(); //caracteristicas de la automatizacion
	WebDriverWait wait;
	TouchAction action;
	
	@Test
	public void f() {
		action = new TouchAction(driver);
		
		try {
			Thread.sleep(8000);
			action.tap(530, 240).perform();	
			Thread.sleep(2000);
			action.tap(300, 85).perform();
			Thread hilo = new Thread(){	        
		       
		        @Override
		        public void run(){
		        	for (int i = 0; i < 50; i++) {				
						action.tap(850, 650).perform();
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		           
		        }
		    };
		    Thread hilo2 = new Thread(){	        
			       
		        @Override
		        public void run(){
		        	for (int i = 0; i < 100; i++) {				
						action.tap(1160, 640).perform();
						try {
							Thread.sleep(250);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}		           
		        }
		    };
			hilo.start();
			hilo2.start();
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		
		String packagename = "br.com.rodrigokolb.realdrum"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		String activityname = "br.com.rodrigokolb.realdrum.RealDrumActivity"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		
		capabilities.setCapability("deviceName", "Huawei P8"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "BHG7N16C26001815"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
		capabilities.setCapability("platformVersion", "7.0"); //No es obligatorio que la version coincida
		capabilities.setCapability("platformName", "Android"); //Nombre del sistema operativo
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		
		driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 20);
	}
	
	@AfterTest
	public void afterTest() {
	}

}
