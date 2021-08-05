package demoqa.tests

import demoqa.pageobjects.NavigationPage
import demoqa.pageobjects.droppabblepage.DroppablePage
import demoqa.pageobjects.dynamicpropertiespage.DynamicPropertiesPage
import demoqa.pageobjects.tooltipspage.ToolTipsPage
import demoqa.pageobjects.widgetspage.WidgetsPage
import geb.spock.GebSpec
import spock.lang.Shared

class WidgetSpec extends GebSpec {

    String HOVERED_BUTTON_TEXT = 'You hovered over the Button'

    @Shared
    WidgetsPage widgetsPage

    def setup() {
        NavigationPage navigationPage = to NavigationPage
        widgetsPage = navigationPage.navigateToWidgetsPage()
    }

    def "Tool tips test"() {
        when: "Navigating to `Dynamic Properties page`"
        ToolTipsPage toolTipsPage = widgetsPage.navigateToToolTipsPage()

        then: "expected"
        toolTipsPage.hoverWebElementAndGetToolTipText() == HOVERED_BUTTON_TEXT
    }
}
