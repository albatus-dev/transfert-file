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

	private String downloadFolder;
	// AES key
	// private SecretKey secretKey;
	// RSA key
	private PrivateKey privateKey;

	public FileDowloadResource(String downloadFolder, SecretKey secretKey) {
		this.downloadFolder = downloadFolder;
		// this.secretKey = secretKey;
	}

	public FileDowloadResource(String downloadFolder, PrivateKey privateKey) {
		this.downloadFolder = downloadFolder;
		this.privateKey = privateKey;
	}

	@GET
	@Produces(MediaType.MULTIPART_FORM_DATA)
	@Path("/download/{fileName}/{ext}")
	public Response downloadFile(@PathParam("fileName") String fileName, @PathParam("ext") String ext)
			throws Exception {
		File file = null;
		File fileToDownload = new File(downloadFolder.concat(fileName).concat(".").concat(ext));

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
