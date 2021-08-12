package webshop.pageobjects.common

import pagebase.pageobjects.AbstractPage
import webshop.pageobjects.navigationbar.NavigationBar

class AbstractWebShopPage extends AbstractPage {

    static content = {
        navigationBar { module(NavigationBar) }
    }

}
