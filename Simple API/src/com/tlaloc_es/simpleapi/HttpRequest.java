package com.tlaloc_es.simpleapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *\brief The HttpRequest wraps a \red HttpURLConnection.
 *In addition, this class provides several methods to use API Rest in a simple way.
 */
public class HttpRequest {
	
	private URL url; ///< URL of the request
	private String data; ///< The data that will be sent in the request
	private String userAgent;///< User-Agent that you want to indicate for the requests
	private String contentType; ///< The content type indicated in the requests
	private HttpURLConnection httpCon; ///< The variable to make the connection
	
	/**
	 * \brief Constructs a new HttpRequest with the destination \ref url
	 * \param url URL of the request
	 * \throws MalformedURLException
	 */
	public HttpRequest(String url) throws MalformedURLException{
		this.url = new URL(url);
		this.userAgent = "";
		this.contentType = "";
	}
	
	/**
	 * \brief Constructs a new HttpRequest with the destination \ref url and the \ref userAgent
	 * \param url URL of the request
	 * \param String User-Agent that you want to indicate for the requests
	 * \throws MalformedURLException
	 */
	public HttpRequest(String url, String userAgent) throws MalformedURLException{
		this.url = new URL(url);
		this.userAgent = userAgent;
		this.contentType = "";
	}
	
	private void sendHttpRequest(HttpMethods httpMethod) throws IOException{
		stablishHttpConConfiguration(httpMethod);
		sendData();
	}
	
	private void stablishHttpConConfiguration(HttpMethods httpMethod) throws IOException{
		httpCon = (HttpURLConnection) getURL().openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestProperty("User-Agent", getUserAgent());
		httpCon.setRequestProperty("Content-Type", getContentTipe());
		httpCon.setRequestMethod(httpMethod.value());
	}
	
	private void sendData() throws IOException{
		OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
		out.write(getData());
		out.close();
	}
	
	/**
	 * \brief Returns the data read from the request.
	 * \pre You must have used any of the functions to send API Rest requests.
	 * \return BufferedReader A BufferedReader with the data
	 * \throws IOException
	 */
	public BufferedReader readData() throws IOException{
		InputStream is = httpCon.getInputStream();
		return new BufferedReader(new InputStreamReader(is));
	}
	
	/**
	 * \brief Returns the content type of the request
	 * \return String Content type of the request
	 * \throws IOException
	 */
	public String readContentType(){
		return httpCon.getContentType();
	}
	
	/**
	 * \brief Send a GET request
	 * \throws IOException
	 */
	public void sendGET() throws IOException{
		sendHttpRequest(HttpMethods.GET);
	}
	
	/**
	 * \brief Send a POST request
	 * \throws IOException
	 */
	public void sendPOST() throws IOException{
		sendHttpRequest(HttpMethods.POST);
	}
	
	/**
	 * \brief Send a PUT request
	 * \throws IOException
	 */
	public void sendPUT() throws IOException{
		sendHttpRequest(HttpMethods.PUT);
	}
	
	/**
	 * \brief Send a DELETE request
	 * \throws IOException
	 */
	public void sendDELETE() throws IOException{
		sendHttpRequest(HttpMethods.DELETE);
	}
	

	private URL getURL(){
		return this.url;
	}
	
	private String getUserAgent(){
		return userAgent;
	}
	
	private String getContentTipe(){
		return contentType;
	}
	
	private String getData(){
		return data;
	}
	
	/**
	 * \brief Set a new \ref url for the connection
	 * \param URL New \ref url
	 */
	public void setURL(URL url){
		this.url = url;
	}
	
	/**
	 * \brief Set a new \ref url for the connection
	 * \param String New \ref url
	 * \throws MalformedURLException{
	 */
	public void setURL(String url) throws MalformedURLException{
		this.url = new URL(url);
	}
	
	/**
	 * \brief Set the \ref data for the request
	 * \param String \ref data
	 */
	public void setData(String data){
		this.data = data;
	}
	
	/**
	 * \brief Set the \ref contentType for the connection
	 * \param URL New \ref url
	 */
	public void setContentType(String contentType){
		this.contentType = contentType;
	}
	
}
