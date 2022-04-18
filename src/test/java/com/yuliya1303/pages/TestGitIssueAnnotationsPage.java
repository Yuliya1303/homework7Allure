package com.yuliya1303.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class TestGitIssueAnnotationsPage {
    @Step ("Open main page")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step ("Search Repository")
    public void searchRepository(String repositoryName) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repositoryName);
        $(".header-search-input").submit();
    }

    @Step ("Go to Repository link")
    public void clickOnRepositoryLink(String repositoryName) {
        $(linkText(repositoryName)).click();
        $(partialLinkText("Issues")).click();
    }

    @Step ("Check if Issue tab exists")
    public void checkIssueTabExisting() {
        $("#issues-tab").shouldNotBe(Condition.exist); //special step with bug to see Fail in Report
    }

}
