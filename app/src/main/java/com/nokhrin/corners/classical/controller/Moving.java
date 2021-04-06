package com.nokhrin.corners.classical.controller;

public class Moving {
    private int touchX, touchY;
    private int touchJ, touchI;
    private int sizeOfField;
    private int widthDisplay;

    public void setTouchXY(int touchX, int touchY) {
        this.touchX = touchX;
        this.touchY = touchY;

        //convert coordinates X,Y in step on chess field
        convertCoordinate();
    }

    public void setSizeOfField(int stepOnField) {
        this.sizeOfField = stepOnField;
    }

    public void setWidthDisplay(int widthDisplay) {
        this.widthDisplay = widthDisplay;
    }

    private void convertCoordinate() {
        int stepOnField = widthDisplay / (sizeOfField - 1);
        touchI = touchY / stepOnField + 1;
        touchJ = touchX / stepOnField + 1;

        System.out.println("_______________________ " + touchI + "," + touchJ);
    }

    public int getTouchJ() {
        return touchJ;
    }

    public int getTouchI() {
        return touchI;
    }
}
