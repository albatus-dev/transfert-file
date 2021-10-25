package fr.dropwizard.equisign;

import fr.dropwizard.equisign.configuration.TransfertFileConfiguration;
import fr.dropwizard.equisign.healthcheck.TransfertFileHealthCheck;
import fr.dropwizard.equisign.resources.FileDowloadResource;
import fr.dropwizard.equisign.resources.FileUploadResource;
import fr.dropwizard.equisign.utils.KeySingletonRsa;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class TransfertFileApplication extends Application<TransfertFileConfiguration> {

	private static final String server = "server";
	private static final String application = "transfert-file";
	private static String config = ("src/main/resources/config.yml");
	// AES key
	// private static KeySingletonAes keySingletonAes;
	// AES key
	private static KeySingletonRsa keySingletonRsa;

	public static void main(String[] args) throws Exception {

		// keySingletonAes = KeySingletonAes.getInstance();
		keySingletonRsa = KeySingletonRsa.getInstance();
		new TransfertFileApplication().run(server, config);
	}

	@Override
	public void run(TransfertFileConfiguration transFileConf, Environment env) throws Exception {
		env.jersey().register(new FileUploadResource(transFileConf.getUploadFolder(), transFileConf.getDownloadFolder(),
				keySingletonRsa.getPublicKey()));
		env.jersey()
				.register(new FileDowloadResource(transFileConf.getDownloadFolder(), keySingletonRsa.getPrivateKey()));
		env.healthChecks().register(application, new TransfertFileHealthCheck());
	}
}
