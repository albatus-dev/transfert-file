package fr.dropwizard.equisign.configuration;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class TransferFileConfiguration extends Configuration {

	@NotEmpty
	private String uploadFolder;

	@JsonProperty
	public String getUploadFolder() {
		return uploadFolder;
	}

	@NotEmpty
	private String downloadFolder;

	@JsonProperty
	public String getDownloadFolder() {
		return downloadFolder;
	}
}
