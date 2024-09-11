Business Logic

@Value: used to inject values into fields, method, or constructor from application.properties, using it to inject API key,
so that application.properties can be hidden on github via gitignore.

Fields:
private String aphaVantageURL - API URL, not the full URL, will need to add the range, ticker and other.

private RestTemplate restTemplate - Used to perform HTTP requests to external API's.

private StockDataRepository stockDataRepository - Repository class, which provides access to the database to perform CRUD operations.

private ObjectMapper objectMapper - Used to map JSON data into Java objects, vice versa.

Constructor that will auto-wire an instance of RestTemplate, StockDataRepository, ObjectMapper into the class using Spring's dependency injection.

Methods:
public String getStockData - takes in two params, range and the stock ticker, creates a URL using aphaVantageURL field, range, ticker and apiKey field.
Returns raw JSON response from the API as a string, .getForObject() is used to send HTTP GET request to the URL, 
the String.class tells the restTemplate that the response should be returned as a string.

public String daily - takes in param of the stock ticker and returns the daily range and the stock ticker.

public String weekly - takes in param of the stock ticker and returns the weekly range and the stock ticker.

public String monthly - takes in param of the stock ticker and returns the monthly range and the stock ticker.

private double calculateIntradayMovePercentage - private method to be only called within the class,
takes two param, open and close.
((close - open) / open) * 100 will find the percentage with many decimal places.
Then multiply it by 100 to move decimal by two.
then Math.round() will round it to the nearest whole number, then divide by 100 to get two decimal places.

public void mapSaveStockData - takes in param of stockData, obtained from public String getStockData.
Mapping and saving the data are inside try catch block in the event there is an issue with the mapping or saving.
Catches the exception in variable e, then .printStackTrace will provide a report that includes: type of exception, error message, and all the actions that led up to the error and the file/line.
.readTree() method of ObjectMapper turns the JSON string into a tree-like structure. JsonNode datatype is used to hold and navigate the tree-like structure. 
Naming convention "root", highest hierarchy/topmost level, the entry. The root is the entire JSON, "Meta Data" and "Time Series (Daily)" are the child nodes. 
From the root (which contains the entire JSON), extract the child nodes, Meta data & Time Series (Daily), so we can access the data in them. 
Extracting the stock ticker from the metaData, using method .asText() because we are converting the value of "2. Symbol" from JsonNode to a String.



@Transactional: used for database logic, ensures that the action is done at once, or none at all, especially in applications where multiple operations depend on each other. 
If any operation fails, then the entire transaction is rolled back. This prevents partial updates to the database which can lead to inconsistent data. 

