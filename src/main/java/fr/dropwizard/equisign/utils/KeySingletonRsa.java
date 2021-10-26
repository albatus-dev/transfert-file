package fr.dropwizard.equisign.utils;

import fr.dropwizard.equisign.exception.TransferFileException;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeySingletonRsa {

	private static final String ALGORITHM = "RSA";
	private static KeySingletonRsa instance;
	private final PrivateKey privateKey;
	private final PublicKey publicKey;

	public static synchronized KeySingletonRsa getInstance() throws TransferFileException {
		if (instance == null) {
			instance = new KeySingletonRsa();
		}
		return instance;
	}

	private KeySingletonRsa() throws TransferFileException {

		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
			keyGen.initialize(1024);
			KeyPair pair = keyGen.generateKeyPair();
			this.privateKey = pair.getPrivate();
			this.publicKey = pair.getPublic();
		} catch (NoSuchAlgorithmException nae) {
			throw new TransferFileException("An error occurred during generating RSA keyPair", nae);
		}
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}
}
