package demoqa.pageobjects.tooltipspage

import geb.navigator.Navigator
import org.openqa.selenium.By
import pagebase.pageobjects.AbstractPage

class ToolTipsPage extends AbstractPage {

    static url = '/tool-tips'

    static at = {
        waitFor { toolTipButton }
    }

    static content = {
        toolTipButton { $("#toolTipButton") }
        toolTipTextField { $("#toolTipTextField") }
        toolTipText { $(".tooltip-inner") }
    }

    String hoverWebElementAndGetToolTipText() {
        sleep(1000)
        interact {
            moveToElement(toolTipButton)
            perform()
        }
        waitFor { toolTipText.displayed }
        return  toolTipText.text()
    }

}
