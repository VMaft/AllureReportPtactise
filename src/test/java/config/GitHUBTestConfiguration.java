package config;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public abstract class GitHUBTestConfiguration {
    protected final String URL = "https://github.com/";
    protected final String REPO_NAME = "VMaft/AllureReportPtactise";
    protected final SelenideElement searchFieldLocator = $("[data-target='qbsearch-input.inputButtonText']");
    protected final SelenideElement expandedSearchFieldLocator = $("#query-builder-test");
    protected final SelenideElement keyRepositoryLinkLocator = $(linkText("VMaft/AllureReportPtactise"));
}

