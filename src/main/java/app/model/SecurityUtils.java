package app.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurityUtils {
		
		public static String getSalt(String HashSalasana, String salt) {
			String result = "";
			
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				
				byte[] saltBytes = Base64.getDecoder().decode(salt);
				md.update(saltBytes);
				byte[] bytes = md.digest(HashSalasana.getBytes());
				
				result = Base64.getEncoder().encodeToString(bytes);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return result;
		}


		public static String getSalt() {
			String result = "";
			SecureRandom rd = new SecureRandom();
			byte[] salt = new byte[16];
			rd.nextBytes(salt);
			result = Base64.getEncoder().encodeToString(salt);
			return result;
		}


		public static boolean isPasswordOk(String storedSalasana, String hashsalasana, String storedSalt) {
			// TODO Auto-generated method stub
			if ( storedSalasana.equals(getPasswordHashed(hashsalasana, storedSalt))) {
				return true;
			}
			return false;
		}


		private static Object getPasswordHashed(String hashsalasana, String storedSalt) {
			// TODO Auto-generated method stub
			return null;
		}
}