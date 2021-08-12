package webshop.pageobjects.signin

import io.qameta.allure.Step
import pagebase.pageobjects.AbstractPage
import webshop.pageobjects.common.AbstractWebShopPage

class SignInPage extends AbstractWebShopPage {
    static at = {
        waitFor { pageHead }
        waitFor { createAccountButton }
        waitFor { signInButton }
        waitFor { currentStep }
    }

    static content = {
        pageHead { $('.page-heading') }
        createAccountButton { $('button#SubmitCreate > span') }
        signInButton { $('button#SubmitLogin > span') }
        currentStep { $('li.step_current > span') }
    }

    @Step("Get head text of page")
    def String getHeadText() {
        logger.info("Get head text of page")
        return pageHead.text()
    }

    @Step("Get current text of current step")
    def String getCurrentStepText() {
        logger.info("Get current text of current step")
        return currentStep.text()
    }
}
