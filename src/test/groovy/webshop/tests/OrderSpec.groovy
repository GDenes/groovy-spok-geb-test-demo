package webshop.tests

import spock.lang.Shared
import webshop.enums.ColorEnum
import webshop.enums.SizeEnum
import webshop.pageobjects.fadedshortpage.AddCartDialogBox
import webshop.pageobjects.fadedshortpage.FadedShortPage
import webshop.pageobjects.homepage.HomePage
import webshop.pageobjects.orderpage.OrderPage
import webshop.pageobjects.quickview.QuickViewDialogBox
import webshop.pageobjects.searchpage.SearchPage
import webshop.pageobjects.tshirtpage.TShirtsPage
import webshop.testsbase.WebShopBaseSpec

class OrderSpec extends WebShopBaseSpec {

    static String HEADER = 'AUTHENTICATION'
    static String CURRENT_STEP = '02. Sign in'

    @Shared
    HomePage homePage

    def setup() {
        browser.clearCookies()
        homePage = navigateToWebShopPage()
    }

    def "Testing ordering in `Order` page"() {
        when: "Testing ordering in `Order` page`"
        TShirtsPage tShirtsPage = homePage.navigationBar.hoverAndClickTShirtsButton()
        FadedShortPage fadedShortPage = tShirtsPage.clickFadedShortItem()
        fadedShortPage.increaseQuantityNumber()
        fadedShortPage.selectSize(size)
        fadedShortPage.selectColor(color)
        AddCartDialogBox addCartDialogBox = fadedShortPage.clickAddCartButton()

        then: "expected"
        addCartDialogBox.getProductTitleText() == titleText
        addCartDialogBox.getColorAndSizeText() == colorAndSizetext

        and:
        OrderPage orderPage = addCartDialogBox.clickProceedToCheckoutButton()

        then:
        orderPage.getTotalProductText() == totalProduct
        orderPage.getTotalShippingText() == totalShipping
        orderPage.getTotalTaxText() == totalTax
        orderPage.getTotalPriceText() == totalPrice

        where:
        size       | color              | colorAndSizetext      | titleText                     | totalProduct | totalShipping | totalTax | totalPrice
        SizeEnum.M | ColorEnum.BLUE     | 'Blue, M'             | 'Faded Short Sleeve T-shirts' | '$33.02'     | '$2.00'       | '$2.00'  | '$35.02'
        SizeEnum.S | ColorEnum.ORANGE   | 'Orange, S'           | 'Faded Short Sleeve T-shirts' | '$33.02'     | '$2.00'       | '$2.00'  | '$35.02'
    }

}
