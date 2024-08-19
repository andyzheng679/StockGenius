Composite Primary Key, having multiple fields as your primary key, in this case, the stock ticker name and the date of the data. 

The @Embeddable annotation states that this class can be embedded in another entity class. Field wise.

If used for the composite key, you use @EmbeddedId annotation in the entity class that you want it to be embedded in.

use @Embedded if used for other fields in the entity class.

Two fields: the stock ticker symbol and the date of the data.

Two constructors, with args to save the data, and without args to get the data in the database.

Implements the Serializable interface, normally, single primary keys are already Serializable by default,
since we're using a custom class to hold the primary key, JPA does not know how to serialize it.

