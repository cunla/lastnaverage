Last N numbers average calculator
---------------------------------

# Implementation details
Implementation is in `LastNumbersAverageImpl` class.
The implementation is not blocking. 

There is a scenario where adding numbers from multiple threads can damage the data-structure.
In order to protect from that scenario, one can make the method `addNumber` thread-safe.

`LastNumbersAverageFactory` is a factory to generate instances.


# Tests
Code coverage of 100% in tests.
