package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles = 0;
    private int score =0;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency anotherMove) {
        if (numberOfEmptyTiles > anotherMove.numberOfEmptyTiles) {
            return 1;
        } else if (numberOfEmptyTiles < anotherMove.numberOfEmptyTiles) {
            return -1;
        } else {
            if (score > anotherMove.score) {
                return 1;
            } else if (score < anotherMove.score) {
                return -1;
            }
        }
        return 0;
    }
}
