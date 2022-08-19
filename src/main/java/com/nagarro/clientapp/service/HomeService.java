package com.nagarro.clientapp.service;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HomeService {

	public List<Book> getBooksdata() throws IOException, ParseException, java.text.ParseException {

		List<Book> booksdata = new ArrayList<>();

		URL url = new URL("http://localhost:8086/api/v1/Books/getBooks");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		// Getting the response code
		int responsecode = conn.getResponseCode();

		if (responsecode != 200) {
			throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {

			String inline = "";
			Scanner scanner = new Scanner(url.openStream());

			while (scanner.hasNext()) {
				inline += scanner.nextLine();
			}
			// System.out.println(inline);
			scanner.close();

			JSONParser parse = new JSONParser();
			JSONObject data_obj = (JSONObject) parse.parse(inline);

			JSONArray Booksdata = (JSONArray) data_obj.get("books");

			for (int i = 0; i < Booksdata.size(); i++) {

				JSONObject obj = (JSONObject) Booksdata.get(i);
				
				ObjectMapper mapper = new ObjectMapper();
				Book book = mapper.readValue(obj.toString(), Book.class);
				//System.out.println(book.toString());

				booksdata.add(book);
			}

		}
		return booksdata;
	}

	public void addbook(HttpServletRequest request) throws IOException {

		// send request
		URL url = new URL("http://localhost:8086/api/v1/Books/");
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection) con;
		http.setRequestMethod("POST");
		http.setDoOutput(true);

		Map<String, String> arguments = new HashMap<>();
		arguments.put("bookcode", request.getParameter("bookcode"));
		arguments.put("author", request.getParameter("author"));
		arguments.put("bookname", request.getParameter("bookname"));
		arguments.put("dateadded", request.getParameter("dateadded"));
		StringJoiner sj = new StringJoiner("&");
		for (Map.Entry<String, String> entry : arguments.entrySet())
			sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.connect();
		try (OutputStream os = http.getOutputStream()) {
			os.write(out);
		}
	}

	public void deletebook(HttpServletRequest request) throws IOException {
		URL url = new URL("http://localhost:8086/api/v1/Books/");
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection) con;
		http.setRequestMethod("DELETE");
		http.setDoOutput(true);

		Map<String, String> arguments = new HashMap<>();
		arguments.put("id", request.getParameter("submit"));
		StringJoiner sj = new StringJoiner("&");
		for (Map.Entry<String, String> entry : arguments.entrySet())
			sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.connect();
		try (OutputStream os = http.getOutputStream()) {
			os.write(out);
		}
	}

	public void editbook(HttpServletRequest request) throws IOException {
		
		URL url = new URL("http://localhost:8086/api/v1/Books/edit");
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection) con;
		http.setRequestMethod("POST");
		http.setDoOutput(true);

		Map<String, String> arguments = new HashMap<>();
		arguments.put("bookcode", request.getParameter("bookcode"));
		
		if(request.getParameter("author") != null)
			arguments.put("author", request.getParameter("author"));
		if(request.getParameter("bookname") != null)
			arguments.put("bookname", request.getParameter("bookname"));
		if(request.getParameter("dateadded") != null)
			arguments.put("dateadded", request.getParameter("dateadded"));
		
		StringJoiner sj = new StringJoiner("&");
		for (Map.Entry<String, String> entry : arguments.entrySet())
			sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.connect();
		try (OutputStream os = http.getOutputStream()) {
			os.write(out);
		}
		
	}

}



