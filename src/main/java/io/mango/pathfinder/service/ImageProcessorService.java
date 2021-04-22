package io.mango.pathfinder.service;

import io.mango.pathfinder.model.Image.Coordinate;
import io.mango.pathfinder.model.map.Map;
import io.mango.pathfinder.model.map.Node;
import io.mango.pathfinder.model.map.SquareMap;
import io.mango.pathfinder.model.scenario.Scenario;
import io.mango.pathfinder.web.request.ImageProcessingRequest2;
import org.springframework.stereotype.Service;


@Service
public class ImageProcessorService {

    private static final int BYTE_RANGE_OF_EIGHT_BITS = 255;
    private static final int NUMBER_OF_RGB_COLORS = 3;
    private static int minGrayScaleValue = 0;
    private static int maxGrayScaleValue = BYTE_RANGE_OF_EIGHT_BITS * NUMBER_OF_RGB_COLORS;

    public Scenario process(ImageProcessingRequest2 request) {
        Scenario scenario = new Scenario();
        scenario.setRobot(request.getRobot());
        Map map = new SquareMap(request.getWidth(), request.getHeight(), Map.FINAL_COST);
        scenario.setMap(map);

        int nodeHeight = request.getImage().getHeight() / request.getHeight();
        int nodeWidth = request.getImage().getWidth() / request.getWidth();

        for(int y = 0; y < request.getImage().getHeight(); y++) {
            for(int x = 0; x < request.getImage().getWidth(); x++) {
                Node node = new Node(x,y);
                Coordinate coordinate = new Coordinate(y,x);
                if (request.getImage().isRed(coordinate)) {
                    scenario.setStartNode(node);
                } else if (request.getImage().isGreen(coordinate)) {
                    scenario.addBlock(node);
                } else if(request.getImage().isBlue(coordinate)){
                    scenario.setEndNode(node);
                }
            }
        }
        return scenario;


    }

    public Scenario processImage(ImageProcessingRequest2 request) {
        Scenario scenario = new Scenario();

        int sampleBlockHeight = request.getImage().getHeight() / request.getHeight();
        int sampleBlockWidth = request.getImage().getWidth() / request.getWidth();

        for(int y = 0; y < sampleBlockHeight - sampleBlockHeight; y += sampleBlockHeight) {
            for(int x = 0; x < sampleBlockWidth - sampleBlockWidth; x += sampleBlockWidth) {

            }
        }

        return scenario;
    }
/*
    private void convertImageToASCIIArt() {
        int sampleBlockHeight = image.getHeight() / Y_AXIS_TRAVERSING_QUOTIENT;
        int sampleBlockWidth = image.getWidth() / X_AXIS_TRAVERSING_QUOTIENT;
        calculateGrayScaleValueRange(sampleBlockHeight, sampleBlockWidth);
        for (int y = 0; y < image.getHeight() - sampleBlockHeight; y += sampleBlockHeight) {
            for (int x = 0; x < image.getWidth() - sampleBlockWidth; x += sampleBlockWidth) {
                int sampleBlockGrayScaleValue = calculateSampleBlockGrayScaleValue(sampleBlockHeight, sampleBlockWidth, y, x);
                int averageSampleBlockGrayScaleValue = sampleBlockGrayScaleValue / sampleBlockHeight / sampleBlockWidth;
            }
            System.out.println();
        }

    }
    private void calculateGrayScaleValueRange(int sampleBlockHeight, int sampleBlockWidth) {
        for (int y = 0; y < image.getHeight(); y += sampleBlockHeight) {
            for (int x = 0; x < image.getWidth(); x += sampleBlockWidth) {
                int sampleBlockGrayScaleValue = calculateSampleBlockGrayScaleValue(sampleBlockHeight, sampleBlockWidth, y, x);
                int averageSampleBlockGrayScaleValue = sampleBlockGrayScaleValue / sampleBlockHeight / sampleBlockWidth;
                if (maxGrayScaleValue < averageSampleBlockGrayScaleValue) {
                    maxGrayScaleValue = averageSampleBlockGrayScaleValue;
                }
                if (minGrayScaleValue > averageSampleBlockGrayScaleValue) {
                    minGrayScaleValue = averageSampleBlockGrayScaleValue;
                }
            }
        }
    }
    private int calculateSampleBlockGrayScaleValue(int sampleBlockHeight, int sampleBlockWidth, int y, int x) {
        int sampleSquareGrayScaleValue = 0;
        for (int yAverage = 0; yAverage < sampleBlockHeight; yAverage++) {
            for (int xAverage = 0; xAverage < sampleBlockWidth; xAverage++) {
                sampleSquareGrayScaleValue = sampleSquareGrayScaleValue
                        + (image.getRed(new Coordinate(x, y))
                        + image.getBlue(new Coordinate(x, y))
                        + image.getGreen(new Coordinate(x, y)));
            }
        }
        return sampleSquareGrayScaleValue;
    }
*/
}
