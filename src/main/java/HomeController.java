import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {


    public TextField tf_10Da;
    public TextField tf_5Da;
    public TextField tf_20Da;
    public TextField tf_50Da;
    public TextField tf_100Da;
    public TextField tf_200Da;
    public TextField total;
    SimpleIntegerProperty i_10da  = new SimpleIntegerProperty(0);
    SimpleIntegerProperty i_5da  = new SimpleIntegerProperty(0);
    SimpleIntegerProperty i_20da  = new SimpleIntegerProperty(0);
    SimpleIntegerProperty i_50da  = new SimpleIntegerProperty(0);
    SimpleIntegerProperty i_100da  = new SimpleIntegerProperty(0);
    SimpleIntegerProperty i_200da  = new SimpleIntegerProperty(0);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tf_10Da.textProperty().bind(i_10da.asString());
        tf_5Da.textProperty().bind(i_5da.asString());
        tf_20Da.textProperty().bind(i_20da.asString());
        tf_50Da.textProperty().bind(i_50da.asString());
        tf_100Da.textProperty().bind(i_100da.asString());
        tf_200Da.textProperty().bind(i_200da.asString());


    }



    public void onDcm_10Da(ActionEvent actionEvent) {
        if (i_10da.get()>0){
            i_10da.set(i_10da.get() -1);
        }

    }

    public void onInc_10Da(ActionEvent actionEvent) {
        i_10da.set(i_10da.get() +1);
    }


    public void onDcm_5Da(ActionEvent actionEvent) {
        if (i_5da.get()>0){
            i_5da.set(i_5da.get() -2);
        }
    }

    public void onInc_5Da(ActionEvent actionEvent) {
        i_5da.set(i_5da.get() +2);
    }

    public void onDcm_20Da(ActionEvent actionEvent) {
        if (i_20da.get()>0){
            i_20da.set(i_20da.get() -1);
        }

    }

    public void onInc_20Da(ActionEvent actionEvent) {
        i_20da.set(i_20da.get() +1);

    }

    public void onDcm_50Da(ActionEvent actionEvent) {
        if (i_50da.get()>0){
            i_50da.set(i_50da.get() -1);
        }
    }

    public void onInc_50Da(ActionEvent actionEvent) {
        i_50da.set(i_50da.get() +1);
    }

    public void onDcm_100Da(ActionEvent actionEvent) {
        if (i_100da.get()>0){
            i_100da.set(i_100da.get() -1);
        }
    }

    public void onInc_100Da(ActionEvent actionEvent) {
        i_100da.set(i_100da.get() +1);
    }

    public void onDcm_200Da(ActionEvent actionEvent) {
        if (i_200da.get()>0){
            i_200da.set(i_200da.get() -1);
        }
            }

    public void onInc_200Da(ActionEvent actionEvent) {
        i_200da.set(i_200da.get() +1);
    }
    M m = new M();
    public void onShowSum(ActionEvent actionEvent) {
        ArrayList<Integer> xi   = new ArrayList<>();
        ArrayList <Integer> vi  = new ArrayList<>() ;
        xi.add(i_5da.get());
        xi.add(i_10da.get());
        xi.add(i_20da.get());
        xi.add(i_50da.get());
        xi.add(i_100da.get());
        xi.add(i_200da.get());
        vi.add(5);
        vi.add(10);
        vi.add(20);
        vi.add(50);
        vi.add(100);
        vi.add(200);
        m.setVi(vi);
        m.setXi(xi);
        total.setText(m.onShowSum());

    }

    public void onFindM_1_M_2(ActionEvent actionEvent) throws IOException {
        m.onFindM1M2();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showM1M2.fxml"));
        loader.setControllerFactory(e -> {

            return new ShowM1M2Controller(m.onShowM1M2());

        });
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("whiteboard.png")));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
