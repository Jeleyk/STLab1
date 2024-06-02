package ru.jeleyka.testing.task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {
    private static final double EPSILON = 1e-5;
    @Test
    public void testEnvironmentInitialize() {
        Environment environment = new Environment();
        assertTrue(environment.currentStates.isEmpty());
        assertTrue(environment.entities.isEmpty());

        environment.addState(Environment.State.COLD);
        assertTrue(environment.currentStates.contains(Environment.State.COLD));
        assertFalse(environment.currentStates.contains(Environment.State.HEAT));
        assertEquals(environment.currentStates.size(), 1);
    }

    @Test
    public void testBankBehaviour() {
        Environment environment = new Environment();
        Bank bank = new Bank();

        environment.addEntity(bank);

        assertTrue(bank.children.isEmpty());

        environment.addState(Environment.State.HEAT);

        for (int i = 0; i < 1D / Bank.DAMAGE_PER_TICK; i++) {
            environment.tick();
            assertEquals(bank.condition, 1D - Bank.DAMAGE_PER_TICK * (i + 1), EPSILON);
        }

        for (int i = 0; i < 50; i++) {
            environment.tick();
            assertEquals(bank.condition, 0);
        }
    }

    @Test
    public void testStreamBehaviour() {
        Environment environment = new Environment();
        Bank bank = new Bank();

        environment.addEntity(bank);

        for (int i = 0; i < 5; i++) {
            bank.addChild(new LavaStream(i + 1));
        }

        bank.children.forEach(c -> assertInstanceOf(LavaStream.class, c));

        environment.addState(Environment.State.HEAT);

        for (int i = 0; i < LavaStream.CORNER_POSITION; i++) {
            environment.tick();
            int expectedPosition = i + 1;
            bank.children.forEach(c -> assertEquals(((LavaStream) c).position, expectedPosition));
        }

        for (int i = 0; i < 50; i++) {
            environment.tick();
            bank.children.forEach(c -> assertEquals(((LavaStream) c).position, LavaStream.CORNER_POSITION));
        }
    }
}
