package old.y2019.common;

import java.io.File;

public interface Memory {

	void set(long Address,long value);

	long recall(long Address);

	void initMemory(File program);
}
