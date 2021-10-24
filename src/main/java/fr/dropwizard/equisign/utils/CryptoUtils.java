package fr.dropwizard.equisign.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class CryptoUtils {

	private static final String ALGORITHM_AES = "AES";
	private static final String ALGORITHM_RSA = "RSA";

	public static void encrypt(String filePathInput, String filePathOutput, SecretKey secretKey) {

		try (FileInputStream fis = new FileInputStream(filePathInput);
				FileOutputStream fos = new FileOutputStream(filePathOutput)) {

			Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			byte[] buffer = new byte[64];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				byte[] output = cipher.update(buffer, 0, bytesRead);
				if (output != null) {
					fos.write(output);
				}
			}
			byte[] outputBytes = cipher.doFinal();
			if (outputBytes != null) {
				fos.write(outputBytes);
			}
		} catch (Exception exe) {
			// TODO
		}
	}

	public static File decrypt(File fileToDownload, SecretKey secretKey) {
		File tmpFile = new File("tempFile");

		try (FileInputStream fis = new FileInputStream(fileToDownload);
				FileOutputStream fos = new FileOutputStream(tmpFile)) {

			Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			byte[] buffer = new byte[64];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				byte[] output = cipher.update(buffer, 0, bytesRead);
				if (output != null) {
					fos.write(output);
				}
			}
			byte[] outputBytes = cipher.doFinal();
			if (outputBytes != null) {
				fos.write(outputBytes);
			}
		} catch (Exception exe) {
			// TODO
		}

		return tmpFile;
	}

	public static void encrypt(String filePathInput, String filePathOutput, PublicKey publicKey) {

		try (FileInputStream fis = new FileInputStream(filePathInput);
				FileOutputStream fos = new FileOutputStream(filePathOutput)) {

			Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);

			byte[] buffer = new byte[64];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				byte[] output = cipher.update(buffer, 0, bytesRead);
				if (output != null) {
					fos.write(output);
				}
			}
			byte[] outputBytes = cipher.doFinal();
			if (outputBytes != null) {
				fos.write(outputBytes);
			}
		} catch (Exception exe) {
			// TODO
		}
	}

	public static File decrypt(File fileToDownload, PrivateKey privateKey) {
		File tmpFile = new File("tempFile");

		try (FileInputStream fis = new FileInputStream(fileToDownload);
				FileOutputStream fos = new FileOutputStream(tmpFile)) {

			Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);

			byte[] buffer = new byte[64];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				byte[] output = cipher.update(buffer, 0, bytesRead);
				if (output != null) {
					fos.write(output);
				}
			}
			byte[] outputBytes = cipher.doFinal();
			if (outputBytes != null) {
				fos.write(outputBytes);
			}
		} catch (Exception exe) {
			// TODO
		}

		return tmpFile;
	}
}
