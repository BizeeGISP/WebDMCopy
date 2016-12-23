package com.bizee.core;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.bizee.constants.BizeeConstant;

/*@Configuration
@ImportResource("classpath:/config/webdm-servlet.xml")*/
public class EncryptDecrypt {
	
	
	    private static final String UNICODE_FORMAT = "UTF8";
	    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	    private static KeySpec ks;
	    private static SecretKeyFactory skf;
	    private static Cipher cipher;
	    static byte[] arrayBytes;
	    private static String myEncryptionKey;
	    private static String myEncryptionScheme;
	    static SecretKey key;

	    static {
	    	try{
	    		myEncryptionKey = "ThisIsSpartaThisIsSparta";
		        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
		        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);		       
		        ks = new DESedeKeySpec(arrayBytes);
		        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
		        cipher = Cipher.getInstance(myEncryptionScheme);
		        key = skf.generateSecret(ks);
	    	}
	    	catch(IOException e)
	    	{
	    		
	    	} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }


	    public static String encrypt(String unencryptedString) {
	        String encryptedString = null;
	        try {
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
	            byte[] encryptedText = cipher.doFinal(plainText);
	            encryptedString = new String(Base64.encodeBase64(encryptedText));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return encryptedString;
	    }


	    public static String decrypt(String encryptedString) {
	        String decryptedText=null;
	        try {
	            cipher.init(Cipher.DECRYPT_MODE, key);
	            byte[] encryptedText = Base64.decodeBase64(encryptedString);
	            byte[] plainText = cipher.doFinal(encryptedText);
	            decryptedText= new String(plainText);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return decryptedText;
	    }




	  /*  public static void main(String args []) throws Exception
	    {
	    	EncryptDecrypt td= new EncryptDecrypt();
            String a1="jdbc:mysql://192.168.30.45:3306/GISP";
	        String target="System";
	        String target1="B!z33$#12";
            String target="bizee";
            String target1="mysql@bizEE";
	        String e1=td.encrypt(BizeeConstant.USER_NAME);
	        String d1=td.decrypt(e1);
            
	        String e2=td.encrypt(a1);
	        String d2=td.decrypt(e2);
	        
	        String e1=td.encrypt(target);
	        String d1=td.decrypt(e1);
	        
	        String e3=td.encrypt(target1);
	        String d3=td.decrypt(e3);
	       
	        // String e2=td.encrypt();
	        //String d2=td.decrypt(e2);

	        //System.out.println("String To Encrypt: "+ target);
	        System.out.println("Encryptedurl String:" +   e2);
	        System.out.println("Decryptedurl String:" +   d2);
	        //System.out.println("String To Encrypt: "+ target1);
	      // System.out.println("Encrypted String:" + e2);
	        //System.out.println("Decrypted String:" + d2);

	        System.out.println("Encryptedun String:" +   e1);
	        System.out.println("Decryptedun String:" +    d1);
	        
	        System.out.println("Encryptedpwd String:" +   e3);
	        System.out.println("Decryptedpwd String:" +   d3);
	    }

	*/
	
}

