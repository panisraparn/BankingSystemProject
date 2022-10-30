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
        FXRouter.goTo("login");
    }

    private void configRoute() {
        //เรียงด้วยนะ
        String packageStr = "ku/cs/";
        FXRouter.when("creditboard_home",packageStr+"creditboard_home.fxml");

        FXRouter.when("emp_document",packageStr+"emp_document.fxml");
        FXRouter.when("emp_home",packageStr+"emp_home.fxml");
        FXRouter.when("emp_invoice",packageStr+"emp_invoice.fxml");
        FXRouter.when("emp_invoice2",packageStr+"emp_invoice2.fxml");
        FXRouter.when("emp_loan",packageStr+"emp_loan.fxml");
        FXRouter.when("emp_loan2",packageStr+"emp_loan2.fxml");
        FXRouter.when("emp_registration", packageStr+"emp_registration.fxml");


        FXRouter.when("home",packageStr+"home.fxml");
        FXRouter.when("login", packageStr+"login.fxml");


        FXRouter.when("manager_home",packageStr+"manager_home.fxml");


        FXRouter.when("menu",packageStr+"menu.fxml");


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