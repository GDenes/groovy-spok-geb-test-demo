package webshop.pageobjects.fadedshortpage

import io.qameta.allure.Step
import org.openqa.selenium.support.ui.Select
import pagebase.pageobjects.AbstractPage
import webshop.enums.ColorEnum
import webshop.enums.SizeEnum
import webshop.pageobjects.common.AbstractWebShopPage

class FadedShortPage extends AbstractWebShopPage {
    static at = {
        waitFor { increaseQuantityButton }
    }

    static content = {
        increaseQuantityButton { $('.icon-plus') }
        sizeInputField { $('.attribute_select') }
        blueColor { $('[name="Blue"]') }
        orangeColor { $('[name="Orange"]') }
        addToCartButton { $('button[name="Submit"] > span') }
    }

    @Step("Increase quantity number with one")
    def increaseQuantityNumber() {
        logger.info("Increasing quantity number with one")
        increaseQuantityButton.click()
    }

    @Step("Select {sizeText} size")
    def selectSize(SizeEnum sizeText) {
        logger.info("Selecting {} size", sizeText.name())
//        Select size = new Select(sizeInputField)
//        size.selectByVisibleText(sizeText.getText())
        sizeInputField = sizeText.getText()
    }

    @Step("Click to add chart button")
    AddCartDialogBox clickAddCartButton() {
        logger.info("Clicking to add chart button")
        addToCartButton.click()
        browser.page(AddCartDialogBox)
    }

    @Step("Select {color} color with click")
    def selectColor(ColorEnum color) {
        logger.info("Selecting {} color click", color.name())
        switch (color) {
            case ColorEnum.BLUE:
                blueColor.click();
                break;
            case ColorEnum.ORANGE:
                orangeColor.click();
                break;
        }
    }
}
