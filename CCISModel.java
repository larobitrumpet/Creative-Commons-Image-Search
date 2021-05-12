import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;
import java.net.HttpURLConnection;

import javafx.scene.image.Image;

import com.google.gson.*;

public class CCISModel
{
    private String authorization = "put brearer token here";
    private JsonElement jse = null;
    GenericList<ImageResult> imageResults = new GenericList<ImageResult>();

    private Image CC = new Image("cc_images/26px-Cc.logo.circle.svg.png");
    private Image CC0 = new Image("cc_images/26px-Cc-zero.svg.png");
    private Image PD = new Image("cc_images/26px-PD-icon-black.svg.png");
    private Image BY = new Image("cc_images/26px-Cc-by_new.svg.png");
    private Image SA = new Image("cc_images/26px-Cc-sa.svg.png");
    private Image NC = new Image("cc_images/26px-Cc-nc.svg.png");
    private Image ND = new Image("cc_images/26px-Cc-nd.svg.png");

    public boolean getSearchResults(String query, String license_type, String license, String source, String categories, String extension, String aspect_ratio, String size, boolean creator)
    {
        try
        {
            String CCURLString = constructURL(query, license_type, license, source, categories, extension, aspect_ratio, size, creator);
            String command = "curl -H \"Authorization: " + authorization + "\" " + CCURLString;
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            jse = new JsonParser().parse(reader);

            reader.close();
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            return false;
        }
        catch (java.io.UnsupportedEncodingException uee)
        {
            uee.printStackTrace();
        }
        catch (java.net.MalformedURLException mue)
        {
            mue.printStackTrace();
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }

        if (jse != null)
        {
            // Build search results
            int numResults = Integer.parseInt(jse.getAsJsonObject().get("page_size").getAsString());
            JsonArray results = jse.getAsJsonObject().get("results").getAsJsonArray();
            imageResults.clear();
            for (int i = 0; i < numResults; i++)
            {
                imageResults.add(constructResult(results.get(i).getAsJsonObject()));
            }
        }
        return true;
    }

    public String constructURL(String query, String license_type, String license, String source, String categories, String extension, String aspect_ratio, String size, boolean creator)
    {
        String CCURLString = "http://api.creativecommons.engineering/v1/images?format=json";
        if (creator)
            CCURLString += "&creator=";
        else 
            CCURLString += "&q=";
        try
        {
            CCURLString += URLEncoder.encode(query, "UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (!(license_type.equals("")))
            CCURLString += "&license_type=" + license_type;
        if (!(license.equals("")))
            CCURLString += "&license=" + license;
        if (!(source.equals("")))
            CCURLString += "&source=" + source;
        if (!(categories.equals("")))
            CCURLString += "&categories=" + categories;
        if (!(extension.equals("")))
            CCURLString += "&extension=" + extension;
        if (!(aspect_ratio.equals("")))
            CCURLString += "&aspect_ratio=" + aspect_ratio;
        if (!(size.equals("")))
            CCURLString += "&size=" + size;

        return CCURLString;
    }

    public ImageResult constructResult(JsonObject result)
    {
        String title = result.getAsJsonObject().get("title").getAsString();

        String imgURL = result.getAsJsonObject().get("url").getAsString();
        String command = "curl " + imgURL;
        Image image = null;
        try
        {
            Process process = Runtime.getRuntime().exec(command);
            InputStream imgStream = process.getInputStream();
            image = new Image(imgStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String license = result.getAsJsonObject().get("license").getAsString();
        Image cc0 = null;
        Image cc1 = null;
        Image cc2 = null;
        Image cc3 = null;
        switch (license)
        {
            case "cc0":
                cc0 = CC;
                cc1 = CC0;
                break;
            case "pdm":
                cc0 = CC;
                cc1 = PD;
                break;
            case "by":
                cc0 = CC;
                cc1 = BY;
                break;
            case "by-sa":
                cc0 = CC;
                cc1 = BY;
                cc2 = SA;
                break;
            case "by-nc":
                cc0 = CC;
                cc1 = BY;
                cc2 = NC;
                break;
            case "by-nd":
                cc0 = CC;
                cc1 = BY;
                cc2 = ND;
                break;
            case "by-nc-sa":
                cc0 = CC;
                cc1 = BY;
                cc2 = NC;
                cc3 = SA;
                break;
            case "by-nc-nd":
                cc0 = CC;
                cc1 = BY;
                cc2 = NC;
                cc3 = ND;
                break;
            default:
                break;
        }
        ImageResult img = new ImageResult(image, cc0, cc1, cc2, cc3, title);
        return img;
    }

    public GenericList<ImageResult> getResults()
    {
        return imageResults;
    }
}
