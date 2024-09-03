Business Logic

@Value: used to inject values into fields, method, or constructor from application.properties, using it to inject API key,
so that application.properties can be hidden on github via gitignore.





@Transactional: used for database logic, ensures that the action is done at once, or none at all, especially in applications where multiple operations depend on each other. 
If any operation fails, then the entire transaction is rolled back. This prevents partial updates to the database which can lead to inconsistent data. 

