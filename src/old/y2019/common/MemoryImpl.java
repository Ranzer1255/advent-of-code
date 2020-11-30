package y2019.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemoryImpl implements Memory {
	private Map<Long,Long> RAM;

	@Override
	public void set(long address, long value) {
		RAM.put(address,value);
	}

	@Override
	public long recall(long address) {
		Long rtn = RAM.get(address);

		if (rtn==null) return 0L;

		return rtn;
	}

	@Override
	public void initMemory(File program) {

		try {
			RAM=new HashMap<>();
			Scanner in = new Scanner(program);
			in.useDelimiter(",");

			long i = 0;
			while (in.hasNext()){
				RAM.put(i++,in.nextLong());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
