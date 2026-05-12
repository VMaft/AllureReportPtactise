import com.codeborne.selenide.logevents.SelenideLogger;
import config.GitHUBTestConfiguration;
import config.WebSteps;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

@DisplayName("Практика по аттачментам")
public class GitHubSearchRepoAttachmentsSteps extends GitHUBTestConfiguration {

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
    }

    @Epic("Аттачменты с LambdaSteps")
    @Feature("AttachmentsTests_LambdaSteps. Добавление аттачментов в тест.")
    @Story("Проверка наличия табов из списка в репозитории.")
    @DisplayName("Делаем скриншот с LambdaStepsAttachments")
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("VMaft")
    @Link(value = "GitHubStartPage", url = URL)
    @Test()
    void testLambdaAttchments() {
        step("Открываем главную страницу GitHub.", () -> {
            open(URL);
        });
        attachment("Source", webdriver().driver().source());
    }

    @Epic("Аттачменты с WebSteps")
    @Feature("AttachmentsTests_WebSteps. Добавление аттачментов в тест.")
    @Story("Проверка наличия табов из списка в репозитории.")
    @DisplayName("Делаем скриншот с WebStepsAttachments")
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("VMaft")
    @Link(value = "GitHubStartPage", url = URL)
    @Test()
    void testAnnotatedAttachment() {
        WebSteps steps = new WebSteps();
        steps.openMainPage(URL);
        steps.takeScreenShot();
    }
}