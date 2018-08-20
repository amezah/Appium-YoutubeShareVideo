package com.accenture;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accenture.VideoShareAppium.FacebookShare;
import com.accenture.VideoShareAppium.YoutubePage;
import com.accenture.VideoShareAppium.YoutubePlayer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ShareVideoTest {
	
	public static AppiumDriver<MobileElement> driver; //Este driver es el que contralara los eventos de la automatizacion
	DesiredCapabilities capabilities = new DesiredCapabilities(); //caracteristicas de la automatizacion
	WebDriverWait wait;
	YoutubePage youtube;
	YoutubePlayer youtubePlayer;
	FacebookShare facebook;
	
	@BeforeMethod
	public void setUpAppium() throws MalformedURLException, InterruptedException {
		
		String packagename = "com.google.android.youtube"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		String activityname = "com.google.android.apps.youtube.app.WatchWhileActivity"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		
		capabilities.setCapability("deviceName", "Huawei P8"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "BHG7N16C26001815"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
		capabilities.setCapability("platformVersion", "7.0"); //No es obligatorio que la version coincida
		capabilities.setCapability("platformName", "Android"); //Nombre del sistema operativo
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		
		driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		youtube = new YoutubePage(driver);
		youtubePlayer = new YoutubePlayer(driver);
		facebook = new FacebookShare(driver);
		wait = new WebDriverWait(driver, 20);
	}	
	
	
	@Test
    public void shareTest() {		
		
		TouchAction action = new TouchAction(driver);
		try {
			//Seleccionar cuenta
			Thread.sleep(2000);
			youtube.seleccionarCuenta();
			//Presionar icono busqueda
			Thread.sleep(1000);
			youtube.presionarBotonBusqueda();
			
			Thread.sleep(2000);
			youtube.ingresarTexto("Papoman loco de amor");
			
			Thread.sleep(1000);
			youtube.seleccionarOpcion();
			
			Thread.sleep(2000);
			youtube.seleccionarVideo();		
			//Pausar
			Thread.sleep(3000);
			youtubePlayer.pausarCancion();
			//Compartir
			Thread.sleep(1000);
			youtubePlayer.presionarBotonCompartir();
			//fb 		
			Thread.sleep(1000);
			youtubePlayer.seleccionarfacebook();
			//Cambiar opcion de visibilidad
			Thread.sleep(2000);
			facebook.cambiarVisibilidad();			 
			//Atras
			Thread.sleep(1000);
			facebook.seleccionarAtras();
			//Compartir			
			Thread.sleep(1000);			
			facebook.compartir();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	@AfterTest
	public void CleanUpAppium() {
		//driver.quit();
	}
}
