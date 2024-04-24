package tests.web;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class OuiLoginTest extends TestBase {

    @Test
    void loginToApp() {
        step("Enter Login", () -> $("[name='email']").val("max.mustermann@storemind.de"));
        step("Enter Pass", () -> $("[name='password']").val("MMStore*Mind"));
        step("click Autorisieren", () -> $(byText("Autorisieren")).click());
        step("Enter Store Id", () -> $("[name='storeId']").val("0249"));
        step("Click Search Store", () -> $(byText("Store suchen")).click());
        step("Click open Store", () -> $(byText("Store annehmen")).click());
        step("Click open Prodect Catalog", () -> $(byText("Katalog öffnen")).click());

        ElementsCollection articles = $$(".infinite-scroll-component .css-3b8rxn");
        for (int i = 0; i < 3; i++) {
            articles.get(i).click();
            sleep(2000);
            $("[data-testid='CloseIcon']").click();
        }

    }

}
