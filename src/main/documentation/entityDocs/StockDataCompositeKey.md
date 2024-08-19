Composite Primary Key, having multiple fields as your primary key, in this case, the stock ticker name and the date of the data. 

The @Embeddable annotation states that this class can be embedded in another entity class. Field wise.

If used for the composite key, you use @EmbeddedId annotation in the entity class that you want it to be embedded in.

use @Embedded if used for other fields in the entity class.

Two fields: the stock ticker symbol and the date of the data.

Two constructors, with args to save the data, and without args to get the data in the database.

Implements the Serializable interface, normally, single primary keys are already Serializable by default,
since we're using a custom class to hold the primary key, JPA does not know how to serialize it.

Serializable is a marker interface, doesn't require us to implement any methods, indicates that objects of the class can be converted into a byte stream.

Byte stream is a sequence of bytes that can be used to represent data. 

Override .equals method. The default compares memory reference, address in memory where an object is stored.
New .equals method compares the content of the objects, will be used to check if the stock ticker and data date exists in the database

public boolean equals: compares current object with input parameter object. If the current object's memory reference is equals to input object's memory reference,
return true, if input object is null or if current class does not equal input object's class, return false. 
Set variable of StockDataCompositeKey datatype to input object, typecast it to StockDataCompositeKey, 
so we can compare the current object's stockerTicker and date with the input object's stockTicker and date.


