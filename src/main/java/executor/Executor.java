package executor;

public interface Executor {

    int analyzeOperation(String operation);

    int executeOperation(int currentNumber, String operation);
}
