## Run local development environment
1. Run `mvn clean install` to compile/build the application
2. Run `java -jar target/Transactions-1.0-SNAPSHOT.jar server` to start the service

#Endpoints

Create customer
 
POST    /api/customer 

{
	"firstName":"Arindam",
	"lastName":"Das",
	"email":"ps_ard@hotmail.com"
}

Fetch customer

GET     /api/customer/{email} 

Create account

POST    /api/customer/{email}/account 

{
	"accountNickName":"primaryx",
	"balance":2000
}


Transfer amount

POST    /api/transaction 

{
	"fromAccount":{
		"email":"as_ard@hotmail.com",
		"nickName":"primary"
	},
	"toAccount":{
		"email":"ps_ard@hotmail.com",
		"nickName":"primary"
	},
	"amount":100
}