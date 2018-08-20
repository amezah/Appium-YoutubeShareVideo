package com.accenture.VideoShareAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class YoutubePage {
	
	AppiumDriver<MobileElement> driver;
	MobileElement cuenta;
	MobileElement searchButton;
	MobileElement searchBar;
	
	public YoutubePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void seleccionarCuenta() {
		cuenta = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']"));
		cuenta.click();
	}
	
	public void presionarBotonBusqueda() {
		searchButton = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Buscar']"));
		searchButton.click();
	}
	
	public void ingresarTexto(String texto) {
		searchBar = driver.findElement(By.id("com.google.android.youtube:id/search_edit_text"));
		searchBar.sendKeys(texto);	
	}
	
	
	public void seleccionarOpcion() {
		driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0' and @bounds='[0,146][720,242]']")).click();
	}
	
	public void seleccionarVideo() {
		driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0' and @bounds='[0,162][720,371]']")).click();	
	}
	

}
