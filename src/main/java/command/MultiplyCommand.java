package command;

public class MultiplyCommand implements Command {

    private int a;
    private int b;

    public MultiplyCommand(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer execute() {
        return a * b;
    }
}
