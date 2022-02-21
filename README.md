# Url Shortener
This is Url Shortener assignment Motivation Implemented a Url Shortener .

Features:

--User can enter a long url .

--User will get a unique short url.

--User can redirect to the Long url by using that short url.

# API documentation

--POST request to generate short url

End point: http://localhost:8080/api/generateShortUrl/

Request body:

{
  
  "longUrl":"https://www.google.com/",
    
    "shorUrl":null
}

Response body:

{
   
   "shortUrl": "JuEGV",
    
    "longUrl": "https://www.google.com/"
}

--GET request to  Redirect to a the long url

End point :http://localhost:8080/api/getLongUrl/JuEGV

Response body:

{

    "shortUrl": "JuEGV",
    
    "longUrl": "https://www.google.com/"
}


# Project deployment documentation

--Download the zip folder from the repository

--Export it into the eclipse .

--Update maven project.

--Go to UrlShortenerApplication .

--Right click and run as java application .

-- Then go to your browser and type in the address bar http://localhost:8080/

--Then use it .

