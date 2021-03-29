package com.nokhrin.corners.classical.view;

import com.nokhrin.corners.draw.DrawView;

public class UpdateView {
    private DrawView drawView;

    public void setDrawView(DrawView drawView) {
        this.drawView = drawView;
    }

    public void updateDrawView(){
        drawView.invalidate();
    }
}
