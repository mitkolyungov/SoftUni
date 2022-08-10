package calculator;

import java.util.Deque;

public class MemorySaveOperation implements Operation {
    private Deque<Integer> memory;

    public MemorySaveOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push (operand);
    }

    @Override
    public int getResult() {
        if (isCompleted ()) {
            return getMemory ().peek ();
        }

        return 0;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    public Deque<Integer> getMemory() {
        return this.memory;
    }
}
