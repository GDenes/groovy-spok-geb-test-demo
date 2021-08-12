package webshop.pageobjects.fadedshortpage

import io.qameta.allure.Step
import pagebase.pageobjects.AbstractPage
import webshop.pageobjects.common.AbstractWebShopPage
import webshop.pageobjects.orderpage.OrderPage

class AddCartDialogBox extends AbstractWebShopPage {
    static at = {
        waitFor { productTitle.displayed }
        waitFor { proceedToCheckoutButton.displayed }
    }

    static content = {
        productTitle { $('#layer_cart_product_title') }
        colorAndSize { $('#layer_cart_product_attributes') }
        proceedToCheckoutButton { $('a.button-medium > span') }
    }

    @Step("Get title of product")
    String getProductTitleText() {
        logger.info("Getting title of product")
        waitFor { productTitle.displayed }
        return productTitle.text()
//        return productTitle
    }

    @Step("Get color and size of product")
    String getColorAndSizeText() {
        logger.info("Getting color and size of product")
        waitFor { colorAndSize.displayed }
        return colorAndSize.text()
        //return colorAndSize.text()
    }

    @Step("Click to `Proceed to checkout` button")
    OrderPage clickProceedToCheckoutButton() {
        logger.info("Clicking to `Proceed to checkout` button")
        proceedToCheckoutButton.click()
        browser.page(OrderPage)
    }

}
