package calculator;

import command.Command;

public class Calculator {

    public int calculate(Command command) {
        return command.execute();
    }
}
