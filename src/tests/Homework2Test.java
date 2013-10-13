//package tests;
//
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//import static util.Util.*;
//
//import java.util.*;
//import java.util.regex.*;
//
//import org.junit.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//
//public class Homework2Test  {
//
//    public String userName = System.getProperty("userName");
//
//    public String BASE_URL = "http://ci.itcollege.ee/" + userName;
//
//    private static Pattern SESSION_ID_PATTERN =
//            Pattern.compile("id is[ :]+(\\w+)", Pattern.CASE_INSENSITIVE);
//    private static Pattern SESSION_COUNT_PATTERN =
//            Pattern.compile("count: (\\d+)", Pattern.CASE_INSENSITIVE);
//    private static Pattern SESSION_ATTRIBUTE_PATTERN =
//            Pattern.compile("attribute is[ :]+(\\w+)", Pattern.CASE_INSENSITIVE);
//
//    private static String HOME_PAGE = "HomePage";
//    private static String SESSION_COUNT_PAGE = "SessionCount";
//    private static String LOG_OUT_PAGE = "LogOut";
//
//    @Test
//    public void homePageCreatesSession_3() {
//        String id = getSessionId(getPageSource(HOME_PAGE));
//
//        assertThat(id, is(notNullValue()));
//    }
//
//    @Test
//    public void sessionIdStaysTheSameOnReturn_2() {
//        WebDriver driver = getDriver();
//
//        String idA = getSessionId(getPageSource(HOME_PAGE, driver));
//        String idB = getSessionId(getPageSource(HOME_PAGE, driver));
//
//        assertThat(idA, is(notNullValue()));
//        assertThat(idA, is(equalTo(idB)));
//    }
//
//    @Test
//    public void differentUserHasDifferentSession_2() {
//        String idA = getSessionId(getPageSource(HOME_PAGE));
//        String idB = getSessionId(getPageSource(HOME_PAGE));
//
//        assertThat(idA, is(not(equalTo(idB))));
//    }
//
//    @Test
//    public void newSessionIncreasesSessionCount_3() {
//
//        int sessionCountBefore = getSessionCount(getPageSource(SESSION_COUNT_PAGE));
//
//        getPageSource(HOME_PAGE);
//
//        int sessionCountAfter = getSessionCount(getPageSource(SESSION_COUNT_PAGE));
//
//        assertThat(sessionCountBefore, is(sessionCountAfter - 1));
//    }
//
//    @Test
//    public void logOutDecreasesSessionCount_1() {
//
//        int sessionCountBefore = getSessionCount(getPageSource(SESSION_COUNT_PAGE));
//
//        WebDriver driver = getDriver();
//        getPageSource(HOME_PAGE, driver);  // start new session
//        getPageSource(LOG_OUT_PAGE, driver);  // close session
//
//        int sessionCountAfter = getSessionCount(getPageSource(SESSION_COUNT_PAGE));
//
//        assertThat(sessionCountBefore, is(equalTo(sessionCountAfter)));
//    }
//
//    @Test
//    public void sessionParametersCanBeSet_1() {
//
//        String paramValue = String.valueOf(System.currentTimeMillis());
//
//        WebDriver driver = getDriver();
//        getPageSource(HOME_PAGE + "?param=" + paramValue, driver);
//
//        String sessionAttribute = getSessionAttribute(getPageSource(HOME_PAGE, driver));
//
//        assertThat(sessionAttribute, is(equalTo(paramValue)));
//    }
//
//    @Test
//    public void sessionParametersAreGoneAfterLogout_2() {
//
//        String paramValue = String.valueOf(System.currentTimeMillis());
//
//        WebDriver driver = getDriver();
//        getPageSource(HOME_PAGE + "?param=" + paramValue, driver);
//        getPageSource(LOG_OUT_PAGE, driver);
//
//        String sessionAttribute = getSessionAttribute(getPageSource(HOME_PAGE, driver));
//
//        assertThat(sessionAttribute, is("null"));
//    }
//
//    @After
//    public void closeOpenDrivers() {
//        for (WebDriver each : openDriversDrivers) {
//            each.close();
//        }
//    }
//
//    private Set<WebDriver> openDriversDrivers = new HashSet<>();
//
//    private String getPageSource(String pageName) {
//        return getPageSource(pageName, getDriver());
//    }
//
//    private String getPageSource(String pageName, WebDriver driver) {
//        driver.get(getUrl(pageName));
//        return driver.getPageSource();
//    }
//
//    private String getSessionId(String src) {
//        return matchCommon(src, SESSION_ID_PATTERN);
//    }
//
//    private String getSessionAttribute(String src) {
//        return matchCommon(src, SESSION_ATTRIBUTE_PATTERN);
//    }
//
//    private int getSessionCount(String src) {
//        String countAsString = matchCommon(src, SESSION_COUNT_PATTERN);
//        return countAsString != null ? Integer.valueOf(countAsString) : 0;
//    }
//
//    private WebDriver getDriver() {
//        WebDriver driver = new HtmlUnitDriver();
//        openDriversDrivers.add(driver);
//        return driver;
//    }
//
//    private String getUrl(String page) {
//        return BASE_URL + "/" + page;
//    }
//
//
//}
