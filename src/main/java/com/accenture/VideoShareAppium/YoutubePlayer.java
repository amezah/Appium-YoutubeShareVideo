package com.accenture.VideoShareAppium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class YoutubePlayer {
	
	AppiumDriver<MobileElement> driver;
	MobileElement shareButton;
	TouchAction action;
	
	public YoutubePlayer(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		action = new TouchAction(driver);
	}
	
	public void pausarCancion() throws InterruptedException {
		action.tap(365, 250).perform();
		Thread.sleep(500);
		action.tap(365, 250).perform();
	}
	
	public void presionarBotonCompartir() {
		shareButton = driver.findElement(By.xpath("//android.view.View[@index='2' and @bounds='[360,572][526,709]']"));
		shareButton.click();
	}
	
	public void seleccionarfacebook() {
		boolean flag = true;
		
		do {
			
			MobileElement reciclerView = driver.findElement(By.xpath("//*[@class='android.support.v7.widget.RecyclerView' and @index='1']"));
			action.press(600, 1100).waitAction(Duration.ofSeconds(2)).moveTo(600, 650).release().perform();	
			
			List<MobileElement> textviews = reciclerView.findElements(By.className("android.widget.TextView"));
			//System.out.println(textviews.size()+" texts");
			for (int i = 0; i < textviews.size(); i++) {
				MobileElement text = textviews.get(i);
				//System.out.println("Text: "+text.getText());
				if(text.getText().equalsIgnoreCase("Facebook")) {
					//System.out.println("entro");
					text.click();
					flag = false;
					break;
				}
			}
			
		}while(flag);
	}

}
