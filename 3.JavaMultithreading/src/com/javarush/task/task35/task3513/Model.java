package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int maxTile = 0;
    int score = 0;
    private boolean isSaveNeeded = true;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();

    public Tile[][] getGameTiles() {
        return gameTiles;
    }


    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()){
            int index = (int)(Math.random()*emptyTiles.size())%emptyTiles.size();
            Tile currentEmptyTile = emptyTiles.get(index);
            currentEmptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> tileList = new ArrayList<Tile>();
        for (Tile[] currentTileArray: gameTiles) {
            for (Tile currentTile: currentTileArray) {
                if (currentTile.isEmpty()){
                    tileList.add(currentTile);
                }
            }
        }
        return tileList;
    }

    private boolean compressTiles(Tile[] tiles){
        int insertPosition = 0;
        boolean isTilesCompressed = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!tiles[i].isEmpty()){
                if (i != insertPosition){
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                    isTilesCompressed = true;
                }
                insertPosition++;
            }
        }
        return isTilesCompressed;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean isTilesHasMerged = false;
        LinkedList<Tile> tilesList = new LinkedList<>();
        for (int i = 0; i < FIELD_WIDTH; i++){
            if (tiles[i].isEmpty()){
                continue;
            }
            if (i < FIELD_WIDTH - 1 && tiles[i].value == tiles[i+1].value){
                int updateValue = tiles[i].value * 2;
                if (updateValue > maxTile) maxTile = updateValue;
                score+=updateValue;
                tilesList.addLast(new Tile(updateValue));
                tiles[i+1].value = 0;
                isTilesHasMerged = true;
            }
            else{
                tilesList.addLast(new Tile(tiles[i].value));
            }
            tiles[i] .value = 0;
        }

        for (int i = 0; i < tilesList.size(); i++) {
            tiles[i] = tilesList.get(i);
        }
        return isTilesHasMerged;
    }

    private Tile[][] rotateClockwise(Tile[][] tiles){
        final int N = tiles.length;
        Tile[][] result = new Tile[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[j][N-1-i] = tiles[i][j];
            }
        }
        return result;
    }

    public void left(){
        if (isSaveNeeded == true) saveState(gameTiles);
        boolean moveFlag = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i])| mergeTiles(gameTiles[i])){
               moveFlag = true ;
            }
        }
        if (moveFlag){
            addTile();
        }
        isSaveNeeded = true;
    }

    public void right(){
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    public void up(){
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
    }

    public void down(){
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    public boolean canMove(){
        if (!isFull()){
            return true;
        }

        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                Tile t = gameTiles[x][y];
                if ((x < FIELD_WIDTH - 1 && t.value == gameTiles[x + 1][y].value)
                        || ((y < FIELD_WIDTH - 1) && t.value == gameTiles[x][y + 1].value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;

    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()){
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    private boolean isFull() {
        return getEmptyTilesCount() == 0;
    }
    private int getEmptyTilesCount(){
        return getEmptyTiles().size();
    }

    public void randomMove(){
        int n =((int) (Math.random() * 100)) % 4;
        switch(n){
            case 0:
                left();
            break;
            case 1:
                right();
            break;
            case 2:
                up();
            break;
            case 3:
                down();
            break;
        }
    }

    private boolean hasBoardChanged(){
        boolean rez = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (previousStates.peek()[i][j].value != gameTiles[i][j].value){
                    rez = true;
                }
            }
        }
        return rez;
    }

    private MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency efficiency = new MoveEfficiency(-1,0, move);
        move.move();
        if (hasBoardChanged()){
            efficiency = new MoveEfficiency(getEmptyTilesCount(),score,move);
        }
        rollback();
        return efficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> moveEfficiencyPriorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        moveEfficiencyPriorityQueue.offer(getMoveEfficiency(this::left));
        moveEfficiencyPriorityQueue.offer(getMoveEfficiency(this::right));
        moveEfficiencyPriorityQueue.offer(getMoveEfficiency(this::up));
        moveEfficiencyPriorityQueue.offer(getMoveEfficiency(this::down));
        moveEfficiencyPriorityQueue.peek().getMove().move();
    }

}
