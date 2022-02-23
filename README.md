# Build and run

```
./gradlew clean build
java -jar build/libs/product-api.jar
```

## API Docs

```
http://localhost:8080/docs/index.html
```

## Notice

[There is a limited number of API requests per minute.](https://github.com/njhyuk/product-api/blob/master/src/main/java/com/marketplace/product/api/common/Bucket4jApiThrottle.java#L15)
