package fr.dropwizard.equisign.resources;

import java.security.PublicKey;

import javax.crypto.SecretKey;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.dropwizard.equisign.utils.CryptoUtils;

@Path("/file")
public class FileUploadResource {

	private String uploadFolder;
	private String downloadFolder;
	// AES key
	// private SecretKey secretKey;
	// RSA key
	private PublicKey publicKey;

	public FileUploadResource(String fileUploadPathInput, String downloadFolder, SecretKey secretKey) {
		this.uploadFolder = fileUploadPathInput;
		this.downloadFolder = downloadFolder;
		// this.secretKey = secretKey;
	}

	public FileUploadResource(String uploadFolder, String downloadFolder, PublicKey publicKey) {
		this.uploadFolder = uploadFolder;
		this.downloadFolder = downloadFolder;
		this.publicKey = publicKey;
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/upload/{fileName}/{ext}")
	public Response uploadFile(@PathParam("fileName") String fileName, @PathParam("ext") String ext) throws Exception {
		String fileInputPath = uploadFolder.concat(fileName).concat(".").concat(ext);
		String fileOutputPath = downloadFolder.concat(fileName).concat("Encrypted.").concat(ext);

		// Encrypt the file using AES algorithm
		// CryptoUtils.encrypt(fileUploadPathInput, fileUploadPathOutput, secretKey);

		// Encrypt the file using RSA algorithm
		CryptoUtils.encrypt(fileInputPath, fileOutputPath, publicKey);
		return Response.ok(String.format("File uploaded successfully to : %s", fileOutputPath)).build();
	}
}
