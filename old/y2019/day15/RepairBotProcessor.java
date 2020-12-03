package y2019.day15;

import y2019.common.IntcodeComputer;

import java.io.File;

class RepairBotProcessor {
	private static File program =  new File("./src/y2019/day15/input");

	private IntcodeComputer ic = new IntcodeComputer(program);

	Response move(Direction d){

		ic.addInput(d.code);
		ic.run();
		return Response.get(ic.getOut().remove().intValue());

	}

}
