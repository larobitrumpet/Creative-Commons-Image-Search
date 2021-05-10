import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;

//import java.time.*;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javafx.scene.image.Image;

import com.google.gson.*;

public class model
{
    private JsonElement jse = null;

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
}
