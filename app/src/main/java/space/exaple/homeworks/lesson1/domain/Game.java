package space.exaple.homeworks.lesson1.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();
    private boolean end = false;

    public Game(List<CardContent> cardContents) {
        for (int i = 0; i < cardContents.size(); i++) {
            cards.add(new Card<>(i * 2, false, false, cardContents.get(i)));
            cards.add(new Card<>((i * 2) + 1, false, false, cardContents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choice(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        checkPairs(card);
        finish();
    }

    private void finish() {
        if (cards.isEmpty())
            setEnd(true);
    }

    private void checkPairs(Card<CardContent> card) {
        for (int i = 0; i < cards.size(); i++) {
            if (card.isFaceUp() && cards.get(i).isFaceUp()
                    && cards.get(i).getId() != card.getId()
                    && card.equals(cards.get(i))) {
                Log.d("tag", "true choose");
                card.setMatched(true);
                cards.get(i).setMatched(true);
                removeCardInYourPosition();
            } else if (card.isFaceUp() && cards.get(i).isFaceUp()
                    && card.getId() != card.getId()
                    && card.equals(cards.get(i))) {
                card.setFaceUp(false);
                cards.get(i).setFaceUp(false);
                Log.d("tag", "wrong Choose!!");
            }
        }
    }

    private void removeCardInYourPosition() {
        List<Card<CardContent>> cardArrayList = new ArrayList<>(cards);
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isMatched()) cardArrayList.remove(cards.get(i));
        }
        cards.clear();
        cards.addAll(cardArrayList);
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
