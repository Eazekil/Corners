package com.nokhrin.corners.classical.model.update;

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
