package webshop.tests


import spock.lang.Shared
import webshop.pageobjects.homepage.HomePage
import webshop.pageobjects.quickview.QuickViewDialogBox
import webshop.pageobjects.searchpage.SearchPage
import webshop.testsbase.WebShopBaseSpec

class WebShopSpec extends WebShopBaseSpec {

    static String SEARCH_VALUE = "blouse"
    static String BLOUSE_DESCRIPTION =
            "Short sleeved blouse with feminine draped sleeve detail."

    @Shared
    HomePage homePage

    def setup() {
        homePage = navigateToWebShopPage()
    }

//    def "Screenshot test"() {
//        when: "Navigating to `Tool Tips page`"
//        ToolTipsPage toolTipsPage = widgetsPage.navigateToToolTipsPage()
//
//        then: "expected"
//        toolTipsPage.hoverWebElementAndGetToolTipText(toolTipsPage.toolTipButton) == HOVERED_BUTTON_TEXT
//    }


    def "Product search"() {
        when: "Navigating to `Tool Tips page`"
        SearchPage searchPage = homePage.navigationBar.fillInputFieldAndSearch(SEARCH_VALUE)
        QuickViewDialogBox dialogBox = searchPage.clickFirstElement()

        then: "expected"
        dialogBox.getDescriptionText() == BLOUSE_DESCRIPTION
    }

}
