package demoqa.pageobjects.iteractionspage

import demoqa.pageobjects.droppabblepage.DroppablePage
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import pagebase.pageobjects.AbstractPage

class InteractionsPage extends AbstractPage {

    static url = '/interaction'

    static content = {
        sortableMenuItem { $(By.xpath("//span[text()='Sortable']")) }
        selectableMenuItem { $(By.xpath("//span[text()='Selectable']")) }
        resizableMenuItem { $(By.xpath("//span[text()='Resizable']")) }
        droppableMenuItem { $(By.xpath("//span[text()='Droppable']")) }
        draggableMenuItem { $(By.xpath("//span[text()='Dragabble']")) }
    }

    @Step("Go to `Droppable page`")
    DroppablePage getDroppablePage() {
        logger.info("Navigating to `Droppable` page");
        JavascriptExecutor jse = (JavascriptExecutor)driver
        jse.executeScript("scroll(0, 250)")
        waitFor(5) { droppableMenuItem }
        droppableMenuItem.click();
        browser.page(DroppablePage);
    }
}
