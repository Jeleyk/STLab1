package ru.jeleyka.testing.task3;

import java.util.concurrent.ThreadLocalRandom;

public class Stream extends Entity {
    public Stream(String name) {
        super(name);
    }

    @Override
    public void processImpact(Environment.State state) {
        super.processImpact(state);
        if (state == Environment.State.COLD && ThreadLocalRandom.current().nextBoolean()) {
            say("brrr");
        }
    }
}
