package ru.jeleyka.testing.task3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Entity {
    protected final String name;
    protected double condition = 1D;
    protected final Set<Entity> children = new HashSet<>();

    public Entity(String name) {
        this.name = name;
    }
    public void addChild(Entity entity) {
        children.add(entity);
    }

    public void damage(double damage) {
        condition -= damage;
        condition = Math.max(0, condition);
    }

    public void processImpact(Environment.State state) {
        children.forEach(c -> c.processImpact(state));
        if (state == Environment.State.BOMBING && ThreadLocalRandom.current().nextInt(4) == 0) {
            say("ouch!");
        }
    }

    public void say(String message) {
        System.out.println(name + ": " + message);
    }

}
