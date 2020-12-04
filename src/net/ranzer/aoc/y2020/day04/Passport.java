package net.ranzer.aoc.y2020.day04;

import java.util.HashMap;
import java.util.Map;

public class Passport {

	private Map<Key,String> data = new HashMap<>();

	public Passport(){

	}

	public Boolean isPartOneValid(){
		return ( data.get(Key.BYR)!=null &&
				 data.get(Key.IYR)!=null &&
				 data.get(Key.EYR)!=null &&
				 data.get(Key.HGT)!=null &&
				 data.get(Key.HCL)!=null &&
				 data.get(Key.ECL)!=null &&
				 data.get(Key.PID)!=null
				); //will return if all required data points are != null
	}

	public Boolean isPartTwoValid(){
		return (byrValid() &&
				iyrValid() &&
				eyrValid() &&
				hgtValid() &&
				hclValid() &&
				eclValid() &&
				pidValid() &&
				cidValid()
				);
	}

	private Boolean byrValid() {
		if(data.get(Key.BYR)==null) return false;
		int year = Integer.parseInt(data.get(Key.BYR));
		return inRange(year,1920,2002);
	}

	private boolean iyrValid(){
		if(data.get(Key.IYR)==null) return false;
		int year = Integer.parseInt(data.get(Key.IYR));
		return inRange(year,2010,2020);
	}

	private boolean eyrValid(){
		if(data.get(Key.EYR)==null) return false;
		int year = Integer.parseInt(data.get(Key.EYR));
		return  inRange(year,2020,2030);
	}

	private boolean hgtValid(){
		if(data.get(Key.HGT)==null) return false;
		String units = data.get(Key.HGT).substring(data.get(Key.HGT).length()-2);
		int number = 0;

		switch (units){
			case "cm":
				number = Integer.parseInt(data.get(Key.HGT).substring(0,data.get(Key.HGT).length()-2));
				return inRange(number,150,193);
			case "in":
				number = Integer.parseInt(data.get(Key.HGT).substring(0,data.get(Key.HGT).length()-2));
				return inRange(number,59,76);
			default:
				return false;
		}
	}

	private boolean hclValid(){

		return false;//TODO need to finsih this one
	}

	private boolean eclValid(){
		if(data.get(Key.ECL)==null) return false;
		return data.get(Key.ECL).equals("amb") ||
			   data.get(Key.ECL).equals("blu") ||
			   data.get(Key.ECL).equals("brn") ||
			   data.get(Key.ECL).equals("gry") ||
			   data.get(Key.ECL).equals("grn") ||
			   data.get(Key.ECL).equals("hzl") ||
			   data.get(Key.ECL).equals("oth");
	}

	private boolean pidValid(){
		return false; //TODO need to finish this one
	}

	private boolean cidValid(){
		return true;
	}


	private Boolean inRange(int test, int low, int high) {
		return (low <= test) && (test <= high);
	}

	public void addData(Key key, String value){
		data.put(key,value);
	}

	public enum Key{
		BYR,IYR,EYR,HGT,HCL,ECL,PID,CID;

		public static Key getKey(String key){
			switch (key){
				case "byr":
					return BYR;
				case "iyr":
					return IYR;
				case "eyr":
					return EYR;
				case "hgt":
					return HGT;
				case "hcl":
					return HCL;
				case "ecl":
					return ECL;
				case "pid":
					return PID;
				case "cid":
					return CID;
				default:
					return null;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder rtn = new StringBuilder();

		for (Key key : Key.values()){
			rtn.append(key.name()).append("=").append(data.get(key)).append("\n");
		}

		return rtn.substring(0,rtn.length()-1);
	}
}
