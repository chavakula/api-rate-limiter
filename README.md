# API Rate Limiter
API Rate limiter in spring boot using Bucket4j implementation (Simple rate limiter on API)

Step 1 : Run this project using mvn command or via IDE

Step 2 : Hit url http://localhost:9090/api/getdetails

Step 3 : Output should be "Hey Guys, the new rate limiting API" - it should give you 429 - Too many requests error when you hit API more than 20 times in 1 minute

Bucket4J Project: https://github.com/vladimir-bukhtoyarov/bucket4j 

Cheers!
