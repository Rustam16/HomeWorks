package space.exaple.homeworks.lesson1.ui;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import space.exaple.homeworks.lesson1.domain.Card;
import space.exaple.homeworks.lesson1.domain.Game;

public class EmojiGame {
    private final Game<String> game;
    private final Context context;

    public EmojiGame(Context context) {
        this.context = context;
        List<String> cards = new ArrayList<>();
        cards.add("\uD83D\uDE00");
        cards.add("\uD83D\uDE03");
        cards.add("\uD83D\uDE04");
        game = new Game<>(cards);
    }

    public void choose(Card<String> card) {
        game.choice(card);
        if (game.isEnd()) finish();
    }

    private void finish() {
        Toast.makeText(context, "GAME IS FINISHED", Toast.LENGTH_SHORT).show();
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}
