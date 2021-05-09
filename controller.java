/*
 * WxController
 * This is the controller for the FXML document that contains the view. 
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Luke Robillard
 */

public class controller implements Initializable
{
    @FXML
    private CheckBox ckbCommercially;
    @FXML
    private CheckBox ckbModify;
    @FXML
    private CheckBox ckbCC0;
    @FXML
    private CheckBox ckbPublicDomain;
    @FXML
    private CheckBox ckbBY;
    @FXML
    private CheckBox ckbBY_SA;
    @FXML
    private CheckBox ckbBY_NC;
    @FXML
    private CheckBox ckbBY_ND;
    @FXML
    private CheckBox ckbBY_NC_SA;
    @FXML
    private CheckBox ckbBY_NC_ND;
    @FXML
    private CheckBox ckbADW;
    @FXML
    private CheckBox ckbBHL;
    @FXML
    private CheckBox ckbBM;
    @FXML
    private CheckBox ckbCAPL;
    @FXML
    private CheckBox ckbCMA;
    @FXML
    private CheckBox ckbDA;
    @FXML
    private CheckBox ckbDM;
    @FXML
    private CheckBox ckbE;
    @FXML
    private CheckBox ckbF;
    @FXML
    private CheckBox ckbFO;
    @FXML
    private CheckBox ckbGBI;
    @FXML
    private CheckBox ckbMCM;
    @FXML
    private CheckBox ckbMMA;
    @FXML
    private CheckBox ckbMV;
    @FXML
    private CheckBox ckbNASA;
    @FXML
    private CheckBox ckbNYPL;
    @FXML
    private CheckBox ckbPP;
    @FXML
    private CheckBox ckbR;
    @FXML
    private CheckBox ckbRM;
    @FXML
    private CheckBox ckbSM;
    @FXML
    private CheckBox ckbS;
    @FXML
    private CheckBox ckbSINMAAHC;
    @FXML
    private CheckBox ckbSINMAA;
    @FXML
    private CheckBox ckbSINASM;
    @FXML
    private CheckBox ckbSISAAM;
    @FXML
    private CheckBox ckbSINMAH;
    @FXML
    private CheckBox ckbSINMAI;
    @FXML
    private CheckBox ckbSIACM;
    @FXML
    private CheckBox ckbSICHSDM;
    @FXML
    private CheckBox ckbSIFGA;
    @FXML
    private CheckBox ckbSISG;
    @FXML
    private CheckBox ckbSIHMSG;
    @FXML
    private CheckBox ckbSIA;
    @FXML
    private CheckBox ckbSISL;
    @FXML
    private CheckBox ckbSINMNH;
    @FXML
    private CheckBox ckbSINPG;
    @FXML
    private CheckBox ckbSINPM;
    @FXML
    private CheckBox ckbSINZ;
    @FXML
    private CheckBox ckbSX;
    @FXML
    private CheckBox ckbSVGS;
    @FXML
    private CheckBox ckbT;
    @FXML
    private CheckBox ckbTM;
    @FXML
    private CheckBox ckbWC;
    @FXML
    private CheckBox ckbWOCTC;
    @FXML
    private CheckBox ckbWRMS;
    @FXML
    private CheckBox ckbPhotos;
    @FXML
    private CheckBox ckbIllustrations;
    @FXML
    private CheckBox ckbDigitizedArt;
    @FXML
    private CheckBox ckbJPEG;
    @FXML
    private CheckBox ckbPNG;
    @FXML
    private CheckBox ckbGIF;
    @FXML
    private CheckBox ckbSVG;
    @FXML
    private CheckBox ckbTall;
    @FXML
    private CheckBox ckbWide;
    @FXML
    private CheckBox ckbSquare;
    @FXML
    private CheckBox ckbSmall;
    @FXML
    private CheckBox ckbMedium;
    @FXML
    private CheckBox ckbLarge;
    @FXML
    private CheckBox ckbCreator;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private FlowPane floSearchResults;

