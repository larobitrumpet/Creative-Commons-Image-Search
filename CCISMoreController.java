import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class CCISMoreController implements Initializable
{
    private CCISModel model = new CCISModel();

    private Stage stage;
    private String id;
    private String imageURL;
    private FileChooser fileChooser = new FileChooser();

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblName;
    @FXML
    private Hyperlink hypCreatorURL;
    @FXML
    private Label lblLicense;
    @FXML
    private Label lblAttribution;
    @FXML
    private ImageView imgImage;
    @FXML
    private Button btnDownload;

    @FXML
    private void btnDownloadPressed(ActionEvent e)
    {
        fileChooser.setTitle("Download Image");
        String fileName = getNameFromURL(imageURL);
        String extension = getExtension(fileName);
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*." + extension));
        fileChooser.setInitialFileName(fileName);
        File file = fileChooser.showSaveDialog(stage);
        if (file != null)
        {
            model.downloadImage(file, imageURL);
        }
    }

    private String getNameFromURL(String URL)
    {
        String[] s = URL.split("/");
        return s[s.length - 1];
    }

    private String getExtension(String file)
    {
        String[] s = file.split("/");
        return s[s.length - 1];
    }

    public void initData(Stage sta, String imgId)
    {
        stage = sta;
        id = imgId;
        if (model.getImageDetail(id))
        {
            String[] details = model.getDetails();
            lblTitle.setText(details[0]);
            lblName.setText(details[1]);
            hypCreatorURL.setText(details[2]);
            lblLicense.setText(details[3]);
            lblAttribution.setText(details[4]);
            imgImage.setImage(new Image(details[5]));
            imageURL = details[5];
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //TODO
    }
}
