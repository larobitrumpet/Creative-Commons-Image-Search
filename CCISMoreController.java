import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CCISMoreController implements Initializable
{
    private CCISModel model = new CCISModel();

    private String id;

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblName;
    @FXML
    private Hyperlink hylCratorURL;
    @FXML
    private Label lblLicence;
    @FXML
    private Label lblAttribution;
    @FXML
    private ImageView imgImage;
    @FXML
    private Button btnDownload;

    public void initData(String imgId)
    {
        id = imgId;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //TODO
    }
}
