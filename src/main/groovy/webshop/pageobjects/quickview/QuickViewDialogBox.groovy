package webshop.pageobjects.quickview

import io.qameta.allure.Step
import pagebase.pageobjects.AbstractPage

class QuickViewDialogBox extends AbstractPage {

    static at = {
        waitFor { iframe }
    }

    static content = {
        description { $('#short_description_content') }
        iframe { $('.fancybox-iframe') }
    }

    @Step("Get short description of product")
    String getDescriptionText() {
        logger.info("Get short description of product");
        withFrame(iframe) {
            waitFor { description.text() }
            return description.text()
        }
    }
}
