package config;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Value;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps extends GitHUBTestConfiguration {
    @Step("Открываем главную страницу GitHub.")
    public void openMainPage(String url){
        open(url);
    }

    @Step("Ищем репозиторий {repositoryName}")
    public void searchForRepositoryByName(String repositoryName){
        searchFieldLocator.click();
        expandedSearchFieldLocator.sendKeys(REPO_NAME);
        expandedSearchFieldLocator.pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repositoryName}")
    public void clickOnRepositoryLink(String repositoryName){
        keyRepositoryLinkLocator.click();
    }

    @Step("Проверяем наличие таба {tabName} на странице репозитория.")
    public void checkTabVisibility(String tabName){
        $(byAttribute("data-content", tabName)).shouldBe(visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
