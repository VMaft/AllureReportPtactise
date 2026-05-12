import com.codeborne.selenide.logevents.SelenideLogger;
import config.GitHUBTestConfiguration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.Suite;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Определение табов в репозитории")
public class GitHubSearchRepoTests extends GitHUBTestConfiguration {

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
    }

    @Epic("Совершенно обычные параметризированные тесты.")
    @Feature("PageObjects. Проверка репозитория" + REPO_NAME + ".")
    @Story("Проверка наличия табов из списка в репозитории.")
    @ParameterizedTest(name = "Проверка наличия таба \"{0}\" в репозитории \"" + REPO_NAME + "\".")
    @ValueSource(strings = {"Code", "Pull requests", "Issues", "Actions", "Projects", "Security and quality", "Insights"})
    void specialRepoCanBeFoundOnGitHUB(String tabName) {
        open(URL);
        searchFieldLocator.click();
        expandedSearchFieldLocator.setValue(REPO_NAME).pressEnter();
        keyRepositoryLinkLocator.click();
        $(byAttribute("data-content", tabName)).shouldBe(visible);
    }
}