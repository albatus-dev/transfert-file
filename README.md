# JAVA-DROPWIZARD
Create a webapp in java/dropwizard for uploading/downloading encrypted files

#How to test the app

## Open the project into your IDE (Eclipse, IntelliJ, ..)

## Modify config.yml file : 
  ### Define values for these variables from your localDirectories fileUploadPathInput, fileUploadPathOutput and fileDownloadFolder
  ### Create a first file to upload into the server into #fileUploadPathInput

## Launch the app

## Test the file upload feature
### Open Postman and execute this request : POST http://localhost:8080/file/upload

## Test the file download feature
### From your browser execute this request : http://localhost:8080/file/download/$youruploadedFile
