package org.example.pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private final SelenideElement firstItemInCart = $(By.xpath("//p[@class = 'sc-11uohgb-2 elbkhN']"));
    private final ElementsCollection namesAllItemsInCard = $$(By.xpath("//p[@class ='sc-11uohgb-2 elbkhN']"));


    public String getText() {
        firstItemInCart.shouldBe(visible);
        return firstItemInCart.getText();
    }
    public List<String> createNamesInCartList() {
        return namesAllItemsInCard.shouldHave(sizeGreaterThan(0)).texts();
    }


}
