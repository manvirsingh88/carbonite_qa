package com.carbonite.qa.webpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carbonite.qa.base.TestBase;

public class SignUpPage extends TestBase {

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav[@class='main']//ul/li")
	@CacheLookup
	List<WebElement> webPageList;

	@FindBy(name = "Email")
	@CacheLookup
	WebElement inputEmail;

	@FindBy(name = "confirmEmail")
	@CacheLookup
	WebElement confirmEmail;

	@FindBy(name = "Password")
	@CacheLookup
	WebElement inputPassword;

	@FindBy(name = "ConfirmPassword")
	@CacheLookup
	WebElement confirmPassword;

	@FindBy(name = "Country")
	@CacheLookup
	WebElement selectCountry;

	@FindBy(name = "GDPROptIn")
	WebElement checkBox;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement submitButton;

	@FindBy(xpath = "//span[contains(text(),'Email must match confirm email')]")
	public WebElement emailNotMatchingAlert;

	@FindBy(xpath = "//span[contains(text(),'The confirm password confirmation does not match.')]")
	public WebElement passwordNotMatchingAlert;

	@FindBy(xpath = "//button[@class='circle']")
	public WebElement closeCookieDialogBox;

	public BuisnessSolutionPage ClickOnBuisnessSolutionPage() {

		webPageList.get(1).click();

		return new BuisnessSolutionPage(); // Return the object of the Landing Page -> Business Solution

	}

	public CompareBackUpPlanPage ClickOnCompareBackUpPlanPage() {

		webPageList.get(2).click();

		return new CompareBackUpPlanPage(); // Return the object of the Landing Page -> Compare BackUp Plan

	}

	public FreeTrialPage ClickOnFreeTrialPlanPage() {

		webPageList.get(4).click();

		return new FreeTrialPage(); // Return the object of the Landing Page -> Free Trial
	}

	public AllProductsPage ClickOnAllProductsPage() {

		webPageList.get(3).click();

		return new AllProductsPage(); // Return the object of the Landing Page -> All Product
	}

	public void fillSignUpForm(String input_Email, String confirm_Email, String input_Password,
			String confirm_Password) {
		inputEmail.sendKeys(input_Email);
		confirmEmail.sendKeys(confirm_Email);
		inputPassword.sendKeys(input_Password);
		confirmPassword.sendKeys(confirm_Password);
	}

	public void selectCountryFromDropDown(String countryName) {

		selectCountry.click();

		Select select = new Select(selectCountry);

		select.selectByVisibleText(countryName);

		checkBox.click();

	}

	public DownloadPage clickOnSubmitButton() {

		submitButton.submit();

		return new DownloadPage();
	}

	public void clickCookieDialogBoxCloseButton() {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(closeCookieDialogBox));

		closeCookieDialogBox.click();
	}

}
