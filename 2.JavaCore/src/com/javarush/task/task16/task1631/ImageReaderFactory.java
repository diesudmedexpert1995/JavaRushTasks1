package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader imageReader = null;
        if(type == null){
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        if (type.name().equals("JPG")){
            imageReader = new JpgReader();
        } else if (type.name().equals("BMP")){
            imageReader = new BmpReader();
        } else if (type.name().equals("PNG")){
            imageReader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        return imageReader;
    }
}
