while true; do
  curl --header "Content-Type: application/json" --request POST --data '{ "name": "John Doe" }' http://127.0.0.1/data
  sleep 1
  echo "trying again..."
done