package ru.jeleyka.testing.task3;

public class History {
    private final String name;

    public History(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        new History("Part #33").process();
    }

    public void process() {
        System.out.println(name);
        Environment environment = new Environment();

        Bank bank = new Bank();

        for (int i = 0; i < 5; i++) {
            bank.addChild(new LavaStream(i + 1));
        }

        environment.addEntity(bank);

        environment.addState(Environment.State.BOMBING);
        environment.addState(Environment.State.HEAT);
        environment.addState(Environment.State.NOISE);

        for (int i = 0; i < 5; i++) {
            environment.tick();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
