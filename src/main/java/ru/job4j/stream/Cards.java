package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Cards {
    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public class Card {
        private Suit suit;
        private Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }

        @Override
        public String toString() {
            return suit.toString() + " " + value.toString();
        }
    }

    public static void main(String[] args) {
        Cards cards = new Cards();
        List<Card> cardsList = cards.cardList();
        cardsList.forEach(System.out::println);
    }

    public List<Card> cardList() {
        return  Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value))).collect(Collectors.toList());
    }
}
