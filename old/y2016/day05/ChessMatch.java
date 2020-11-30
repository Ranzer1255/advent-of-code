package y2016.day05;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ChessMatch {
	
	static String input = "cxdnnyjw";
	static int passwordLength = 8;

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		part1();
		part2();
	}

	private static void part2() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		char[] password = new char[passwordLength];
		
		for (int i = 0; i < password.length; i++) {
			password[i]='_';
		}
		
		int tryIndex=-1;
		
		while(hasBlanks(password)){
			tryIndex++;
			String test = input+tryIndex;
//			System.out.println("try number: "+tryIndex);
			md.update(test.getBytes("UTF-8"));
			byte[] hash = md.digest();
			if(foundHash(hash)){
				String s = bytesToHex(hash);
				password=addChar(password, hash[2] & 0x0f,s.charAt(6));
			}
		}
		System.out.println("part 2: "+Arrays.toString(password));
		
	}

	private static char[] addChar(char[] password, int pos, char letter) {
		
		if(pos>= password.length) return password;
		
		if(password[pos]!='_') return password;
		
		password[pos] = letter;
		
		System.out.println(Arrays.toString(password));
		return password;
	}

	private static boolean hasBlanks(char[] password) {
		for (int i = 0; i < password.length; i++) {
			if (password[i]=='_'){
				return true;
			}
		}
		return false;
	}

	private static void part1() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
//		boolean found = false;
		StringBuilder sb = new StringBuilder(passwordLength);
		
		int tryIndex=-1;
		
		while(sb.length()<passwordLength){
			tryIndex++;
			String test = input+tryIndex;
//			System.out.println("try number: "+tryIndex);
			md.update(test.getBytes("UTF-8"));
			byte[] hash = md.digest();
			if(foundHash(hash)){
				sb.append(bytesToHex(hash).charAt(5));
			}
//			found=foundHash(hash);
		}
		System.out.println("part 1: "+sb);
	}

	private static boolean foundHash(byte[] hash) {
		boolean rtn = false;

		if(hash[0]==0&&hash[1]==0){
			if(hash[2]>>>4 == 0){
				rtn = true;				
			}
		}
		return rtn;
	}
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for ( int j = 0; j < bytes.length; j++ ) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

}
