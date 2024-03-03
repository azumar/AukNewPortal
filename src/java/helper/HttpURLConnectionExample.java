

package helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
 
public class HttpURLConnectionExample {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		HttpURLConnectionExample http = new HttpURLConnectionExample();
 
		System.out.println("Testing 1 - Send Http GET request");
	//http.sendGet();
        http.sendMessage("08161882848");
 
		System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();
 
	}
 
	// HTTP GET request
	private String sendGet() throws Exception {
 //String url = "http://wwww.smslive247.com/http/index.aspx?cmd=login&owneremail=umar_a_zango@yahoo.com&subacct=AUK&subacctpwd=AukAdmin3579";
		//String url = "http://www.google.com/search?q=mkyong";
 String url = "http://www.smslive247.com/http/index.aspx?cmd=login&owneremail=umar_a_zango@yahoo.com&subacct=AUK&subacctpwd=AukAdmin3579";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
                String resp = con.getResponseMessage();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Message : " + resp);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
                String r = response.toString();
                return r.substring(4);
                //return response.toString();
 
	}
 public void sendMessage(String gsm)
 {
     System.out.println(gsm);
     try{
    String sid = sendGet();
    //sid = "fa2a9932-bec1-4824-b64c-fa0993b55355";
    // System.out.println(sid);
     String mess  ="your%20Application%20to%20Al-Qalam%20University%20successufully%20recieved";
     String ender = "AL-QALAM";
     String mobile = "08161882848";
     //String url = "http://www.smslive247.com/http/index.aspx?cmd=sendsmg&sessionid="+sid+"&message="+mess+"&sender="+ender+"&sendto="+mobile+"&msgtype=0";
    //  String url = "http://www.smslive247.com/http/index.aspx?cmd=sendsmg&sessionid="+sid+"&message="+mess+"&sender="+ender+"&sendto="+mobile+"&msgtype=0";
     String url = "http://www.smslive247.com/http/index.aspx?cmd=sendquickmsg&owneremail=umar_a_zango@yahoo.com&subacct=AUK&subacctpwd=AukAdmin3579"+"&message="+mess+"&sender="+ender+"&sendto="+gsm+"&msgtype=0";
     
     URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		//System.out.println(response.toString());
             //   return response.toString();
 
        System.out.println(responseCode);
                System.out.println(url);
          System.out.println(response.toString());
     }
     catch (Exception ex)
     {
         System.out.println("GA ERRO"+ex);
         ex.printStackTrace();
     }
 }
	
 
}