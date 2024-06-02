package ru.jeleyka.testing.task3;

public class Bank extends Entity {
    public static final double DAMAGE_PER_TICK = 0.2D;
    public static final double ALMOST_FELL_HEALTH = 0.3D;
    public Bank() {
        super("Computer bank");
    }

    @Override
    public void processImpact(Environment.State state) {
        super.processImpact(state);
        if (state == Environment.State.HEAT) {
            damage(DAMAGE_PER_TICK);
            if (condition <= 0) {
                say("I fell to pieces");
            } else if (condition <= ALMOST_FELL_HEALTH) {
                say("I almost fell to pieces");
            }
        }
    }
}
