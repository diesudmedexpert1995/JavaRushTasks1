package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {
    int value;

    public Tile() {
    }

    public Tile(int value) {
        this.value = value;
    }

    public boolean isEmpty(){
        return (value == 0)?true:false;
    }

    public Color getFontColor(){
       return (value < 16) ? new Color(0x776e65): new Color(0xf9f6f2);
    }

    public Color getTileColor(){
        Color tileColor = null;
        if (value == 0) tileColor = new Color(0xcdc1b4);
        else if (value == 2) tileColor = new Color(0xeee4da);
        else if (value == 4) tileColor = new Color(0xede0c8);
        else if (value == 8) tileColor = new Color(0xf2b179);
        else if (value == 16) tileColor = new Color(0xf59563);
        else if (value == 32) tileColor = new Color(0xf67c5f);
        else if (value == 64) tileColor = new Color(0xf65e3b);
        else if (value == 128) tileColor = new Color(0xedcf72);
        else if (value == 256) tileColor = new Color(0xedcc61);
        else if (value == 512) tileColor = new Color(0xedc850);
        else if (value == 1024) tileColor = new Color(0xedc53f);
        else if (value == 2048) tileColor = new Color(0xedc22e);
        else tileColor = new Color(0xff0000);
        return tileColor;
    }
}
