import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageResult
{
    GridPane root;
    ImageView imgImage, imgCC0, imgCC1, imgCC2, imgCC3;
    Label lblTitle;
    Button btnMore, btnDownload;

    public static void ImageResult()
    {
        root = new GridPane();
        imgImage = new Image();
        imgCC0 = new Image();
        imgCC1 = new Image();
        imgCC2 = new Image();
        imgCC3 = new Image();
        lblTitle = new Label();
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
    }

    public static void setTitle(String title)
    {
        lblTitle.setText(title);
    }

    public static void setImage(Image img)
    {
        imgImage.setImage(img);
    }

    public static void setCC0(Image img)
    {
        imgCC0.setImage(img);
    }

    public static void setCC1(Image img)
    {
        imgCC1.setImage(img);
    }

    public static void setCC2(Image img)
    {
        imgCC2.setImage(img);
    }

    public static void setCC3(Image img)
    {
        imgCC3.setImage(img);
    }
}
