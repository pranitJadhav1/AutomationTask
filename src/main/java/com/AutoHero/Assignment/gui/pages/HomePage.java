
package com.AutoHero.Assignment.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;



public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "carMakeFilter")
    private ExtendedWebElement carSelection ;

    @FindBy(xpath = "//button[text()='Alles akzeptieren']")
    private ExtendedWebElement acceptCookies ;

    @FindBy(xpath = "//input[@value='Volkswagen']")
    private ExtendedWebElement brandName;
    
    @FindBy(xpath = "//input[@value='Golf']")
    private ExtendedWebElement modelName;
    
    @FindBy(id = "mileageFilter")
    private ExtendedWebElement mileageFilter ;

    @FindBy(xpath = "(//select[@id='rangeEnd'])[3]")
    private ExtendedWebElement DD ;
    
    @FindBy(xpath = "//div[@aria-label='grid']//child::div[contains(@class,'infoContainer')]//following::div[starts-with(@class,'titleWrapper___2yAH1')]")
    private List<ExtendedWebElement> CarName ;
    
    @FindBy(xpath = "//div[@aria-label='grid']//child::div[contains(@class,'infoContainer')]//following::li[@data-qa-selector='spec-mileage']")
    private List<ExtendedWebElement> CarMileage ;
    		

    public HomePage(WebDriver driver) {
        super(driver);
        
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }


	
	public ExtendedWebElement getCarSelection() {
		carSelection.click();
		return carSelection;
	}


	public ExtendedWebElement getAcceptCookies() {
		return acceptCookies;
	}


	public ExtendedWebElement getBrandName() {
		return brandName;
	}


	public ExtendedWebElement getModelName() {
		return modelName;
	}


	public ExtendedWebElement getMileageFilter() {
		return mileageFilter;
	}


	public ExtendedWebElement getDD() {
		return DD;
	}


	public List<ExtendedWebElement> getCarName() {
		return CarName;
	}


	public List<ExtendedWebElement> getCarMileage() {
		return CarMileage;
	}

  

   
    
   
}
