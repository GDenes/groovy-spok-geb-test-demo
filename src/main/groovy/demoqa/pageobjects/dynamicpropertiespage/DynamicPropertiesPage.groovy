package demoqa.pageobjects.dynamicpropertiespage

import geb.Page
import io.qameta.allure.Step
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pagebase.pageobjects.AbstractPage

class DynamicPropertiesPage extends AbstractPage {

    private static final String DANGER_CLASS_NAME = "text-danger"
    private static final int WAIT = 6

    static content = {
        enableAfter { $('#enableAfter') }
        colorChange { $('#colorChange') }
        visibleAfter { $('#visibleAfter') }
    }

    @Step("Check button is enabled")
    boolean willEnabledButton() {
        return enableAfter.firstElement().enabled
    }

    @Step("Check button color")
    boolean colorChangedButton() {
        logger.info("Checking button color");
        return colorChange.hasClass(DANGER_CLASS_NAME)
    }

    @Step("Check visible button")
    boolean visibleButton() {
        logger.info("Checking button visibility");
        waitFor(7) { visibleAfter }
        return visibleAfter.displayed
    }
}
