# transfert-file webapp
transfert-file webapp is developped in java/dropwizard for uploading/downloading encrypted files using the asymmetric encryption algorithm RSA

## Clone the project and open it into your IDE (Eclipse, IntelliJ, ..)
#### Execute the cmd : git clone git@github.com:AlbatusDev/transfer-file.git

## Modify config.yml file : 
  #### Define values for these variables from your local directories uploadFolder and downloadFolder
  #### Create a file $fileToUpload into #uploadFolder to upload it to the server 

## Launch the app

## Upload feature
#### Open Postman and execute this request : POST http://localhost:8080/file/upload/$fileToUpload/ext or execute the cmd curl -X POST http://localhost:8080/file/upload/$fileToUpload/ext
example of url :  http://localhost:8080/file/upload/myFile/txt

## Download feature
#### From your browser execute this request : http://localhost:8080/file/download/$fileToUploadEncrypted/ext or  execute cmd curl -X GET http://localhost:8080/file/download/$fileToUploadEncrypted/ext 
example of url : http://localhost:8080/file/download/myFileEncrypted/txt
