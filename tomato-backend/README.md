To test backend please use this sample calls:

`curl --request POST \
   --url http://localhost:8080/sales/data \
   --header 'cache-control: no-cache'`
   
`curl --request GET \
   --url 'http://localhost:8080/sales/data?size=42' \
   --header 'cache-control: no-cache'`