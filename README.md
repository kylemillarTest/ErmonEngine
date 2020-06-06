docker run -d -p 8000:8000 amazon/dynamodb-local -jar DynamoDBLocal.jar -sharedDb

aws dynamodb create-table --table-name Table --attribute-definitions AttributeName=PK,AttributeType=S AttributeName=SK,AttributeType=S --key-schema AttributeName=PK,KeyType=HASH AttributeName=SK,KeyType=RANGE --billing-mode PAY_PER_REQUEST --endpoint-url http://localhost:8000

aws dynamodb list-tables --endpoint-url http://localhost:8000
aws dynamodb scan --table Table --endpoint-url http://localhost:8000