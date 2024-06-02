package ru.jeleyka.testing.task3;

public class LavaStream extends Entity {
    public static final int CORNER_POSITION = 4;
    int position = 0;

    public LavaStream(int num) {
        super("lava stream #" + num);
    }

    @Override
    public void processImpact(Environment.State state) {
        super.processImpact(state);
        if (state == Environment.State.HEAT) {
            if (isAwaitTheEnd()) {
                say("I'm await the end!!!");
            } else {
                ++position;
            }
        }
    }

    public boolean isAwaitTheEnd() {
        return position == CORNER_POSITION;
    }

}
