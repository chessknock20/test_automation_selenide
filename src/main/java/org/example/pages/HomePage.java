package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class HomePage {

    private final SelenideElement firstItem = $(By.xpath("//div [@class='sc-124al1g-2 dwOYCh']"));
    private final SelenideElement addToCartFirstItem = $(By.xpath(" //div[@class='sc-124al1g-2 dwOYCh']/button"));
    private final ElementsCollection namesAllItems = $$(By.xpath("//p[@class ='sc-124al1g-4 eeXMBo']"));
    private final ElementsCollection allAddToCartIcons = $$(By.xpath("//*[text() = 'Add to cart']"));
    private final SelenideElement xsButton = $(By.xpath("//span[@class = \"checkmark\"][text() = 'XS']"));
    private final ElementsCollection xsItems = $$(By.xpath("//p[@class ='sc-124al1g-4 eeXMBo']"));
    private final SelenideElement countAllItemsIcon = $(By.xpath("//main[@class = 'sc-ebmerl-4 iliWeY']//p"));
    private final SelenideElement countSItemsIcon = $(By.xpath("//main[@class = 'sc-ebmerl-4 iliWeY']//p"));
    private final SelenideElement sButton = $(By.xpath("//span[@class = \"checkmark\"][text() = 'S']"));
    private final ElementsCollection sItems = $$(By.xpath("//p[@class ='sc-124al1g-4 eeXMBo']"));

    public void addFirstItemToCart() {
       firstItem.shouldBe(visible);
        addToCartFirstItem.click();
    }
    public List<String> createNamesList() {
        return namesAllItems.shouldHave(sizeGreaterThan(0)).texts();
    }

    public void addAllItemsToCart() {
        for (SelenideElement items : allAddToCartIcons){
            ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].click();", items.toWebElement());
        }
    }
    public int namesAllItemsSize() {
        namesAllItems.shouldHave(sizeGreaterThan(0));
        return namesAllItems.size();
    }
    public void clickXsButton() {
        xsButton.click();
    }
    public void clickSButton() {
        sButton.click();
    }
    public int xsItemsSize() {
        xsItems.shouldHave(sizeLessThan(16));
        return xsItems.size();
    }
    public int countAllItems() {
        namesAllItems.shouldHave(sizeGreaterThan(0));
        String[] mas = countAllItemsIcon.getText().split("[,\\s]+");
        int countAll = Integer.parseInt(mas[0]);
        return countAll;
    }
    public int countSItems() {
        sItems.shouldHave(sizeLessThan(16));
        String[] mas2 = countSItemsIcon.getText().split("[,\\s]+");
        int countS = Integer.parseInt(mas2[0]);
        return countS;
    }

}
