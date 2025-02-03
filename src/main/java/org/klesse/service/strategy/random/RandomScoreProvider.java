package org.klesse.service.strategy.random;

import org.klesse.service.strategy.interfaces.ScoreProvider;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomScoreProvider implements ScoreProvider {

    @Override
    public int getScore() {
        return new Random().nextInt(0, 1000);
    }
}
