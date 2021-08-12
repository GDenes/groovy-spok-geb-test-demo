package webshop.pageobjects.searchpage

import webshop.pageobjects.common.AbstractWebShopPage
import webshop.pageobjects.quickview.QuickViewDialogBox

class SearchPage extends AbstractWebShopPage {
    static content = {
        firstElement { $('div.left-block > .product-image-container') }
    }

    QuickViewDialogBox clickFirstElement() {
        firstElement.click()

        browser.page(QuickViewDialogBox)
    }
}
