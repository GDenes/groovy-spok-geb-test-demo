package webshop.pageobjects.orderpage

import io.qameta.allure.Step
import webshop.pageobjects.common.AbstractWebShopPage
import webshop.pageobjects.signin.SignInPage

class OrderPage extends AbstractWebShopPage {

    static at = {
        waitFor { totalProduct }
        waitFor { totalShipping }
        waitFor { totalTax }
        waitFor { totalPrice }
        waitFor { proceedToCheckoutButton }
    }

    static content = {
        totalProduct { $('#total_product') }
        totalShipping { $('#total_shipping') }
        totalTax { $('#total_shipping') }
        totalPrice { $('#total_price') }
        proceedToCheckoutButton { $('a.standard-checkout > span') }
    }

    @Step("Click to `Proceed to checkout` button")
    SignInPage clickProceedToCheckoutButton() {
        logger.info("Clicking to `Proceed to checkout` button")
        proceedToCheckoutButton.click()
        browser.page(SignInPage)
    }

    @Step("Get `Total product` text value")
    String getTotalProductText() {
        logger.info("Get `Total product` text value")
        return totalProduct.text()
    }

    @Step("Get value of `Total shipping`")
    String getTotalShippingText() {
        logger.info("Get value of `Total shipping`")
        return totalShipping.text()
    }

    @Step("Get value of `Total tax`")
    String getTotalTaxText() {
        logger.info("Get value of `Total tax`")
        return totalTax.text()
    }

    @Step("Get value of `Total price`")
    String getTotalPriceText() {
        logger.info("Get value of `Total price`")
        return totalPrice.text()
    }
}
