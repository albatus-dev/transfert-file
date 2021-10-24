# transfert-file webapp
transfert-file webapp is developped in java/dropwizard for uploading/downloading encrypted files

## Clone the project and open it into your IDE (Eclipse, IntelliJ, ..)

## Modify config.yml file : 
  #### Define values for these variables from your local directories fileUploadPathInput, fileUploadPathOutput and fileDownloadFolder
  #### Create a file $fileToUpload into #fileUploadPathInput to upload it to the server 

## Launch the app

## Test the file upload feature
#### Open Postman and execute this request : POST http://localhost:8080/file/upload or execute the cmd curl -X POST http://localhost:8080/file/upload

## Test the file download feature
#### From your browser execute this request : http://localhost:8080/file/download/$fileToUpload or  execute cmd curl -X GET http://localhost:8080/file/download/$fileToUpload
