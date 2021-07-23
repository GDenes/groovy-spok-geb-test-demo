package demoqa.pageobjects

import demoqa.pageobjects.elementspage.ElementsPage
import demoqa.pageobjects.iteractionspage.InteractionsPage
import demoqa.pageobjects.widgetspage.WidgetsPage
import geb.Browser
import org.openqa.selenium.By
import pagebase.pageobjects.AbstractPage

class NavigationPage extends AbstractPage {

    static url = "https://demoqa.com/"

    static content = {
        elements { $( By.xpath("//h5[text()='Elements']")) }
        forms { $('div.category-cards > div:nth-of-type(2) > div') }
        alertsFrameWindow { $('div.category-cards > div:nth-of-type(3) > div') }
        widgets { $('div.category-cards > div:nth-of-type(4)') }
        interactions { $('div.category-cards > div:nth-of-type(5)') }
        bookStoreApplication { $('div.category-cards > div:nth-of-type(6) > div') }
    }

    WidgetsPage navigateToWidgetsPage() {
        logger.info("Navigating to `Widgets` page")

    }

    ElementsPage navigateToElementsPage() {
        logger.info("Navigating to `Elements` page")
        elements.click()
        browser.page(ElementsPage)
    }

    InteractionsPage navigateToInteractionsPage() {
        logger.info("Navigating to `Interactions` page")

    }
}
