import calculator.Calculator;
import executor.CalculationExecutor;
import reader.TextFileReader;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        try {
            TaskResult result = new TaskResult.TaskBuilder().commandsExcretion(new TextFileReader(Paths.get("src/main/resources/instruction.txt"))).generateCalculationExecutor(new CalculationExecutor(new Calculator())).findApplyInstr().performPreviousInstructions().build();
            System.out.println(result.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
