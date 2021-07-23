package demoqa.tests

import demoqa.pageobjects.NavigationPage
import demoqa.pageobjects.dynamicpropertiespage.DynamicPropertiesPage
import demoqa.pageobjects.elementspage.ElementsPage
import demoqa.pageobjects.uploadanddownloadpage.UploadAndDownloadPage
import geb.spock.GebSpec
import spock.lang.Shared

class ElementsSpec extends GebSpec {
    static final String UPLOADED_FILE_PATH = "C:\\fakepath\\sampleFile.jpeg"
    static final String LOCAL_FILE_PATH = "src/test/resources/test_data/sampleFile.jpeg"

    @Shared
    ElementsPage elementsPage

    def setup() {
        NavigationPage navigationPage = to NavigationPage
        elementsPage = navigationPage.navigateToElementsPage()
    }

    def "Dynamic properties"() {
        when: "Navigating to `Dynamic Properties page`"
        DynamicPropertiesPage dynamicPropertiesPage = elementsPage.navigateToDynamicPropertiesPage()

        then: "expected"
        dynamicPropertiesPage.visibleButton()
        dynamicPropertiesPage.willEnabledButton()
        dynamicPropertiesPage.colorChangedButton()
    }

    def "Upload file"() {
        when: "in `Upload and download` page"
        UploadAndDownloadPage uploadAndDownloadPage = elementsPage.navigateToUploadAndDownloadPage()

        then: "upload the file"
        uploadAndDownloadPage.uploadSampleFile(LOCAL_FILE_PATH)
        uploadAndDownloadPage.getFIlePathText().contains(UPLOADED_FILE_PATH)

    }

}
