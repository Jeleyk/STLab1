package ru.jeleyka.testing.task3;

import java.util.HashSet;
import java.util.Set;

public class Environment {
    protected final Set<State> currentStates = new HashSet<>();
    protected final Set<Entity> entities = new HashSet<>();
    public void tick() {
        currentStates.forEach(state ->
                entities.forEach(entity ->
                        entity.processImpact(state)
                )
        );
        System.out.println("-".repeat(30));
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void addState(State state) {
        currentStates.add(state);
    }

    public void removeState(State state) {
        currentStates.remove(state);
    }

    public enum State {
        BOMBING,
        HEAT,
        COLD,
        NOISE
    }
}
