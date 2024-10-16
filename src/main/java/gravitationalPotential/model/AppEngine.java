package gravitationalPotential.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;


public class AppEngine extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("appConfig.fxml"));
        BorderPane viewRoot = loader.load();
        configureStage(primaryStage, viewRoot);
        primaryStage.show();
    }
    private void configureStage(Stage primaryStage, BorderPane viewRoot){
        Scene scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gravitation Potential app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());

        try{
            URL location  = getClass().getClassLoader().getResource("icon.png");
            if(location != null) {
                primaryStage.getIcons().add(new Image(location.openStream()));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