    @FXML
    private void btnSearchPressed(ActionEvent e)
    {
        boolean[] Use = new boolean[2];
        boolean[] License = new boolean[8];
        boolean[] Source = new boolean[45];
        boolean[] ImageType = new boolean[3];
        boolean[] FileType = new boolean[4];
        boolean[] Aspect = new boolean[3];
        boolean[] Size = new boolean[3];
        boolean Creator = false;

        // Get states of filters
        Use[0] = ckbCommercially.isSelected();
        Use[1] = ckbModify.isSelected();
        License[0] = ckbCC0.isSelected();
        License[1] = ckbPublicDomain.isSelected();
        License[2] = ckbBY.isSelected();
        License[3] = ckbBY_SA.isSelected();
        License[4] = ckbBY_NC.isSelected();
        License[5] = ckbBY_ND.isSelected();
        License[6] = ckbBY_NC_SA.isSelected();
        License[7] = ckbBY_NC_ND.isSelected();
        Source[0] = ckbADW.isSelected();
        Source[1] = ckbBHL.isSelected();
        Source[2] = ckbBM.isSelected();
        Source[3] = ckbCAPL.isSelected();
        Source[4] = ckbCMA.isSelected();
        Source[5] = ckbDA.isSelected();
        Source[6] = ckbDM.isSelected();
        Source[7] = ckbE.isSelected();
        Source[8] = ckbF.isSelected();
        Source[9] = ckbFO.isSelected();
        Source[10] = ckbGBI.isSelected();
        Source[11] = ckbMCM.isSelected();
        Source[12] = ckbMMA.isSelected();
        Source[13] = ckbMV.isSelected();
        Source[14] = ckbNASA.isSelected();
        Source[15] = ckbNYPL.isSelected();
        Source[16] = ckbPP.isSelected();
        Source[17] = ckbR.isSelected();
        Source[18] = ckbRM.isSelected();
        Source[19] = ckbSM.isSelected();
        Source[20] = ckbS.isSelected();
        Source[21] = ckbSINMAAHC.isSelected();
        Source[22] = ckbSINMAA.isSelected();
        Source[23] = ckbSINASM.isSelected();
        Source[24] = ckbSISAAM.isSelected();
        Source[25] = ckbSINMAH.isSelected();
        Source[26] = ckbSINMAI.isSelected();
        Source[27] = ckbSIACM.isSelected();
        Source[28] = ckbSICHSDM.isSelected();
        Source[29] = ckbSIFGA.isSelected();
        Source[30] = ckbSISG.isSelected();
        Source[31] = ckbSIHMSG.isSelected();
        Source[32] = ckbSIA.isSelected();
        Source[33] = ckbSISL.isSelected();
        Source[34] = ckbSINMNH.isSelected();
        Source[35] = ckbSINPG.isSelected();
        Source[36] = ckbSINPM.isSelected();
        Source[37] = ckbSINZ.isSelected();
        Source[38] = ckbSX.isSelected();
        Source[39] = ckbSVGS.isSelected();
        Source[40] = ckbT.isSelected();
        Source[41] = ckbTM.isSelected();
        Source[42] = ckbWC.isSelected();
        Source[43] = ckbWOCTC.isSelected();
        Source[44] = ckbWRMS.isSelected();
        ImageType[0] = ckbPhotos.isSelected();
        ImageType[1] = ckbIllustrations.isSelected();
        ImageType[2] = ckbDigitizedArt.isSelected();
        FileType[0] = ckbJPEG.isSelected();
        FileType[1] = ckbPNG.isSelected();
        FileType[2] = ckbGIF.isSelected();
        FileType[3] = ckbSVG.isSelected();
        Aspect[0] = ckbTall.isSelected();
        Aspect[1] = ckbWide.isSelected();
        Aspect[2] = ckbSquare.isSelected();
        Size[0] = ckbSmall.isSelected();
        Size[1] = ckbMedium.isSelected();
        Size[2] = ckbLarge.isSelected();
        Creator = ckbCreator.isSelected();

        SingleLinkList<String> license_type = new SingleLinkList<String>;
        if (Use[0])
            license_type.push("commercial");
        if (Use[1])
            license_type.push("modification");

        SingleLinkList<String> license = new SingleLinkList<String>;
        if (License[0])
            license.push("CC0");
        if (License[1])
            license.push("PDM");
        if (License[2])
            license.push("BY");
        if (License[3])
            license.push("BY-SA");
        if (License[4])
            license.push("BY-NC");
        if (License[5])
            license.push("BY-ND);
        if (License[6])
            license.push("BY-NC-SA");
        if (License[7])
            license.push("BY-NC-ND");

        SingleLinkList<String> source = new SingleLinkList<String>;
        if (Source[0])
            source.push("animaldiversity");
        if (Source[1])
            source.push("bio_diversity");
        if (Source[2])
            source.push("brooklynmuseum");
        if (Source[3])
            source.push("CAPL");
        if (Source[4])
            source.push("clevelandmuseum");
        if (Source[5])
            source.push("deviantart");
        if (Source[6])
            source.push("digitaltmuseum");
        if (Source[7])
            source.push("europeana");
        if (Source[8])
            source.push("flickr");
        if (Source[9])
            source.push("floraon");
        if (Source[10])
            source.push("geographorguk");
        if (Source[11])
            source.push("mccordmuseum");
        if (Source[12])
            source.push("met");
        if (Source[13])
            source.push("museumsvictoria");
        if (Source[14])
            source.push("nasa");
        if (Source[15])
            source.push("nypl");
        if (Source[16])
            source.push("phylopic");
        if (Source[17])
            source.push("rawpixel");
        if (Source[18])
            source.push("rijksmuseum");
        if (Source[19])
            source.push("sciencemuseum");
        if (Source[20])
            source.push("sketchfab");
        if (Source[21])
            source.push("smithsonian_african_american_history_museum");
        if (Source[22])
            source.push("smithsonian_african_art_museum");
        if (Source[23])
            source.push("smithsonian_air_and_space_museum");
        if (Source[24])
            source.push("mithsonian_american_art_museum");
        if (Source[25])
            source.push("smithsonian_american_history_museum");
        if (Source[26])
            source.push("smithsonian_american_indian_museum");
        if (Source[27])
            source.push("smithsonian_anacostia_museum");
        if (Source[28])
            source.push("smithsonian_cooper_hewitt_museum");
        if (Source[29])
            source.push("smithsonian_freer_gallery_of_art");
        if (Source[30])
            source.push("smithsonian_gardens");
        if (Source[31])
            source.push("smithsonian_hirshhorn_museum");
        if (Source[32])
            source.push("smithsonian_institution_archives");
        if (Source[33])
            source.push("smithsonian_libraries");
        if (Source[34])
            source.push("smithsonian_national_museum_of_natural_history");
        if (Source[35])
            source.push("smithsonian_portrait_gallery");
        if (Source[36])
            source.push("smithsonian_postal_museum");
        if (Source[37])
            source.push("smithsonian_zoo_and_conservation");
        if (Source[38])
            source.push("spacex");
        if (Source[39])
            source.push("svgsilh");
        if (Source[40])
            source.push("thingiverse");
        if (Source[41])
            source.push("thorvaldsensmuseum");
        if (Source[41])
            source.push("wikimedia");
        if (Source[42])
            source.push("woc_tech");
        if (Source[43])
            source.push("WoRMS");

        SingleLinkList<String> categories = new SingleLinkList<String>;
        if (ImageType[0])
            categories.push("photograph");
        if (ImageType[1])
            categories.push("illustration");
        if (ImageType[2])
            categories.push("digitized_artwork");

        SingleLinkList<String> extension = new SingleLinkList<String>;
        if (FileType[0])
            extension.push("jpg");
        if (FileType[1])
            extension.push("png");
        if (FileType[2])
            extension.push("gif");
        if (FileType[3])
            extension.push("svg");

        SingleLinkList<String> aspect_ratio = new SingleLinkList<String>;
        if (Aspect[0])
            aspect_ratio.push("tall");
        if (Aspect[1])
            aspect_ratio.push("wide");
        if (Aspect[2])
            aspect_ratio.push("square");

        SingleLinkList<String> size = new SingleLinkList<String>;
        if (Size[0])
            size.push("small");
        if (Size[1])
            size.push("medium");
        if (Size[2])
            size.push("large");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //TODO
    }
}
