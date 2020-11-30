package net.ranzer.aoc.y2015.day04;

import net.ranzer.aoc.framework.Day;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day04 extends Day {
	
	static String input = "yzbqklnj";

	private static boolean foundHash(byte[] hash,int leadingZeros) {

		for (int i = 0; i < leadingZeros; i++) {
			byte test = hash[i/2];

			if(i%2==0){
				//look at upper nibble
				if (((test >>> 4) & 0x0F) != 0) return false;
			} else {
				if ((test & 0x0F) != 0) return false;
			}

		}
		return true;
	}

	@Override
	public void part1() {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		boolean found = false;
		int tryIndex=-1;

		while(!found){
			tryIndex++;
			String test = input+tryIndex;
			System.out.println("try number: "+tryIndex);
			md.update(test.getBytes(StandardCharsets.UTF_8));
			byte[] hash = md.digest();
			System.out.println(bytesToHex(hash));
			found=foundHash(hash,5);
		}
		System.out.println(tryIndex);
	}

	@Override
	public void part2() {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		boolean found = false;
		int tryIndex=-1;

		while(!found){
			tryIndex++;
			String test = input+tryIndex;
			System.out.println("try number: "+tryIndex);
			md.update(test.getBytes(StandardCharsets.UTF_8));
			byte[] hash = md.digest();
			found=foundHash(hash,6);
		}
		System.out.println(tryIndex);
	}

	private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
	public static String bytesToHex(byte[] bytes) {
		byte[] hexChars = new byte[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars, StandardCharsets.UTF_8);
	}
}
