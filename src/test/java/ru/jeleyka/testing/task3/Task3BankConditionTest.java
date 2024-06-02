package ru.jeleyka.testing.task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3BankConditionTest {
    private static Environment environment;
    private static Bank bank;

    @BeforeAll
    static void setupBank() {
        environment = new Environment();
        bank = new Bank();

        environment.addEntity(bank);

        assertTrue(bank.children.isEmpty());

        environment.addState(Environment.State.HEAT);

        for (int i = 0; i < 1D / Bank.DAMAGE_PER_TICK; i++) {
            environment.tick();
        }
    }

    @RepeatedTest(50)
    public void testBank() {
        environment.tick();
        assertEquals(bank.condition, 0);
    }

}
