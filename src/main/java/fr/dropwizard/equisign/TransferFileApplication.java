package fr.dropwizard.equisign;

import fr.dropwizard.equisign.configuration.TransferFileConfiguration;
import fr.dropwizard.equisign.healthcheck.TransferFileHealthCheck;
import fr.dropwizard.equisign.resources.FileDownloadResource;
import fr.dropwizard.equisign.resources.FileUploadResource;
import fr.dropwizard.equisign.utils.KeySingletonRsa;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class TransferFileApplication extends Application<TransferFileConfiguration> {

	private static final String SERVER = "server";
	private static final String APPLICATION = "transfer-file";
	private static final String CONFIG = ("src/main/resources/config.yml");
	private static KeySingletonRsa keySingletonRsa;

	public static void main(String[] args) throws Exception {
		keySingletonRsa = KeySingletonRsa.getInstance();
		new TransferFileApplication().run(SERVER, CONFIG);
	}

	@Override
	public void run(TransferFileConfiguration transferFileConf, Environment env)   {
		env.jersey().register(new FileUploadResource(transferFileConf.getUploadFolder(), transferFileConf.getDownloadFolder(),
				keySingletonRsa.getPublicKey()));
		env.jersey()
				.register(new FileDownloadResource(transferFileConf.getDownloadFolder(), keySingletonRsa.getPrivateKey()));
		env.healthChecks().register(APPLICATION, new TransferFileHealthCheck());
	}
}
