package demoqa.pageobjects.droppabblepage

import io.qameta.allure.Step
import org.openqa.selenium.WebElement
import pagebase.pageobjects.AbstractPage

class DroppablePage extends AbstractPage {

    static at = {
        waitFor { draggableComponent }
        waitFor { droppableSquareComponent }
    }

    static content = {
        draggableComponent { $('#draggable') }
        droppableSquareComponent { $('div#simpleDropContainer > #droppable') }
    }

    @Step("Drag and drop element")
    def dragAndDropElement() {
        logger.info("Moving cursor to draggable component and catch it")
        interact {
            moveToElement(draggableComponent)
            draggableComponent.click()
            pause(3)
            dragAndDrop(draggableComponent, droppableSquareComponent)
            perform()
        }
    }

}
