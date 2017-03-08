package common;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyHelper extends Main{
	
	public Properties readProperties(String name) throws IOException {
        Properties properties = new Properties();
        ClassLoader loader = PropertyHelper.class.getClassLoader();
        InputStream inStream = loader.getResourceAsStream(name);
        properties.load(inStream);
        return properties;
    }

    /**
     *
     * @param key
     * @return
     */
    public String getInitProperties(String key) {

        Properties props = null;
        String value = "";

        try {
            props = readProperties(INIT_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        if (key.equals("BROWSER.type")) {
            value = props.getProperty(key);
        } else {
            value = props.getProperty(key);
            try {
                props = readProperties(INIT_PROPERTY_FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            value = props.getProperty(key);
        }

        return value;
    }
}
