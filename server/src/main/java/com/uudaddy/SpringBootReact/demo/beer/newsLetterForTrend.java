package com.uudaddy.SpringBootReact.demo.beer;

import org.json.*;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class newsLetterForTrend {
	
	// github last week's trending repos first
	
	// APIs to github trending
	// https://github-trending-api.now.sh/repositories?since=weekly
	public static void main(String[] args) throws IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet("https://github-trending-api.now.sh/repositories?since=weekly");

            // add request headers
            request.addHeader("custom-key", "MXU");
            request.addHeader(HttpHeaders.USER_AGENT, "TEST");

            CloseableHttpResponse response = httpClient.execute(request);

            try {

                // Get HttpResponse Status
            	String result = null;
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    result = EntityUtils.toString(entity);
                    System.out.println(result);
                }
                
                // build a JSON object
                // 
                JSONArray obj = new JSONArray(result);
                /*
                if (! obj.getString("HTTP/1.1").contains("OK"))
                    return;
                else 
                */
                {
                	
                    newsLetterForTrend.parseGithubTrendJsonArray(obj);
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
		
	}
	
	// 
	public static void parseGithubTrendJsonArray(JSONArray result)
	{
		// https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
		/*
		JSONObject obj = new JSONObject(" .... ");
		String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        */
		HashMap<String, Long> repos = new HashMap<String, Long>();
		JSONArray arr = result;
		// sort the stars in descending order
		/*
		 * "author":"microsoft",
      "name":"ApplicationInspector",
      "avatar":"https://github.com/microsoft.png",
      "url":"https://github.com/microsoft/ApplicationInspector",
      "description":"A source code analyzer built for surfacing features of interest and other characteristics to answer the question 'what's in it' using static analysis with a json based rules engine. Ideal for scanning components before use or detecting feature level changes.",
      "language":"C#",
      "languageColor":"#178600",
      "stars":1733,
      "forks":139,
      "currentPeriodStars":1141,
		 */
		System.out.println("Here is the last week's most popular repos");
		for (int i = 0; i < 3
				//arr.length()
				; i++)
		{
			String author = arr.getJSONObject(i).getString("author");
			System.out.print("author: " + author); 
		    String name = arr.getJSONObject(i).getString("name");
		    int stars = arr.getJSONObject(i).getInt("stars");
		    System.out.println(" name: " + name + " stars: " + stars);
		    repos.put(name, new Long(stars));
		}
		// mailchimp
		
	}
	
	// organize and sending email from the information we received from API 
	void sendEmail(String from, 
			String to, 
			String subject, 
			String body
			)
	{
		  // special characters acceptable 
	}

}
