package fr.dropwizard.equisign.resources;

import java.security.PublicKey;

import javax.crypto.SecretKey;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.dropwizard.equisign.utils.CryptoUtils;

@Path("/file")
public class FileUploadResource {

	private String fileUploadPathInput;
	private String fileUploadPathOutput;
	// AES key
	// private SecretKey secretKey;
	// RSA key
	private PublicKey publicKey;

	public FileUploadResource(String fileUploadPathInput, String fileUploadPathOutput, SecretKey secretKey) {
		this.fileUploadPathInput = fileUploadPathInput;
		this.fileUploadPathOutput = fileUploadPathOutput;
		// this.secretKey = secretKey;
	}

	public FileUploadResource(String fileUploadPathInput, String fileUploadPathOutput, PublicKey publicKey) {
		this.fileUploadPathInput = fileUploadPathInput;
		this.fileUploadPathOutput = fileUploadPathOutput;
		this.publicKey = publicKey;
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/upload")
	public Response uploadFile() throws Exception {
		// Encrypt the file using AES algorithm
		// CryptoUtils.encrypt(fileUploadPathInput, fileUploadPathOutput, secretKey);

		// Encrypt the file using RSA algorithm
		CryptoUtils.encrypt(fileUploadPathInput, fileUploadPathOutput, publicKey);
		return Response.ok(String.format("File uploaded successfully to : %s", fileUploadPathOutput)).build();
	}
}
