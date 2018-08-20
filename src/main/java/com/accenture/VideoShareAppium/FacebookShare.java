package com.accenture.VideoShareAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class FacebookShare {
	
	AppiumDriver<MobileElement> driver;
	TouchAction action;
	
	public FacebookShare(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		action = new TouchAction(driver);
	}
	
	public void cambiarVisibilidad() throws InterruptedException {
		action.tap(290, 240).perform();
		Thread.sleep(1000);			
		action.tap(330, 880).perform();
		Thread.sleep(1000);
		action.tap(300, 1030).perform();		
	}
	
	public void seleccionarAtras() {
		action.tap(70, 120).perform();
	}
	
	public void compartir() {
		action.tap(600, 100).perform();
	}

}
