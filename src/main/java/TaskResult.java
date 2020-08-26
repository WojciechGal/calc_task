import executor.Executor;
import reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskResult {

    private int result = 0;

    public int getResult() {
        return result;
    }

    private void setResult(int result) {
        this.result = result;
    }

    public static class TaskBuilder {

        private TaskResult taskResult;
        private List<String> allCommands;
        private List<String> commandsToExecute;
        private Executor calculationExecutor;

        public TaskBuilder() {
            this.taskResult = new TaskResult();
        }

        public TaskBuilder commandsExcretion(Reader textFileReader) throws IOException {
            this.allCommands = textFileReader.read();
            return this;
        }

        public TaskBuilder generateCalculationExecutor(Executor calculationExecutor) {
            this.calculationExecutor = calculationExecutor;
            return this;
        }

        public TaskBuilder findApplyInstr() {
            this.commandsToExecute = new ArrayList<>();
            for (String command : this.allCommands) {
                int foundNumber = this.calculationExecutor.analyzeOperation(command);
                if (foundNumber != -1) {
                    this.taskResult.setResult(foundNumber);
                    break;
                } else {
                    this.commandsToExecute.add(command);
                }
            }
            return this;
        }

        public TaskBuilder performPreviousInstructions() {
            for (String command : this.commandsToExecute) {
                this.taskResult.setResult(this.calculationExecutor.executeOperation(this.taskResult.getResult(), command));
            }
            return this;
        }

        public TaskResult build() {
            return this.taskResult;
        }
    }
}
