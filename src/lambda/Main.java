package lambda;

// An interface with one function is known as a functional interface
interface Executable{
    void execute();
}

interface Executable2{
    int execute();
}

interface Executable3{
    int execute(int a);
}

interface Executable4{
    int execute(int a, int b);
}


class Runner{
    public void run(Executable e){
        System.out.println("Executing code block");
        e.execute();
    }

    public void run2(Executable2 e){
        System.out.println("Runner.run2");
        int value = e.execute();
        System.out.println("Return value is " + value );
    }

    public void run3(Executable3 e){
        System.out.println("Runner.run3");
        int value = e.execute(12);
        System.out.println("Return value is " + value);
    }

    public void run4(Executable4 e){
        System.out.println("Runner.run4");
        System.out.println("Return value is " + e.execute(2,4));
    }
}

public class Main {
    public static void main(String[] args){
        System.out.println("Non lambda way:\n");
        Runner runner = new Runner();
        runner.run(new Executable() {
            @Override
            public void execute() {
                System.out.println("Hello there");
            }
        });

        System.out.println("=====================");
        runner.run(() -> System.out.println("Hello there."));

        // We can have multiple expressions in the code block we pass
        runner.run(() -> {
            System.out.println("This is code passed in a lambda expression");
            System.out.println("Hello there");
        });

        // We might want the code block to have a return type
        runner.run2(() -> {
            System.out.println("This is code passed in a lambda expression");
            System.out.println("Hello there");
            return 8; // This is required since Executable2.execute has a return type
        });

        // We might want the code block to have a return type
        runner.run2(() -> 8); // Shorthand for return 8

        // The interface might have parameters
        runner.run3((int a) -> (a*2));

        // The interface can have multiple parameters
        runner.run4((int a, int b) -> {
            System.out.println("The parameters are " + a + "," + b);
            return(a*b);
        });

        // One can assign the lambda expression to a variable as well
        Executable4 ex = (int a, int b) -> {
            System.out.println("The parameters are " + a + "," + b);
            return(a*b);
        };

        runner.run4(ex);

    }
}
