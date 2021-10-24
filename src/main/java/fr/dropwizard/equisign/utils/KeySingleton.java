package fr.dropwizard.equisign.utils;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeySingleton {

	private static final KeySingleton instance = new KeySingleton(128);
	private SecretKey secretKey;
	private static final String ALGORITHM = "AES";

	private KeySingleton(int n) {

		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
			keyGenerator.init(n);
			secretKey = keyGenerator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO
		}
	}

	public static final KeySingleton getInstance() {
		return instance;
	}

	public SecretKey getSecretKey() {
		return secretKey;
	}
}
