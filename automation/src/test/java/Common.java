
public class Common {
	
	public Common(){
		
	}
	
	/**
     * Generates a unique number based on a timestamp that can be used in data.
     *
     * @return @throws Exception
     */
	
	public static String generateTimeStamp() throws Exception {
        long ts = (new java.util.Date()).getTime();
        // System.out.print("Unique string - " + String.valueOf(ts));
        return String.valueOf(ts);
    }

}
