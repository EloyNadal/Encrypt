package main;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Encryptor {
	
	
	public SecretKey passwordKeyGeneration(String text, int keySize) {
		SecretKey sKey = null; 
		
		try {
			byte[] data = text.getBytes("UTF-8"); 
			MessageDigest md = MessageDigest.getInstance("SHA-256"); 
			byte[] hash = md.digest(data); 
			byte[] key = Arrays.copyOf(hash, keySize/8); 
			sKey = new SecretKeySpec(key, "AES"); 
		} catch (Exception ex) { 
					System.err.println("Error generant la clau:" + ex); 
					 
		} 
		return sKey; 
	}
	
	public byte[] desencryptData(SecretKey sKey, byte[] data) {
		
		byte[] desEncryptedData = null;
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, sKey);
			desEncryptedData = cipher.doFinal(data);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return desEncryptedData;
		
	}

	

}
