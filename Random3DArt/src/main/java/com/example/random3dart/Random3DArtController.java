package com.example.random3dart;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.security.SecureRandom;

public class Random3DArtController {
    @FXML private Pane pane;
    private SecureRandom random = new SecureRandom();
    private int n;
    private int[] dx;
    private int[] dy;
    private int[] dz;
    private int[] dz_pos;
    private int[] rads;
    private int[][] box_dim;
    private int[][] cyl_dim;
    private int time;

    public void initialize() {
        n = 20;
        dx = new int[n];
        dy = new int[n];
        dz = new int[n];
        dz_pos = new int [n];
        rads = new int[n];
        box_dim = new int[n][2];
        cyl_dim = new int [n][2];
        for (int i = 0; i < n; i++) {
            int type = random.nextInt(3);
            dx[i] = random.nextInt(2) == 1 ? 1 : -1;
            dy[i] = random.nextInt(2) == 1 ? 1 : -1;
            dz[i] = random.nextInt(2) == 1 ? 1 : -1;
            dz_pos[i] = random.nextInt(250) + 50;
            if (type == 0) {
                rads[i] = 40 + random.nextInt(50);
                Sphere sphere = new Sphere();
                sphere.setRadius(((double) dz_pos[i] / 800 + .3) * rads[i]);
                sphere.setLayoutX(10 + random.nextInt(500));
                sphere.setLayoutY(10 + random.nextInt(500));
                PhongMaterial sphereMaterial = new PhongMaterial();
                sphereMaterial.setDiffuseColor(randomColor());
                sphereMaterial.setSpecularColor(randomColor());
                sphereMaterial.setSpecularPower(random.nextInt(100) + 10);
                sphere.setMaterial(sphereMaterial);
                pane.getChildren().add(sphere);
            } else if (type == 1) {
                box_dim[i][0] = 50 + random.nextInt(150);
                box_dim[i][1] = 50 + random.nextInt(150);
                Box box = new Box();
                box.setLayoutX(random.nextInt(500));
                box.setLayoutY(random.nextInt(500));
                box.setDepth(10 + random.nextInt(150));
                box.setWidth(((double) dz_pos[i] / 400 + .3) * box_dim[i][0]);
                box.setHeight(((double) dz_pos[i] / 400 + .3) * box_dim[i][1]);
                Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
                Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
                Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
                rxBox.setAngle(random.nextInt(360));
                ryBox.setAngle(random.nextInt(360));
                rzBox.setAngle(random.nextInt(360));
                box.getTransforms().addAll(rxBox, ryBox, rzBox);
                PhongMaterial boxMaterial = new PhongMaterial();
                boxMaterial.setDiffuseColor(randomColor());
                box.setMaterial(boxMaterial);
                pane.getChildren().add(box);
            } else {
                cyl_dim[i][0] = 30 + random.nextInt(60);
                cyl_dim[i][1] = 30 + random.nextInt(60);
                Cylinder cylinder = new Cylinder();
                cylinder.setLayoutX(random.nextInt(500));
                cylinder.setLayoutY(random.nextInt(500));
                cylinder.setHeight(((double) dz_pos[i] / 400 + .3) * cyl_dim[i][0]);
                cylinder.setRadius(((double) dz_pos[i] / 400 + .3) * cyl_dim[i][1]);
                Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
                Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
                Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
                rxBox.setAngle(random.nextInt(360));
                ryBox.setAngle(random.nextInt(360));
                rzBox.setAngle(random.nextInt(360));
                cylinder.getTransforms().addAll(rxBox, ryBox, rzBox);
                PhongMaterial cylinderMaterial = new PhongMaterial();
                cylinderMaterial.setDiffuseColor(randomColor());
                cylinder.setMaterial(cylinderMaterial);
                pane.getChildren().add(cylinder);
            }
            Timeline timelineAnimation = new Timeline(
                    new KeyFrame(Duration.millis(10), e -> run())
            );
            timelineAnimation.setCycleCount(Timeline.INDEFINITE);
            timelineAnimation.play();
        }
    }
    private void run() {
        time += 10;
        time = time == 1000000000  ? 0 : time;
        if (time % 100 == 0) {
            for (int i = 0; i < n; i++) {
                if (pane.getChildren().get(i).getClass() == Sphere.class) {
                    Sphere s = (Sphere) pane.getChildren().get(i);
                    s.setLayoutX(s.getLayoutX() + (dx[i]));
                    s.setLayoutY(s.getLayoutY() + (dy[i]));
                    if (s.getLayoutX() + s.getRadius() > pane.getWidth() || s.getLayoutX() < 0) dx[i] = -dx[i];
                    if (s.getLayoutY() + s.getRadius() > pane.getHeight() || s.getLayoutY() < 0) dy[i] = -dy[i];
                    s.setRadius(((double) dz_pos[i] / 800 + .3) * rads[i]);
                } else if (pane.getChildren().get(i).getClass() == Box.class) {
                    Box s = (Box) pane.getChildren().get(i);
                    s.setLayoutX(s.getLayoutX() + dx[i]);
                    s.setLayoutY(s.getLayoutY() + dy[i]);
                    if (s.getLayoutX() + s.getWidth() > pane.getWidth() || s.getLayoutX() < 0) dx[i] = -dx[i];
                    if (s.getLayoutY() + s.getHeight() > pane.getHeight() || s.getLayoutY() < 0) dy[i] = -dy[i];
                    Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
                    Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
                    Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
                    rxBox.setAngle(s.getTranslateX() + 1);
                    ryBox.setAngle(s.getTranslateY() + 1);
                    rzBox.setAngle(s.getTranslateZ() + 1);
                    s.getTransforms().addAll(rxBox, ryBox, rzBox);
                    s.setWidth(((double) dz_pos[i] / 400 + .3) * box_dim[i][0]);
                    s.setHeight(((double) dz_pos[i] / 400 + .3) * box_dim[i][1]);
                } else if (pane.getChildren().get(i).getClass() == Cylinder.class){
                    Cylinder s = (Cylinder) pane.getChildren().get(i);
                    s.setLayoutX(s.getLayoutX() + dx[i]);
                    s.setLayoutY(s.getLayoutY() + dy[i]);
                    if (s.getLayoutX() + s.getRadius() > pane.getWidth() || s.getLayoutX() < 0) dx[i] = -dx[i];
                    if (s.getLayoutY() + s.getHeight() > pane.getHeight() || s.getLayoutY() < 0) dy[i] = -dy[i];
                    Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
                    Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
                    Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
                    rxBox.setAngle(s.getTranslateX() + 1);
                    ryBox.setAngle(s.getTranslateY() + 1);
                    rzBox.setAngle(s.getTranslateZ() + 1);
                    s.getTransforms().addAll(rxBox, ryBox, rzBox);
                    s.setHeight(((double) dz_pos[i] / 400 + .3) * cyl_dim[i][0]);
                    s.setRadius(((double) dz_pos[i] / 400 + .3) * cyl_dim[i][1]);
                }
                dz_pos[i] += dz[i];
                if (dz_pos[i] > 400 || dz_pos[i] < 0) dz[i] = -dz[i];
            }
        }

    }
    private Color randomColor(){
        return Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256),
                .4 + (double) random.nextInt(50) / 100);
    }
}