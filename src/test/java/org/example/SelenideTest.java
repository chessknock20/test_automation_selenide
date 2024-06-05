package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.listeners.LocalListener;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class SelenideTest {

    HomePage homepage = new HomePage();
    CartPage cartPage = new CartPage();

    @BeforeMethod
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
        SelenideLogger.addListener("LocalListener", new LocalListener());
    }

    @Test
    public void addOneItem() {
        open("https://react-shopping-cart-67954.firebaseapp.com");
        homepage.addFirstItemToCart();
        assertEquals(cartPage.getText(), "Cropped Stay Groovy off white");
    }

    @Test
    public void findAllItems() {
        open("https://react-shopping-cart-67954.firebaseapp.com");
        List<String> namesListInHomepage = homepage.createNamesList();
        homepage.addAllItemsToCart();
        List<String> namesListInCart = cartPage.createNamesInCartList();
        Assert.assertEquals(namesListInHomepage, namesListInCart);

    }
    @Test
    public void filterItems() {
        open("https://react-shopping-cart-67954.firebaseapp.com");
        int sizeAllItems = homepage.namesAllItemsSize();
        homepage.clickXsButton();
        int sizeXsItems = homepage.xsItemsSize();
        Assert.assertTrue(sizeAllItems > sizeXsItems);
    }
    @Test
    public void parsingItems() {
        open("https://react-shopping-cart-67954.firebaseapp.com");
        int countAll = homepage.countAllItems();
        homepage.clickSButton();
        int countS = homepage.countSItems();
        Assert.assertTrue(countAll > countS);
    }



}
