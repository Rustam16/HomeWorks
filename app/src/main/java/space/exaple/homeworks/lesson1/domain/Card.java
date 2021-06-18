package space.exaple.homeworks.lesson1.domain;

import java.util.Objects;

public class Card<CardContent> {
    private int id;
    private boolean isMatched;
    private boolean isFaceUp;
    private CardContent CardContent;

    public Card(int id, boolean isMatched, boolean isFaceUp, CardContent cardContent) {
        this.id = id;
        this.isMatched = isMatched;
        this.isFaceUp = isFaceUp;
        this.CardContent = cardContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return Objects.equals(CardContent, card.CardContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isMatched, isFaceUp, CardContent);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public CardContent getCardContent() {
        return CardContent;
    }

    public void setCardContent(CardContent cardContent) {
        CardContent = cardContent;
    }
}
