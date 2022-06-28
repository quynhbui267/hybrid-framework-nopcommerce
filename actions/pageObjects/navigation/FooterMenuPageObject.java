package pageObjects.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.FooterMenuPageUI;

public class FooterMenuPageObject extends BasePage {
	WebDriver driver;

	public FooterMenuPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public SitemapPageObject openSiteMapLink() {
		waitForElementClickable(driver, FooterMenuPageUI.SITEMAP_LINK);
		clickToElement(driver, FooterMenuPageUI.SITEMAP_LINK);
		return new SitemapPageObject(driver);
	}
	public SearchPageObject openSearchLink() {
		waitForElementClickable(driver, FooterMenuPageUI.SEARCH_LINK);
		clickToElement(driver, FooterMenuPageUI.SEARCH_LINK);
		return new SearchPageObject(driver);
	}

}
