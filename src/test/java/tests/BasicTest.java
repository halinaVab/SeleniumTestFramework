package tests;

import static com.codeborne.selenide.Selenide.open;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import pages.AccountCreationPage;
import pages.ContactUsPage;
import pages.ForgotPasswordPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.OrderHistoryPage;
import pages.OrderPage;
import pages.SearchResultPage;
import pages.SigninPage;
import pages.TShirtPage;

public class BasicTest {

	public MainPage mainPage;
	public ContactUsPage contactUsPage;
	public SearchResultPage searchResultPage;
	public SigninPage signinPage;
	public MyAccountPage myAccountPage;
	public TShirtPage tshirtPage;
	public OrderPage orderPage;
	public OrderHistoryPage orderHistoryPage;
	public AccountCreationPage accountCreationPage;
	public ForgotPasswordPage forgotPasswordPage;

	public String appURL = "http://automationpractice.com/index.php";

	@BeforeMethod(alwaysRun = true)
	@Parameters("browserName")
	public void setup(@Optional("chrome") String browserName) {
		setUpBrowser(browserName);
		open(appURL);
	}

	@Step("Set up browser: {browser}")
	public void setUpBrowser(String browser) {
		Configuration.browser = browser;
		Configuration.startMaximized = true;
	}

}
