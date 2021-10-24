package fr.dropwizard.equisign.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeySingletonRsa {
	private static final KeySingletonRsa instance = new KeySingletonRsa();
	private PrivateKey privateKey;
	private PublicKey publicKey;
	private static final String ALGORITHM = "RSA";

	private KeySingletonRsa() {

		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
			keyGen.initialize(1024);
			KeyPair pair = keyGen.generateKeyPair();
			this.privateKey = pair.getPrivate();
			this.publicKey = pair.getPublic();
		} catch (NoSuchAlgorithmException e) {
			// TODO
		}
	}

	public static final KeySingletonRsa getInstance() {
		return instance;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}
}
