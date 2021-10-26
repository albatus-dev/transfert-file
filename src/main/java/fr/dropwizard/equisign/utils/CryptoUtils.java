package fr.dropwizard.equisign.utils;

import fr.dropwizard.equisign.exception.TransferFileException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class CryptoUtils {

	private static final String ALGORITHM_RSA = "RSA";

	public static void encrypt(String filePathInput, String filePathOutput, PublicKey publicKey) throws TransferFileException {

		try (FileInputStream fis = new FileInputStream(filePathInput);
				FileOutputStream fos = new FileOutputStream(filePathOutput)) {

			Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);

			processCrypto(fis, fos, cipher);
		} catch (Exception exe) {
			throw new TransferFileException("An error occurred during encrypting file with RSA Algorithm", exe);
		}
	}

	public static File decrypt(File fileToDownload, PrivateKey privateKey) throws TransferFileException {
		File tmpFile = new File("tempFile");

		try (FileInputStream fis = new FileInputStream(fileToDownload);
				FileOutputStream fos = new FileOutputStream(tmpFile)) {

			Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);

			processCrypto(fis, fos, cipher);
		} catch (Exception exe) {
			throw new TransferFileException("An error occurred during decrypting file with RSA Algorithm", exe);
		}

		return tmpFile;
	}

	private static void processCrypto(FileInputStream fis, FileOutputStream fos, Cipher cipher) throws Exception {
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
	}
}
