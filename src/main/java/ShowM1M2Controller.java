import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowM1M2Controller  implements Initializable {

    String t ;

    public ShowM1M2Controller(String t) {
        this.t = t;
    }

    public TextArea text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.setText(t);
    }
}
