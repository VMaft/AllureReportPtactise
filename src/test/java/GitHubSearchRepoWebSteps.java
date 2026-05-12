import com.codeborne.selenide.logevents.SelenideLogger;
import config.GitHUBTestConfiguration;
import config.WebSteps;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.extension.TestLogExtension;

@ExtendWith(TestLogExtension.class)
@DisplayName("Определение табов в репозитории с использованием WebSteps")
public class GitHubSearchRepoWebSteps extends GitHUBTestConfiguration {

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Epic("Тесты с использованием WebSteps")
    @Feature("WebSteps. Проверка репозитория.")
    @Story("Проверка наличия табов из списка в репозитории.")
    @ParameterizedTest(name = "Проверка наличия таба \"{0}\" в репозитории.")
    @ValueSource(strings = {"Code", "Pull requests", "Actions","Projects","Security and quality","Insights"})
    @Severity(SeverityLevel.BLOCKER)
    @Owner("VMaft")
    @Link(value = "GitHubStartPage", url = URL)
    void specialRepoCanBeFoundOnGitHUB(String tabName) {
        WebSteps steps = new WebSteps();
        steps.openMainPage(URL);
        steps.searchForRepositoryByName(REPO_NAME);
        steps.clickOnRepositoryLink(REPO_NAME);
        steps.checkTabVisibility(tabName);
    }
}