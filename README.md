# Nelson Matos

## Build

- Java 8
- Maven

Navigate to root directory and run command. This command will download dependecies and run unit tests.

```sh
./mvnw clean install
```

## Run Application

Navigate to root directory and run command. Argument list is as follows:

- The tool code to checkout
- Number of days to rent out tool
- Discount percentage. 0-100
- Checkout date. dd/MM/yyyy

```sh
java -jar target/tool.rental-1.0.0.jar CHNS 7 10 10/31/2022
```
