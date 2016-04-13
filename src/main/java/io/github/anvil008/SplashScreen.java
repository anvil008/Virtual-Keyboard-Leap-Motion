//package io.github.anvil008;
//
///**
// * Created by Anvil on 1-Mar-16.
// */
//
//import javafx.animation.FadeTransition;
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Rectangle2D;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.ProgressBar;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.scene.web.WebView;
//import javafx.stage.Screen;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//import javafx.util.Duration;
//import org.w3c.dom.Document;
//
//
//public class SplashScreen extends Application {
//    private Pane splashLayout;
//    private ProgressBar loadProgress;
//    private Label progressText;
//    private WebView webView;
//    private Stage mainStage;
//    private static final int SPLASH_WIDTH = 620;
//    private static final int SPLASH_HEIGHT = 300;
//
//    public static void main(String[] args) throws Exception { launch(args); }
//
//    @Override public void init() {
//        ImageView splash = new ImageView(new Image("http://anvil008.github.io/splashscreen.png"));
//        loadProgress = new ProgressBar();
//        loadProgress.setPrefWidth(SPLASH_WIDTH);
//        progressText = new Label("Preparing Demonstration . . .");
//        splashLayout = new VBox();
//        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
//    }
//
//    @Override public void start(final Stage initStage) throws Exception {
//        showSplash(initStage);
//        showMainStage();
//
//        webView.getEngine().documentProperty().addListener(new ChangeListener<Document>() {
//            @Override public void changed(ObservableValue<? extends Document> observableValue, Document document, Document document1) {
//                if (initStage.isShowing()) {
//                    loadProgress.progressProperty().unbind();
//                    loadProgress.setProgress(1);
//                    progressText.setText("All hobbits are full.");
//                    mainStage.setIconified(false);
//                    initStage.toFront();
//                    FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), splashLayout);
//                    fadeSplash.setFromValue(1.0);
//                    fadeSplash.setToValue(0.0);
//                    fadeSplash.setOnFinished(new EventHandler<ActionEvent>() {
//                        @Override public void handle(ActionEvent actionEvent) {
//                            initStage.hide();
//                        }
//                    });
//                    fadeSplash.play();
//                }
//            }
//        });
//    }
//
//
//    private void showMainStage() {
//        mainStage = new Stage(StageStyle.DECORATED);
//        mainStage.setTitle("FX Experience");
//        mainStage.setIconified(true);
//
//        // create a WebView.
//        webView = new WebView();
//        webView.getEngine().load("http://fxexperience.com/");
//        loadProgress.progressProperty().bind(webView.getEngine().getLoadWorker().workDoneProperty().divide(100));
//
//        // layout the scene.
//        Scene scene = new Scene(webView, 1000, 600);
//        webView.prefWidthProperty().bind(scene.widthProperty());
//        webView.prefHeightProperty().bind(scene.heightProperty());
//        mainStage.setScene(scene);
//        mainStage.show();
//    }
//
//    private void showSplash(Stage initStage) {
//        Scene splashScene = new Scene(splashLayout);
//        initStage.initStyle(StageStyle.UNDECORATED);
//        final Rectangle2D bounds = Screen.getPrimary().getBounds();
//        initStage.setScene(splashScene);
//        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
//        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
//        initStage.show();

//    }
//}





