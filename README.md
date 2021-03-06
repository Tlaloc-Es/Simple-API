# Simple-API
A library to make API Rest requests in a simple way.

# HTTP Methods for RESTFul avaliables
```java
HttpRequest.sendGET();
HttpRequest.sendPOST();
HttpRequest.sendPUT();
HttpRequest.sendDELETE();
```

# Other methods
```java
HttpRequest.setContentType(String contentType);
```
# Add Simple API to your project
## With Maven
```
<dependency>
    <groupId>com.tlaloc-es</groupId>
    <artifactId>simpleapi</artifactId>
    <version>0.0.1</version>
</dependency>
```

## With Gradlew
```
compile 'com.tlaloc-es:simpleapi:0.0.1'
```

# Examples of use

## Set a specific user agent
```java
HttpRequest http = new HttpRequest("http://www.numbersapi.com/random/trivia/", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0");
```

## Making a request without data

**Code**
```java
HttpRequest http = new HttpRequest("http://www.numbersapi.com/random/trivia/");
http.setData("");
http.sendGET();

BufferedReader br = http.readData();
String s = null;

while ((s=br.readLine())!=null){
  System.out.println(s);
}
```

**Response**

*111 is the lowest positive integer requiring six syllables to name in American English, or seven syllables (including "and") in Canadian and British English.*

## Making a request with data

**Code**
```java
HttpRequest http = new HttpRequest("http://ws.audioscrobbler.com/2.0/?method=tag.getinfo&format=json");
http.setData("api_key=YOURAPIKEY&tag=disco");
http.sendGET();

JSONParser parser = new JSONParser();
Object obj = parser.parse(http.readData());
JSONObject jsonObject = (JSONObject) obj;
System.out.println(jsonObject);
```
**Response**

*{"tag":{"total":158861,"reach":35553,"wiki":{"summary":"Disco is a genre of dance-oriented music that originated in African American, gay and Hispanic American communities in 1970s. In what is considered a forerunner to disco style clubs in February 1970 New York City DJ David Mancuso opened The Loft, a members-only private dance club set in his own home. Most agree that the ...*
