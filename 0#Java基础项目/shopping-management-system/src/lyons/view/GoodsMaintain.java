package lyons.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * created by meizhimin on 2021/8/6
 */
public class GoodsMaintain {
    @FXML
    private void AddGoods(){
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AddGoods.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            // Give the controller access to the main app.
            //            GoodsMaintain controller = loader.getController();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            Stage stage = new Stage();
            stage.setTitle("AddGoods");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
