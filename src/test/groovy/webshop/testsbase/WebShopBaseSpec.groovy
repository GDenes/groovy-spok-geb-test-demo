package webshop.testsbase

import geb.spock.GebSpec
import webshop.pageobjects.homepage.HomePage

class WebShopBaseSpec extends GebSpec {

    static String BASE_URL = "http://automationpractice.com/index.php"

    HomePage navigateToWebShopPage() {
        browser.go(BASE_URL)
        browser.page(HomePage)
    }
}
