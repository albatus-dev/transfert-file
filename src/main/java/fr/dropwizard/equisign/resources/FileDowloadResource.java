package fr.dropwizard.equisign.resources;

import java.io.File;
import java.security.PrivateKey;

import javax.crypto.SecretKey;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.dropwizard.equisign.utils.CryptoUtils;

@Path("/file")
public class FileDowloadResource {

	private String fileDownloadFolder;
	// AES key
	// private SecretKey secretKey;
	// RSA key
	private PrivateKey privateKey;

	public FileDowloadResource(String fileDownloadFolder, SecretKey secretKey) {
		this.fileDownloadFolder = fileDownloadFolder;
		// this.secretKey = secretKey;
	}

	public FileDowloadResource(String fileDownloadFolder, PrivateKey privateKey) {
		this.fileDownloadFolder = fileDownloadFolder;
		this.privateKey = privateKey;
	}

	@GET
	@Produces(MediaType.MULTIPART_FORM_DATA)
	@Path("/download/{fileName}")
	public Response downloadFile(@PathParam("fileName") String fileName) throws Exception {
		File file = null;
		File fileToDownload = new File(fileDownloadFolder.concat(fileName));
		if (fileToDownload.exists()) {
			// Decrypt the file using AES algorithm
			// file = CryptoUtils.decrypt(fileToDownload, secretKey);

			// Decrypt the file using RSA algorithm
			file = CryptoUtils.decrypt(fileToDownload, privateKey);
		} else {
			return Response.status(204, "File not exists").build();
		}

		return Response.ok(file).build();
	}

}
