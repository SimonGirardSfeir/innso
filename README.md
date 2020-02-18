How to execute the application : 

```
mvn clean package install
java -jar target/app.jar
```

Now, it runs on http://localhost:8080/

Go to Postman and try the following requests, in this order :

```
http://localhost:8080/messages/addMessage POST
```

With body:
```
{
    "clientName": "Jérémy Durand",
    "content": "J'ai un problème avec mon téléphone",
    "channel" : "SMS"
}
```

A message is created, but without customer file, asociated. So let's asociate a customer file to the last message. 
```
http://localhost:8080/customer-file/addCustomerFile POST
```
Without body. 

Now, we want to add a new message to this customer file, with a reference:
```
http://localhost:8080/messages/helpClient  POST
{
    "authorName": "Sonia Dupont",
    "content": "Bonjour que puis je faire pour vous ?",
    "channel": "FACEBOOK"
}
```

Now, we have to put a reference on the customer file. So let's do this:

```
http://localhost:8080/customer-file/update POST
{
    "reference: "123ABC"
}
```

And we get datas with the following request:

```
http://localhost:8080/customer-file/listCustomerFiles GET
```
