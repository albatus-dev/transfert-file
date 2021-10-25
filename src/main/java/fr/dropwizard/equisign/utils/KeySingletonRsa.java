package fr.dropwizard.equisign.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeySingletonRsa {

	private static final String ALGORITHM = "RSA";
	private static KeySingletonRsa instance;
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public static final KeySingletonRsa getInstance() {
		if (instance == null) {
			instance = new KeySingletonRsa();
		}
		return instance;
	}

	private KeySingletonRsa() {

		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
			keyGen.initialize(1024);
			KeyPair pair = keyGen.generateKeyPair();
			this.privateKey = pair.getPrivate();
			this.publicKey = pair.getPublic();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("An error occurred during generating RSA keyPair");
		}
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}
}
