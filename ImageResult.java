import java.io.File;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ImageResult
{
    private Stage stage;
    private FileChooser fileChooser;
    private GridPane root;
    private ImageView imgImage, imgCC0, imgCC1, imgCC2, imgCC3;
    private Label lblTitle;
    private Button btnMore, btnDownload;
    private String imageURL;
    private String id;

    public ImageResult(Image image, Image cc0, Image cc1, Image cc2, Image cc3, String title, String imgURL, String imgId)
    {
        imageURL = imgURL;
        id = imgId;
        root = new GridPane();
        fileChooser = new FileChooser();
        imgImage = new ImageView(image);
        imgCC0 = new ImageView(cc0);
        imgCC1 = new ImageView(cc1);
        imgCC2 = new ImageView(cc2);
        imgCC3 = new ImageView(cc3);
        lblTitle = new Label(title);
        btnMore = new Button("More Info");
        btnDownload = new Button("Download");

        root.add(imgImage, 0, 0);
        root.setColumnSpan(imgImage, 5);
        root.add(imgCC0, 1, 1);
        root.add(imgCC1, 2, 1);
        root.add(imgCC2, 3, 1);
        root.add(imgCC3, 4, 1);
        root.add(lblTitle, 0, 1);
        root.add(btnMore, 0, 2);
        root.add(btnDownload, 1, 2);
        root.setColumnSpan(btnDownload, 4);

        root.setStyle("-fx-border-color: #000; -fx-border-width: 2px; -fx-padding: 8px; -fx-margin: 8px; -fx-hgap: 8px; -fx-vgap: 8px;");

        btnDownload.setOnAction(e -> btnDownloadPressed(e));
        btnMore.setOnAction(e -> btnMorePressed(e));
    }

    public GridPane getRoot()
    {
        return root;
    }

    public void btnDownloadPressed(ActionEvent e)
    {
        CCISModel model = new CCISModel();
        stage = (Stage) root.getScene().getWindow();
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

    public void btnMorePressed(ActionEvent e)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./CCISViewMore.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            CCISMoreController controller = fxmlLoader.getController();
            controller.initData(stage, id);

            stage.show();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
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

    public void setTitle(String title)
    {
        lblTitle.setText(title);
    }

    public void setImage(Image img)
    {
        imgImage.setImage(img);
    }

    public void setCC0(Image img)
    {
        imgCC0.setImage(img);
    }

    public void setCC1(Image img)
    {
        imgCC1.setImage(img);
    }

    public void setCC2(Image img)
    {
        imgCC2.setImage(img);
    }

    public void setCC3(Image img)
    {
        imgCC3.setImage(img);
    }
}
