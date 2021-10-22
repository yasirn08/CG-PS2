package com.example.dynamicartcanvas;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.security.SecureRandom;

public class DynamicArtCanvasController {
    @FXML Pane pane;
    private SecureRandom random = new SecureRandom();
    private int n;
    private int[] dx;
    private int[] dy;
    public void initialize() {
        n = random.nextInt(50) + 10;
        dx = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            Circle circle = new Circle();
            circle.setCenterX(random.nextInt(500) + 201);
            circle.setCenterY(random.nextInt(300) + 201);
            circle.setRadius(random.nextInt(100));
            circle.setFill(randomColor());
            circle.setStrokeWidth(random.nextInt(20));
            circle.setStroke(randomColor());
            pane.getChildren().add(circle);
            dx[i] = 1 + random.nextInt(5);
            dy[i] = 1 + random.nextInt(5);
        }
        Timeline timelineAnimation = new Timeline(
                new KeyFrame(Duration.millis(10), e -> moveCircles())
        );
        timelineAnimation.setCycleCount(Timeline.INDEFINITE);
        timelineAnimation.play();
    }

    private void moveCircles() {
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Circle c = (Circle) pane.getChildren().get(i);
            c.setCenterX(c.getCenterX() + dx[i]);
            c.setCenterY(c.getCenterY() + dy[i]);
            if (c.getCenterX() + c.getRadius() > pane.getWidth() || c.getCenterX() - c.getRadius() < 0) dx[i] = -dx[i];
            if (c.getCenterY() + c.getRadius() > pane.getHeight() || c.getCenterY() - c.getRadius() < 0) dy[i] = -dy[i];
        }
    }
    private Color randomColor(){
        return Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256),
                (double) random.nextInt(101) / 100);
    }
}