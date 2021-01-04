package net.ranzer.aoc.y2015.day04;

import net.ranzer.aoc.framework.Day;
import net.ranzer.common.Hex;

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
//			System.out.println("try number: "+tryIndex);
			md.update(test.getBytes(StandardCharsets.UTF_8));
			byte[] hash = md.digest();
//			System.out.println(Hex.bytesToHex(hash));
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
//			System.out.println("try number: "+tryIndex);
			md.update(test.getBytes(StandardCharsets.UTF_8));
			byte[] hash = md.digest();
			found=foundHash(hash,6);
		}
		System.out.println(tryIndex);
	}

}
