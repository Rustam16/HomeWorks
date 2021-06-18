package space.exaple.homeworks.lesson1.ui;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import space.exaple.homeworks.lesson1.domain.Card;
import space.exaple.homeworks.lesson1.domain.Content;
import space.exaple.homeworks.lesson1.domain.Game;

public class CustomContentGame {
    private final Game<Content> game;
    private final Context context;

    public CustomContentGame(Context context) {
        this.context = context;
        List<Content> contents = new ArrayList<>();
        contents.add(new Content(1, "card1", 15));
        contents.add(new Content(2, "card2", 14));
        contents.add(new Content(3, "card3", 13));
        game = new Game<>(contents);
    }

    public void choose(Card<Content> card) {
        game.choice(card);
        if (game.isEnd()) {
            finish();
        }
    }

    private void finish() {
        Toast.makeText(context, "GAME IS FINISHED!", Toast.LENGTH_SHORT).show();
    }

    public List<Card<Content>> getCards() {
        return game.getCards();
    }
}
