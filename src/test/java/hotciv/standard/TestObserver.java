package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class TestObserver {
    private Game game;
    private GameObserver observer;

    @Before
    public void setUp() {
        game = new GameImpl(new AlphaCivFactory());
        observer = new GameObserverImpl();
    }

    @Test
    public void testAddObserver() {
        game.addObserver(observer);
    }
}
