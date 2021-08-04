package demoqa.tests

import demoqa.pageobjects.NavigationPage
import demoqa.pageobjects.droppabblepage.DroppablePage
import demoqa.pageobjects.dynamicpropertiespage.DynamicPropertiesPage
import demoqa.pageobjects.tooltipspage.ToolTipsPage
import demoqa.pageobjects.widgetspage.WidgetsPage
import geb.spock.GebSpec
import spock.lang.Shared

import javax.tools.Tool

class WidgetSpec extends GebSpec {

    @Shared
    WidgetsPage widgetsPage

    def setup() {
        NavigationPage navigationPage = to NavigationPage
        widgetsPage = navigationPage.navigateToWidgetsPage()
    }

    def "Drag and drop"() {
        given: "Navigating to `Dynamic Properties page`"
        ToolTipsPage toolTipsPage = widgetsPage.navigateToToolTipsPage()

        when:
        toolTipsPage.hoverWebElementAndGetToolTipText()

        then: "expected"

    }
}
