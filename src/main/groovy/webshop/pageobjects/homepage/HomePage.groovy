package webshop.pageobjects.homepage

import pagebase.pageobjects.AbstractPage
import webshop.pageobjects.common.AbstractWebShopPage

class HomePage extends AbstractWebShopPage {

    static at = {
        waitFor { girlInTheRedDress }
    }

    static content = {
        girlInTheRedDress { $('ul#homefeatured [alt="Faded Short Sleeve T-shirts"]') }
    }
}
