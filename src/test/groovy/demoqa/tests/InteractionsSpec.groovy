package demoqa.tests

import demoqa.pageobjects.NavigationPage
import demoqa.pageobjects.droppabblepage.DroppablePage
import demoqa.pageobjects.dynamicpropertiespage.DynamicPropertiesPage
import demoqa.pageobjects.iteractionspage.InteractionsPage
import geb.spock.GebSpec
import spock.lang.Shared

class InteractionsSpec extends GebSpec {

    String DROPPED_VALUE = "Dropped!"
    String DROPPED_SQUARE_BACKGROUND_COLOR = "70, 130, 180"

    @Shared
    InteractionsPage interactionsPage

    def setup() {
        NavigationPage navigationPage = to NavigationPage
        interactionsPage = navigationPage.navigateToInteractionsPage()
    }

    def "Drag and drop"() {
        given: "Navigating to `Dynamic Properties page`"
        DroppablePage droppablePage = interactionsPage.getDroppablePage()

        when:
        droppablePage.dragAndDropElement()

        then: "expected"
        droppablePage.droppableSquareComponent.text() == DROPPED_VALUE
        droppablePage.droppableSquareComponent.css("background-color")
                .contains(DROPPED_SQUARE_BACKGROUND_COLOR)
    }
}
