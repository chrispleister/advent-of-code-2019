import java.io.File

fun main() {
    val initialMemory = File("input/day2.txt")
                                    .readLines()[0]
                                    .split(",")
                                    .map { it.toInt() };
    for (i in 0..99){
        for(j in 0..99){
            var workingMemory = initialMemory.toMutableList();
            workingMemory[1] = i;
            workingMemory[2] = j;

            workingMemory = runComputer(workingMemory);
            if (workingMemory[0] == 19690720) {
                println("Found correct input vars: Noun ${workingMemory[1]} and Verb ${workingMemory[2]}.");
            }
        }
    }
}

fun runComputer(memory: MutableList<Int>): MutableList<Int> {
    var _memory = memory;
    for (instructionPointer in _memory.indices step 4) {
        if (_memory[instructionPointer] == 99) break;
        _memory = runInstruction(_memory, instructionPointer);
    }
    return _memory;
}

fun runInstruction(memory: MutableList<Int>, instructionPointer: Int): MutableList<Int> {
    val instruction = memory[instructionPointer];
    val nounAddress = memory[instructionPointer + 1];
    val verbAddress = memory[instructionPointer + 2];
    val outputAddress = memory[instructionPointer + 3];
    memory[outputAddress] = when (instruction) {
        1 -> memory[nounAddress].plus(memory[verbAddress])
        2 -> memory[nounAddress].times(memory[verbAddress])
        99 -> return memory;
        else -> throw Exception("Unknown op code $instruction")
    };
    return memory;
}
