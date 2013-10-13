package pages;

import org.openqa.selenium.WebDriver;

public class SearchPage extends Pages {

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage goTo() {
        goTo(SEARCH_PAGE);
        return new SearchPage(driver);
    }

    public void delete(String code) {
        element("delete_" + code).click();
    }

    public ViewPage view(String code) {
        element("view_" + code).click();
        return new ViewPage(driver);
    }

    public SearchPage search(String searchString) {
        element("searchStringBox").sendKeys(searchString);
        element("filterButton").click();
        return new SearchPage(driver);
    }

}
