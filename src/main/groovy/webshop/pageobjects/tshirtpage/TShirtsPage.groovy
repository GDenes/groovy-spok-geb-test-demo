package webshop.pageobjects.tshirtpage

import io.qameta.allure.Step
import webshop.pageobjects.common.AbstractWebShopPage
import webshop.pageobjects.fadedshortpage.FadedShortPage

class TShirtsPage extends AbstractWebShopPage {

    static at = {
        waitFor { fadedShortItem }
    }

    static content = {
        fadedShortItem { $('.product-name[title="Faded Short Sleeve T-shirts"]').first() }
    }

    @Step("Click to `Faded short item`")
    FadedShortPage clickFadedShortItem() {
        logger.info("Clicking to `Faded short item`");
        fadedShortItem.click()

        browser.page(FadedShortPage)
    }
}
