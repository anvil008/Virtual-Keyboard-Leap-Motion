package io.github.anvil008;


import io.github.anvil008.keyboard.control.DefaultLayer;
import io.github.anvil008.keyboard.control.KeyBoardPopup;
import io.github.anvil008.keyboard.control.KeyboardPane;
import io.github.anvil008.keyboard.control.KeyboardType;
import io.github.anvil008.keyboard.robot.NativeAsciiRobotHandler;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;

public class Keyboard extends Application {

    private static final int SPLASH_WIDTH = 620;
    private static final int SPLASH_HEIGHT = 300;
    private int posX = 0;
    private int posY = 0;
    private Pane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        ImageView splash = new ImageView(new Image("http://anvil008.github.io/splashscreen.png"));
        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(SPLASH_WIDTH);
        progressText = new Label("Preparing Demonstration . . .");
        splashLayout = new VBox();
        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
    }

    private void showSplash(Stage initStage) {
        Scene splashScene = new Scene(splashLayout);
        initStage.initStyle(StageStyle.UNDECORATED);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
        initStage.show();
    }

    @Override
    public void start(Stage stage) {

        // 	showSplash(stage);

        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);

        KeyboardPane kb = new KeyboardPane();
        kb.setLayer(DefaultLayer.KEYBOARDPANE);
        kb.addRobotHandler(new NativeAsciiRobotHandler());
        kb.setOnKeyboardCloseButton(e -> System.exit(0));
        kb.setScale(2);
        try {
            kb.load();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }



        KeyBoardPopup popup = new KeyBoardPopup(kb);
        popup.setX(400);
        popup.setY(700);

        Scene scene = new Scene(new Group(), 0.1, 0.1);
        stage.setScene(scene);
        stage.show();

        popup.registerScene(scene);
        popup.setVisible(true);
        // popup.show(stage);

    }


    private Locale parseLocale(String l) throws Exception {
        if (l == null || l.isEmpty()) {
            throw new ParseException("invalid locale", 0);
        }
        String[] lang = l.split("_");
        if (lang.length == 2) {
            return new Locale(lang[0], lang[1]);
        }
        return Locale.forLanguageTag(l);
    }

    private void parsePosition(String p) throws Exception {
        if (p == null || p.isEmpty()) {
            throw new Exception("invalid position: " + String.valueOf(p));
        }

        String[] pos = p.split(",");
        if (pos.length == 2) {
            posX = Integer.valueOf(pos[0]);
            posY = Integer.valueOf(pos[1]);
        }
    }

}
