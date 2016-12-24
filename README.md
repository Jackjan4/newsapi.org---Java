# newsapi.org - Java

This little library is a Java wrapper for newsapi.org. You don't need to fiddle with JSON manually anymore.


## Usage
``` java

NewsRequest request = new NewsRequest(yourApiKey, newsSource);

NewsResult result = request.invoke();

for(Article a : result.getArticles())
{
  System.out.println("Title: " + a.getTitle());
  System.out.println("Description: " + a.getDescription());
  // ...
}
