Business Logic

@Value: used to inject values into fields, method, or constructor from application.properties, using it to inject API key,
so that application.properties can be hidden on github via gitignore.

Fields:
private String aphaVantageURL - API URL, not the full URL, will need to add the range, ticker and other.

private RestTemplate restTemplate - Used to perform HTTP requests to external API's.

private StockDataRepository stockDataRepository - Repository class, which provides access to the database to perform CRUD operations.

Constructor that will auto-wire an instance of RestTemplate and StockDataRepository into the class using Spring's dependency injection.

Methods:
public String getStockData - takes in two params, range and the stock ticker, creates a URL using aphaVantageURL field, range, ticker and apiKey field.
Returns raw JSON response from the API as a string, .getForObject() is used to send HTTP GET request to the URL, 
the String.class tells the restTemplate that the response should be returned as a string.

public String daily - takes in param of the stock ticker and returns the daily range and the stock ticker.

public String weekly - takes in param of the stock ticker and returns the weekly range and the stock ticker.

public String monthly - takes in param of the stock ticker and returns the monthly range and the stock ticker.

@Transactional: used for database logic, ensures that the action is done at once, or none at all, especially in applications where multiple operations depend on each other. 
If any operation fails, then the entire transaction is rolled back. This prevents partial updates to the database which can lead to inconsistent data. 

