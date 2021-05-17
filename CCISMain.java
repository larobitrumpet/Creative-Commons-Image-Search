/*
 * WxMain
 * This code initiates the View and Controller.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.codecentric.centerdevice.javafxsvg.*;
import org.apache.batik.anim.*;
import org.apache.batik.ext.awt.*;
import org.apache.batik.bridge.*;
import org.apache.batik.css.dom.*;
import org.apache.batik.css.engine.*;
import org.apache.batik.css.parser.*;
import org.apache.batik.dom.*;
import org.apache.batik.ext.*;
import org.apache.batik.gvt.*;
import org.apache.batik.parser.*;
import org.apache.batik.script.*;
import org.apache.batik.dom.svg.*;
import org.apache.batik.svggen.*;
import org.apache.batik.transcoder.*;
import org.apache.batik.util.*;
import org.apache.batik.xml.*;
import org.w3c.dom.svg.*;
import org.apache.xmlgraphics.java2d.*;

/**
 * @author Luke Robillard
 */
public class CCISMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        SvgImageLoaderFactory.install();
        Parent root = FXMLLoader.load(getClass().getResource("./CCISView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Luke Robillard - CSCI 13 Final Project");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
