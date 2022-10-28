package ku.cs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
//    public static final String CURRENCY = "$";
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "Loan System",800, 600);
        configRoute();
        FXRouter.goTo("registration");
    }

    private void configRoute() {
        String packageStr = "ku/cs/";
        FXRouter.when("login", packageStr+"login.fxml");
        FXRouter.when("registration", packageStr+"registration.fxml");
        FXRouter.when("testConnectDB", packageStr+"testConnectDB.fxml");
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch();
    }

}