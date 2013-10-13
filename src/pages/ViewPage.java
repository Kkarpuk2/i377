package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ViewPage extends Pages {

    public ViewPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage insert(String name, String code) {
        element("nameBox").sendKeys(name);
        element("codeBox").sendKeys(code);
        element("addButton").click();
        return new SearchPage(driver);
    }

    public SearchPage clickBack() {
        element("backLink").click();
        return new SearchPage(driver);
    }

    public String getSelectedSuperUnit() {
        Select select = new Select(element("superUnitCode"));
        List<WebElement> options = select.getAllSelectedOptions();
        if (options.size() != 1) {
            throw new IllegalStateException("not one selected option");
        }
        return options.get(0).getAttribute("value");
    }
}
