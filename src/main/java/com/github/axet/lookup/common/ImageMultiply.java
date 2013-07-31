package com.github.axet.lookup.common;

public class ImageMultiply extends SArray {

    ImageZeroMean m;
    int xx;
    int yy;

    public ImageMultiply() {
    }

    public ImageMultiply(ImageZeroMean s1, ImageZeroMean s2) {
        this(s1, 0, 0, s2);
    }

    public ImageMultiply(ImageZeroMean image, int xx, int yy, ImageZeroMean template) {
        init(image, xx, yy, template);

        for (int x = 0; x < cx; x++) {
            for (int y = 0; y < cy; y++) {
                step(x, y);
            }
        }
    }

    public void init(ImageZeroMean image, int xx, int yy, ImageZeroMean template) {
        super.init(template);

        this.m = image;
        this.xx = xx;
        this.yy = yy;
    }

    public void step(int x, int y) {
        s[i(x, y)] = m.s(xx + x, yy + y) * base.s(x, y);
    }
}
