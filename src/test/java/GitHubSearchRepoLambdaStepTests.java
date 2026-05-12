import com.codeborne.selenide.logevents.SelenideLogger;
import config.GitHUBTestConfiguration;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.extension.TestLogExtension;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@ExtendWith(TestLogExtension.class)
@DisplayName("Определение табов в репозитории с использованием LambdaSteps")
public class GitHubSearchRepoLambdaStepTests extends GitHUBTestConfiguration {

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
    }

    @Epic("Тесты с применением LambdaSteps")
    @Feature("LambdaSteps. Проверка табов репозитория" + REPO_NAME + ".")
    @Story("Проверка наличия табов из списка в репозитории.")
    @DisplayName("LambdaSteps.")
    @ParameterizedTest(name = "Проверка наличия таба \"{0}\" в репозитории.")
    @ValueSource(strings = {"Code", "Pull requests", "Actions", "Projects", "Security and quality", "Insights"})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("VMaft")
    @Link(value = "GitHubStartPage", url = URL)
    void specialRepoCanBeFoundOnGitHUB(String tabName) {
        step("Открываем главную страницу GitHub.", () -> {
            open(URL);
        });
        step("Ищем репозиторий \"" + REPO_NAME + "\".", () -> {
            searchFieldLocator.click();
            expandedSearchFieldLocator.sendKeys(REPO_NAME);
            expandedSearchFieldLocator.pressEnter();
        });
        step("Кликаем найденный репозиторий \"" + REPO_NAME + "\".", () -> {
            keyRepositoryLinkLocator.click();
        });
        step("Проверяем наличие таба \"" + tabName + "\" в репозитории из списка.", () -> {
            $(byAttribute("data-content", tabName)).shouldBe(visible);
        });
    }
}