import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class baba {
	
	public static void main(String[] args) {
		
    	System.out.println("Enter your token: ");
    	Scanner scanner = new Scanner(System.in);
    	String token = scanner.nextLine();
    	token = "CAACEdEose0cBAEjeUEhY5irtCEbRZCG2TNaM06ZCztvMXyxl3iDGZAPydCg745gvXNW4bO7wGcPK2yZCBVertzykqVZCoRyTTJXk99Q0i64Y0OtqvQzJu3dfIlSU5W9O2nZB14vPJ8vUiCYnaFZCTLe6Hyv0EnjZC1PafVqugaAeaOI3YkbKe17w2OzZCWQZC3ajOPhVEuuC7eFsbrIw8dOZB5Twm09nmwe8WAZD";
    	String url1 = "https://graph.facebook.com/me/posts?limit=1000&access_token="+token+"&__mref=message";

		try {
			
			URL url = new URL(url1);
			
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    
		    String line;
		    while ((line = in.readLine()) != null) {
		    	System.out.println(line);
		    }
		    in.close();
		    
		}
		catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
		}
		
	}

}
