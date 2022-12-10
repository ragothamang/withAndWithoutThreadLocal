package com.base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInstance  {
//	static ChromeOptions options = new ChromeOptions();
	
	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();
	
//	private static RemoteWebDriver remoteWebdriver = null;  /* without thread local */
//	private static WebDriverWait wait = null;   /* without thread local */
	
	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), 30));
//		wait= new WebDriverWait(getDriver(), 30); /* without thread local */
	}

	public WebDriverWait getWait() {
		return wait.get();
//		return wait; /* without thread local */
	}

	public void setDriver(String browser, boolean headless) {		
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); 
			options.addArguments("--disable-notifications");
//			remoteWebdriver = new ChromeDriver(options); /* without thread local */
			remoteWebdriver.set(new ChromeDriver(options));
			break;
		case "firefox":
//			remoteWebdriver = new FirefoxDriver(); /* without thread local */
			remoteWebdriver.set(new FirefoxDriver());
			break;
		case "ie":
//			remoteWebdriver = new InternetExplorerDriver();   /* without thread local */
			remoteWebdriver.set(new InternetExplorerDriver());
		default:
			break;
		}
	}
	public RemoteWebDriver getDriver() {
//		return remoteWebdriver; /* without thread local */
		return remoteWebdriver.get();
	}
	
}
