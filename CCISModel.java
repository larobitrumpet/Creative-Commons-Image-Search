import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;

import javafx.scene.image.Image;

import com.google.gson.*;

public class CCISModel
{
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
            URL CCURL = new URL(CCURLString);

            // Open the URL
            InputStream is = CCURL.openStream(); // throws an IOException
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // Read the result into a JSON Element
            jse = new JsonParser().parse(br);

            // Close the connection
            is.close();
            br.close();
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
        CCURLString += query;
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
        ImageResult img = new ImageResult();
        img.setTitle(result.getAsJsonObject().get("title").getAsString());
        img.setImage(new Image(result.getAsJsonObject().get("url").getAsString()));
        String license = result.getAsJsonObject().get("license").getAsString();
        switch (license)
        {
            case "cc0":
                img.setCC0(CC);
                img.setCC1(CC0);
                break;
            case "pdm":
                img.setCC0(CC);
                img.setCC1(PD);
                break;
            case "by":
                img.setCC0(CC);
                img.setCC1(BY);
                break;
            case "by-sa":
                img.setCC0(CC);
                img.setCC1(BY);
                img.setCC2(SA);
                break;
            case "by-nc":
                img.setCC0(CC);
                img.setCC1(BY);
                img.setCC2(NC);
                break;
            case "by-nd":
                img.setCC0(CC);
                img.setCC1(BY);
                img.setCC2(ND);
                break;
            case "by-nc-sa":
                img.setCC0(CC);
                img.setCC1(BY);
                img.setCC2(NC);
                img.setCC3(SA);
                break;
            case "by-nc-nd":
                img.setCC0(CC);
                img.setCC1(BY);
                img.setCC2(NC);
                img.setCC3(ND);
                break;
            default:
                break;
        }
        return img;
    }

    public GenericList<ImageResult> getResults()
    {
        return imageResults;
    }
}
