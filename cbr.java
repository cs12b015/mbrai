import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.json.*;


public class cbr {
	
	public static void main(String[] args) throws FileNotFoundException, JSONException {
		
    	System.out.println("Enter your token: ");
    	Scanner scanner = new Scanner(System.in);
    	String token = scanner.nextLine();
    	token = "CAACEdEose0cBADSZCVjhAZBZAZABkYogWugEswfygZAF3nRS1hJ2mLrLkt45WzDpsG3cZAEPb04gQa0VMYANNRg7Yfe1ZBijiRNv1o6kBsZCcO63T2iB6vaJINECBlu3bpH3Q57Ea0zFkNvEgKLEAmQM63JAG2SmpssFRPRNOIoDPk4zZAUJhZBgdN6QgahuY8HRc1yNZCZCZAvsquZBsnMltdiCwqOOuhZARTQbFcZD";
    	String url1 = "https://graph.facebook.com/me/posts?limit=1000&fields=story%2Cmessage%2Cstatus_type&access_token="+token+"&__mref=message_bubble";
    	
    	DataOutputStream out1 = new DataOutputStream(new FileOutputStream("output.txt"));
    	String json = null;
		try {
			
			URL url = new URL(url1);
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line;
		    while ((line = in.readLine()) != null) {
		    	//System.out.println(line);
		    	out1.writeBytes(line);
		    	json=line;
		    }
		    in.close();
		    
		}
		catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
		}
		
		System.out.println(json);
		JSONObject myjson = new JSONObject(json);
		JSONArray the_json_array = myjson.getJSONArray("data");
		
		
		
		int size = the_json_array.length();
		ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
		for (int i = 0; i < size; i++) {
	        JSONObject another_json_object = the_json_array.getJSONObject(i);
	            arrays.add(another_json_object);
	    }
		
		
		System.out.println(myjson.get("paging"));
		JSONObject pgson = (JSONObject) myjson.get("paging");
		System.out.println(pgson.get("next"));
		
		/*//System.out.println(arrays.get(0));
		int arraylistsize = arrays.size();
		int i;
		
		for(i=0;i<arraylistsize;i++)
		{
			//if(arrays.get(i).has("story"))
			//System.out.println(arrays.get(i).get("story"));
			
			//if(arrays.get(i).has("message"))
			//System.out.println(arrays.get(i).get("message")  );
		}*/
		
		
		
		
	}

}
