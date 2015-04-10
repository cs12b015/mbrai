import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.json.*;


public class cbr {
	
	public static void main(String[] args) throws FileNotFoundException, JSONException ,MalformedURLException , IOException {
		
    	System.out.println("Enter your token: ");
    	Scanner scanner = new Scanner(System.in);
    	String token = scanner.nextLine();
    	token = "CAACEdEose0cBAN5B9g6ieA3IZCid5aAs1E0ZCNeiI45Pfo2r9ndr52kXI2oXv94r1UZC8Vj1RfiDL2aahoxPHbBWnwAKZBkKmPMxHDBIu5K16rI2KMXZCq2uNqTHqGTZC0je333ZBY4XIZBBKaCAK8ZAHcGgdnoXRivMfnTDXjlZCAKWy1NBqcXZBUDjhI06rS1LT4KHSP0ZCvSi7QGYbo2SRfNfZCkpGPauxA4YZD";
    	String url1 = "https://graph.facebook.com/me/posts?limit=1000&fields=story%2Cmessage%2Cstatus_type&access_token="+token+"&__mref=message_bubble";
    	
    	DataOutputStream out1 = new DataOutputStream(new FileOutputStream("output.txt"));
    	String json = null;
		
		
		URL url = new URL(url1);
	    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	    String line;
	    while ((line = in.readLine()) != null) {
	    	//System.out.println(line);
	    	//out1.writeBytes(line);
	    	json=line;
	    }
	    in.close();
	    
	   
	    
	
		//System.out.println(json);
	    //putting json into arrylist
		JSONObject myjson = new JSONObject(json);
		JSONArray the_json_array = myjson.getJSONArray("data");
		int size = the_json_array.length();
		ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
		for (int i = 0; i < size; i++) {
	        JSONObject another_json_object = the_json_array.getJSONObject(i);
	            arrays.add(another_json_object);
	    }

		String nexturl=null;
		if(myjson.has("paging"))
		{
			JSONObject pgson = (JSONObject) myjson.get("paging");
			nexturl= (String) pgson.get("next");
			System.out.println(nexturl);
		}
		
		get_all_page_posts(nexturl,json,arrays);
		
		
		
		
		
		
		System.out.println(arrays.get(0));
		int arraylistsize = arrays.size();
		int i;
		
		for(i=0;i<arraylistsize;i++)
		{
			if(arrays.get(i).has("story"))
			{
				System.out.println(arrays.get(i).get("story"));
				out1.writeBytes((String) arrays.get(i).get("story")+"\n");
			}
			
			if(arrays.get(i).has("message"))
			{
				System.out.println(arrays.get(i).get("message")  );
				out1.writeBytes((String)arrays.get(i).get("message")+"\n");
			}
		}
		
	
	}
	
	
	public static void get_all_page_posts(String nexturl,String json,ArrayList<JSONObject> arrays) throws IOException, JSONException
	{
		int checkpoint=1;
		while(checkpoint==1)
		{
			URL url = new URL(nexturl);
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line;
		    line = in.readLine();
		    in.close();
			//System.out.println("yeah we are here");
			//System.out.println(line);
			
			JSONObject obj = new JSONObject(line);
			JSONArray obj_array = obj.getJSONArray("data");
			int objsize=obj_array.length();
			for (int i = 0; i < objsize; i++) 
			{
		        JSONObject another_json_object = obj_array.getJSONObject(i);
		            arrays.add(another_json_object);
		    }
			
			if(obj.has("paging"))
			{
				JSONObject pgson = (JSONObject) obj.get("paging");
				nexturl= (String) pgson.get("next");
				System.out.println(nexturl);
			}
			else
			{
				checkpoint= 2;
			}
		}	
	}
}
