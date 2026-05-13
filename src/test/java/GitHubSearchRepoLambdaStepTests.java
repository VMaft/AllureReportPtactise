import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.GitHUBTestConfiguration;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.extension.TestLogExtension;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

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
    @ValueSource(strings = {"Code", "Pull requests", "Issues", "Actions", "Projects", "Security and quality", "Insights"})
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

    @Epic("Тесты с применением LambdaSteps")
    @Feature("LambdaSteps. Проверка табов репозитория" + REPO_NAME + ".")
    @Story("Проверка отсутствия Issues.")
    @DisplayName("LambdaSteps. В репозитории отсутствуют Issues")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("VMaft")
    @Link(value = "REPO_URL", url = REPO_URL)
    @Test
    void checkThatIssueTabCotainsNoIssue() {
        step("Переходим в репозиторий по ссылке.", () -> {
            open(REPO_URL);
        });
        step("Кликаем на таб Issues", () -> {
            issuesTabLocator.click();
        });
        step("Проверяем что список issue пустой и содержит текст: \"No results\"", () -> {
            $(".blankslate").shouldHave(text("No results"));
        });
    }

    @Epic("Тесты с применением LambdaSteps")
    @Feature("LambdaSteps. Проверка табов репозитория" + REPO_NAME + ".")
    @Story("Проверка данных таба Actions.")
    @DisplayName("Actions содержит сведения о запусках.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("VMaft")
    @Link(value = "REPO_URL", url = REPO_URL)
    @Test
    void checkThatActionsTabCotainsSomeData() {
        step("Переходим в репозиторий по ссылке.", () -> {
            open(REPO_URL);
        });
        step("Кликаем на таб Actions", () -> {
            actionsTabLocator.click();
        });
        step("Проверяем что список Actions не пустой и содержит данные.", () -> {
            //Ждем загрузки элемента и его содержимого
            actionsDataContainerElementsLocator.shouldBe(visible);
            assertThat(actionsDataElementsContainer.size()).isGreaterThan(2);
        });
    }

}