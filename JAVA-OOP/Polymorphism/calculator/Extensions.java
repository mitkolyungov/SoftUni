package calculator;

import java.util.Deque;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine,Deque<Integer> memory) {
        return new InputInterpreter (engine,memory);
    }
}
