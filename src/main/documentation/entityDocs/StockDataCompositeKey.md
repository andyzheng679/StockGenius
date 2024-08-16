Composite Primary Key, having multiple fields as your primary key, in this case, the stock ticker name and the date of the data. 

The @Embeddable annotation states that this class can be embedded in another entity class. Field wise.

If used for the composite key, you use @EmbeddedId annotation in the entity class that you want it to be embedded in.

use @Embedded if used for other fields in the entity class.

