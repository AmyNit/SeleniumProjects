package testBase;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Abstract {

	
	
	
public static WebDriver wd;

public void init(){
	
	System.setProperty("user.dir", System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\geckodriver.exe");
	
	wd=new FirefoxDriver();
	
}
	
public void waitFor(int sec) throws InterruptedException{
	
	
	Thread.sleep(sec*1000);
	

}

public void waitForElement(By siginButton,int sec){
	
	
WebDriverWait wait=new WebDriverWait(wd,60);	
	
wait.until(ExpectedConditions.visibilityOfElementLocated(siginButton));		
}


public void ImageComparison() throws IOException{
	
	
	File screenshotfile=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotfile,new File( "outputimage.jpg"));
	
	File inputimage=new File("inputimage.jpg");
	File outputimage=new File("outputimage.jpg");
	
	BufferedImage bufferedinputimage=ImageIO.read(inputimage);
	DataBuffer inputimage1=bufferedinputimage.getData().getDataBuffer();
	int inputimagesize=inputimage1.getSize();
	System.out.println(inputimagesize);
	
	BufferedImage bufferedoutputimage=ImageIO.read(outputimage);
	DataBuffer outputimage1=bufferedoutputimage.getData().getDataBuffer();
	int outputimagesize=outputimage1.getSize();
	System.out.println(outputimagesize);
	
	boolean matchflag=true;
	if(inputimagesize==outputimagesize){
		
		
		Assert.assertTrue(true);
		}
	else{
		
		matchflag=false;
		Assert.assertTrue(false);	
		}
	
}

public String randomCharacters(){
	
int length=7;

String randomchara=new String();

String randomtext="jhksadjdfskaj";

Random random=new Random();

StringBuilder sb=new StringBuilder(length);

for(int i=0;i<=length;i++){
	

sb.append(randomtext.charAt(random.nextInt(randomtext.length())));
}
return randomchara+=sb;
	
	
}

public String randomIntegers(){
	
int length=7;

String randomintegers=new String();

String randomtext="90238429893";

Random random=new Random();

StringBuilder sb=new StringBuilder(length);
for(int i=0;i<=length;i++){
sb.append(randomtext.charAt(random.nextInt(randomtext.length())));
}
return randomintegers+=sb;
	
	
}

public String randomSpslCharacters(){
	
int length=7;

String randomspslcharacters=new String();

String randomtext="$#@%@$%#$%#$%$#";

Random random=new Random();

StringBuilder sb=new StringBuilder(length);
for(int i=0;i<=length;i++){
sb.append(randomtext.charAt(random.nextInt(randomtext.length())));
}
return randomspslcharacters+=sb;
	
	
}

public String randomnegnos(){
	
int length=7;

String randomnegnos=new String();

String randomtext="jhksadjdfskaj";

Random random=new Random();

StringBuilder sb=new StringBuilder(length);

for(int i=0;i<=length;i++){
sb.append(randomtext.charAt(random.nextInt(randomtext.length())));
}
return randomnegnos+=sb;
	
}

public void takeScreenshot() throws IOException{
	
	
File screenshotfile=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE)	;

FileUtils.copyFile(screenshotfile, new File("screenshot.jpg"));
	
	
	
	
}


public void ScrollDown(){
	
	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	
	jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
	
}
public void ScrollUp(){
	
	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	
	jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	
	
}
		
public void ScrollToPixelDown(){
	
	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	
	jse.executeScript("window.scrollBy(0,500)");
	
	
}	
public void ScrollToPixelUp(){
	
	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	
	jse.executeScript("window.scrollBy(0,-500)");
	
	
}		
	
public void ScrollToElement(By element){
	
	
	JavascriptExecutor jse=(JavascriptExecutor)wd;
	jse.executeScript("arguments[0].scrollIntoView(true)", wd.findElement(element));
	
	
	
}		
	
		
	

}
	
	
	
	
	
	
	
	
	
	

