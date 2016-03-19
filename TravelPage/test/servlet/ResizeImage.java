package servlet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 3/17/2016
 * Time: 12:28 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
public class ResizeImage {

    public static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }

    public static void resize(String inputImagePath,
                              String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }

    public static void resize(String inputImagePath,
                              String outputImagePath, int width) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        double percent = inputImage.getWidth()/width;
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, width, scaledHeight);
    }

//    public static void main(String[] args) {
//        String inputImagePath = "D:/Upload/test.jpg";
//        String outputImagePath1 = "D:/Upload/test_Fixed.jpg";
//        String outputImagePath2 = "D:/Upload/test_Smaller.jpg";
//        String outputImagePath3 = "D:/Upload/test_Bigger.jpg";
//        try {
////            resize to a fixed width (not proportional)
//            int scaledWidth = 600;
//            int scaledHeight = 768;
//            ResizeImage.resize(inputImagePath, outputImagePath1, scaledWidth);
//            // resize smaller by 50%
//            double percent = 0.5;
//            ResizeImage.resize(inputImagePath, outputImagePath2, percent);
//            // resize bigger by 50%
//            percent = 1.5;
//            ResizeImage.resize(inputImagePath, outputImagePath3, percent);
//
//        } catch (IOException ex) {
//            System.out.println("Error resizing the image.");
//            ex.printStackTrace();
//        }
//    }
}
