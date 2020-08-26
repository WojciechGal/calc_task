package executor;

import calculator.Calculator;
import command.AddCommand;
import command.DivideCommand;
import command.MultiplyCommand;
import command.SubtractCommand;

public class CalculationExecutor implements Executor {

    private Calculator calculator;

    public CalculationExecutor(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int analyzeOperation(String operation) {
        String[] operationArr = checkStringValidAndSplit(operation);
        if ("apply".equals(operationArr[0])) {
            return Integer.parseInt(operationArr[1]);
        } else {
            return -1;
        }
    }

    @Override
    public int executeOperation(int currentNumber, String operation) {
        String[] operationArr = checkStringValidAndSplit(operation);
        switch (operationArr[0]) {
            case "multiply":
                return this.calculator.calculate(new MultiplyCommand(currentNumber, Integer.parseInt(operationArr[1])));
            case "add":
                return this.calculator.calculate(new AddCommand(currentNumber, Integer.parseInt(operationArr[1])));
            case "divide":
                return this.calculator.calculate(new DivideCommand(currentNumber, Integer.parseInt(operationArr[1])));
            case "subtract":
                return this.calculator.calculate(new SubtractCommand(currentNumber, Integer.parseInt(operationArr[1])));
            default:
                throw new IllegalArgumentException();
        }

    }

    private static String[] checkStringValidAndSplit(String operation) {
        String[] operationArr = operation.split(" ");

        if (operationArr.length != 2) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(operationArr[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return operationArr;
    }
}
