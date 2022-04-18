package com.yuliya1303.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class TestGitIssueListener {

    @Test
    void isIssueTabExists() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String REPOSITORY = "Yuliya1303/homework5---JUnit";

        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $(partialLinkText("Issues")).click();

        $("#issues-tab").shouldNotBe(Condition.exist); //special step with bug to see Fail in Report
    }
}
