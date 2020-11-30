package y2016.day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ipv7 {
	static File input = new File("C:/Users/sgman/programing/java/workspace/adventOfCode2017/src/y2016/day07/input.txt");
	
//	static String input = "abba[mnop]qrst\n"
//			+ "abcd[bddb]xyyx\n"
//			+ "abcd[efg]abba[acde]lkjh"
//			+ "aaaa[qwer]tyui\n"
//			+ "ioxxoj[asdfgh]zxcvbn\n"
//			+ "ektijwczwnlancuqfv[luqhtfgwmlilhwnk]gxgivxlnerdhbhetfz[bzczfdorrsptzikjmct]mfrsvxgxijtusmvjd[sbpnwycbrykuhsinudc]bmpikuskzlxcoidp\n"
//			+ "xtxspkgfoeuqquwnf[vivstflpbvqrhmyt]gormtabbajywcijwfbpmo[jnkgkcuhodivggiw]fdpkuzlipozqwtiwiq";
	
	static final String regex = "(.)(?!\\1)(.)(\\2)(\\1)";
	static final String invreg = "\\[[^\\]]*(.)(?!\\1)(.)(\\2)(\\1)[^\\[]*\\]";
	static final String sslreg = "(((.)(?!\\3)(.)(\\3)).*\\[[^\\]]*(\\4)(\\3)(\\4)[^\\[]*\\])|(\\[[^\\]]*(.)(?!\\10)(.)(\\10)[^\\[]*\\].*(\\11)(\\10)(\\11))";
	
	static final Pattern invtls = Pattern.compile(invreg);
	static final Pattern tls = Pattern.compile(regex);
	static final Pattern ssl = Pattern.compile(sslreg);
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc =new Scanner(input);
		List<String> tlsAddresses = new ArrayList<>();
		List<String> sslAddresses = new ArrayList<>();
		
		
		while(sc.hasNextLine()){
			String address = sc.nextLine();
			
			Matcher validMatch = tls.matcher(address);
			Matcher invaldMatch = invtls.matcher(address);
			Matcher sslMatch = ssl.matcher(address);
			
			if (validMatch.find()&&!invaldMatch.find()){
				tlsAddresses.add(address);
			}
			
			if (sslMatch.find()){
				sslAddresses.add(address);
			}
			
			
		}
		System.out.println("tls: "+tlsAddresses.size());
		System.out.println("ssl: "+sslAddresses.size());
	}
}
