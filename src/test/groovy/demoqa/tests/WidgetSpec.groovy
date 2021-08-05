package demoqa.tests

import demoqa.pageobjects.NavigationPage
import demoqa.pageobjects.tooltipspage.ToolTipsPage
import demoqa.pageobjects.widgetspage.WidgetsPage
import geb.spock.GebSpec
import spock.lang.Shared

class WidgetSpec extends GebSpec {

    String HOVERED_BUTTON_TEXT = 'You hovered over the Button'
    String HOVERED_TEXT_FIELD_TEXT = 'You hovered over the text field'

    @Shared
    WidgetsPage widgetsPage

    def setup() {
        NavigationPage navigationPage = to NavigationPage
        widgetsPage = navigationPage.navigateToWidgetsPage()
    }

    def "Tool tips test on button"() {
        when: "Navigating to `Tool Tips page`"
        ToolTipsPage toolTipsPage = widgetsPage.navigateToToolTipsPage()

        then: "expected"
        toolTipsPage.hoverWebElementAndGetToolTipText(toolTipsPage.toolTipButton) == HOVERED_BUTTON_TEXT
    }

    def "Tool tips test on text field"() {
        when: "Navigating to `Tool Tips page`"
        ToolTipsPage toolTipsPage = widgetsPage.navigateToToolTipsPage()

        then: "expected"
        toolTipsPage.hoverWebElementAndGetToolTipText(toolTipsPage.toolTipTextField) == HOVERED_TEXT_FIELD_TEXT
    }
}
