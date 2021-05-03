package com.nokhrin.corners.levels.view;

public class ButtonLevel {
    private int numberLevel;
    private int countStars;

    public ButtonLevel(int numberLevel, int countStars) {
        this.numberLevel = numberLevel;
        this.countStars = countStars;
    }

    public int getNumberLevel() {
        return numberLevel;
    }

    public void setNumberLevel(int numberLevel) {
        this.numberLevel = numberLevel;
    }

    public int getCountStars() {
        return countStars;
    }

    public void setCountStars(int countStars) {
        this.countStars = countStars;
    }
}
