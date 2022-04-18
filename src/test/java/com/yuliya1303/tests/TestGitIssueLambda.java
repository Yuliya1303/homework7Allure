package com.yuliya1303.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class TestGitIssueLambda {

    @Test
    void isIssueTabExists() {
        String REPOSITORY = "Yuliya1303/homework5---JUnit";

        step("Open main page", () -> {
            open("https://github.com/");
        });

        step("Search Repository", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Go to Repository link", () -> {
            $(linkText(REPOSITORY)).click();
            $(partialLinkText("Issues")).click();
        });

        step("Check if Issue tab exists", () -> {
            $("#issues-tab").shouldNotBe(Condition.exist); //special step with bug to see Fail in Report
            Allure.getLifecycle().addAttachment(
                    "Page sources",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }
}
