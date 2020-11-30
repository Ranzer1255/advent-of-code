package old.y2015.day04;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day04 {
	
	static String input = "yzbqklnj";

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		boolean found = false;
		int tryIndex=-1;
		
		while(!found){
			tryIndex++;
			String test = input+tryIndex;
			System.out.println("try number: "+tryIndex);
			md.update(test.getBytes("UTF-8"));
			byte[] hash = md.digest();
			found=foundHash(hash);
		}
		System.out.println(tryIndex);
	}

	private static boolean foundHash(byte[] hash) {
		boolean rtn = false;
		
		if(hash[0]==0&&hash[1]==0){
			if(hash[2] == 0){
				rtn = true;				
			}
		}
		return rtn;
	}
}
