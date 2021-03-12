package com.nokhrin.corners.multiplayer.game;

public class StepOn {
    private int startI;
    private int startJ;
    private int endI;
    private int endJ;

    //this necessarily for database
    public StepOn() {

    }

    public int getStartI() {
        return startI;
    }

    public void setStartI(int startI) {
        this.startI = startI;
    }

    public int getStartJ() {
        return startJ;
    }

    public void setStartJ(int startJ) {
        this.startJ = startJ;
    }

    public int getEndI() {
        return endI;
    }

    public void setEndI(int endI) {
        this.endI = endI;
    }

    public int getEndJ() {
        return endJ;
    }

    public void setEndJ(int endJ) {
        this.endJ = endJ;
    }
}
