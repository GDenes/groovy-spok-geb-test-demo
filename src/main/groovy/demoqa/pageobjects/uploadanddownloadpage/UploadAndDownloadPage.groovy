package demoqa.pageobjects.uploadanddownloadpage

import io.qameta.allure.Step
import pagebase.pageobjects.AbstractPage

class UploadAndDownloadPage extends AbstractPage {

    static content = {
        uploadFile { $("#uploadFile") }
        filePath { $('#uploadedFilePath') }
    }

    @Step("Upload file")
    void uploadSampleFile(String path){
        logger.info("Uploading file")
        File file = new File(path)
        uploadFile.value(file.getAbsolutePath())
    }

    @Step("Get uploaded file path")
    String getFIlePathText() {
        logger.info("Checking uploaded file path")
        waitFor(5) { filePath.displayed }
        return filePath.text()
    }
}
