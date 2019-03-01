package main;

import java.util.Scanner;

import javax.crypto.SecretKey;

public class Main {
	
	public final static byte[] data = {(byte)0xEC, (byte)0xC4, (byte)0xD5, (byte)0x89, 
										(byte)0x02, (byte)0xE3, (byte)0xD5, (byte)0xCC, 
										(byte)0x5E, (byte)0xC6, (byte)0xAF, (byte)0x6C, 
										(byte)0x61, (byte)0x8B, (byte)0xC2, (byte)0xA5
										};
	

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		String keyValue;
		
		Encryptor encryptor = new Encryptor();
		SecretKey sKey;
				
		for (int i = 0; i < 10000; i++) {
			 
			keyValue = String.valueOf(i);
			
			while (keyValue.length() != 4) keyValue = "0"+keyValue;
			
			sKey = encryptor.passwordKeyGeneration(keyValue, 192); 
			byte[] mensaje = encryptor.desencryptData(sKey, data);
			
			if (mensaje != null) {
				String msg = new String(mensaje);
				System.out.println(i + " = " + msg);
			}
			//if(i%100 == 0)sc.nextLine();
			
			
		}
		

	}
	
	

}
