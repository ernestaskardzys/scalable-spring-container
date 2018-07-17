# Running application

```bash
$ ./gradlew clean build
$ docker-compose build
$ docker-compose up
```

Then simply send a POST request to the backend:
```bash
$ curl --header "Content-Type: application/json" \
      --request POST \
      --data '{ "id": "1", "name": "John Doe" }' \
      http://localhost:8080/data
```

You should see a response in the console.
