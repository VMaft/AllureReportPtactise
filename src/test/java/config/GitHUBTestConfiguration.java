package config;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.linkText;

public abstract class GitHUBTestConfiguration {
    protected final String URL = "https://github.com/";
    protected final String REPO_NAME = "VMaft/AllureReportPtactise";
    protected final String REPO_URL = "https://github.com/VMaft/AllureReportPtactise";

    protected final SelenideElement searchFieldLocator = $("[data-target='qbsearch-input.inputButtonText']");
    protected final SelenideElement expandedSearchFieldLocator = $("#query-builder-test");
    protected final SelenideElement keyRepositoryLinkLocator = $(linkText("VMaft/AllureReportPtactise"));
    protected final SelenideElement issuesTabLocator = $("#issues-tab");
    protected final SelenideElement actionsTabLocator = $("#actions-tab");
    protected final SelenideElement actionsDataContainerElementsLocator = $("#partial-actions-workflow-runs");
    protected final ElementsCollection actionsDataElementsContainer = $$("#partial-actions-workflow-runs .js-updatable-content");

}

