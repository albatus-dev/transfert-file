package fr.dropwizard.equisign.configuration;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class TransfertFileConfiguration extends Configuration {

	@NotEmpty
	private String fileUploadPathInput;

	@JsonProperty
	public String getFileUploadPathInput() {
		return fileUploadPathInput;
	}

	@NotEmpty
	private String fileUploadPathOutput;

	@JsonProperty
	public String getFileUploadPathOutput() {
		return fileUploadPathOutput;
	}

	@NotEmpty
	private String fileDownloadFolder;

	@JsonProperty
	public String getFileDownloadFolder() {
		return fileDownloadFolder;
	}
}
