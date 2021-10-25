package fr.dropwizard.equisign.utils;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeySingletonAes {

	private static final String ALGORITHM = "AES";
	private static KeySingletonAes instance;
	private SecretKey secretKey;

	public static synchronized KeySingletonAes getInstance() {
		if (instance == null) {
			instance = new KeySingletonAes();
		}
		return instance;
	}

	private KeySingletonAes() {

		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
			keyGenerator.init(128);
			secretKey = keyGenerator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("An error occurred during generating AES secretKey");
		}
	}

	public SecretKey getSecretKey() {
		return secretKey;
	}
}
