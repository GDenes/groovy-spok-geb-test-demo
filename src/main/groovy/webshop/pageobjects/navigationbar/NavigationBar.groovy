package webshop.pageobjects.navigationbar


import io.qameta.allure.Step
import org.openqa.selenium.Keys
import webshop.pageobjects.common.AbstractModule
import webshop.pageobjects.searchpage.SearchPage
import webshop.pageobjects.tshirtpage.TShirtsPage

class NavigationBar extends AbstractModule {

    static at = {
        waitFor { womenButton }
        waitFor { dressesButton }
        waitFor { searchField }
    }

    static content = {
        womenButton { $('.sf-with-ul[title="Women"]') }
        dressesButton { $('ul.sf-menu > li > [title="Dresses"]') }
        tShirtsButton { $('ul.sf-menu .submenu-container [title="T-shirts"]') }
        searchField { $('#search_query_top') }
    }

    @Step("Fill input field with {searchText}")
    SearchPage fillInputFieldAndSearch(String searchText) {
        logger.info("Searching for `{}`", searchText)
        searchField.value(searchText)
        searchField << Keys.ENTER

        browser.page(SearchPage)
    }

    @Step("Move cursor to `Women button` and click to popup")
    TShirtsPage hoverAndClickTShirtsButton() {
        logger.info("Navigating to `T-shirts` page")
        interact {
            moveToElement(womenButton)
            perform()
        }
        waitFor { tShirtsButton }
        browser.page(TShirtsPage)
    }
}
