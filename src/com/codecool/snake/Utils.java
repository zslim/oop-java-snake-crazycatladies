package com.codecool.snake;

import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Point2D;

public class Utils {

    /*
    Converts a direction in degrees (0...360) to x and y coordinates.
    The length of this vector is the second parameter
    */
    public static Point2D directionToVector(double directionInDegrees, double length) {
        double directionInRadians = directionInDegrees / 180 * Math.PI;
        Point2D heading = new Point2D(length * Math.sin(directionInRadians), - length * Math.cos(directionInRadians));
        return heading;
    }

    public static Point2D createHeadPointer(Vec2d headPosition){
        double headX = headPosition.x;
        double headY = headPosition.y;
        Point2D headPointer = new Point2D(headX,headY);
        return headPointer;
    }

    public static boolean doesEventHappen(double probability) {
        return Math.random() > 1 - probability;
    }

    public static int getRandomWithin(int min, int max) {
        if (max < min) {
            int y = min;
            min = max;
            max = y;
        }

        return (int) Math.round(Math.random() * (max - min) + min);
    }

    public static Vec2d rotatePoint(Vec2d point, double rotation, Vec2d center) {
        Vec2d result = new Vec2d();
        double rotationInRadians = rotation * Math.PI / 180;
        double radius = getLengthOfVector(subtract(center, point));
        result.x = point.x * Math.cos(rotationInRadians) * radius;
        result.y = point.y * Math.sin(rotationInRadians) * radius;
        return result;
    }

    public static double getLengthOfVector(Vec2d vector) {
        double result = Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2));
        return result;
    }

    public static Vec2d subtract(Vec2d v1, Vec2d v2) {
        Vec2d result = new Vec2d();
        result.x = v1.x - v2.x;
        result.y = v1.y - v2.y;
        return result;
    }
}
