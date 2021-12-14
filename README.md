# ratelimiter
Rate limiter in spring boot using Bucket4j implementation (API-KEY based subscription rate limiter)

Step 1 : Run this project using mvn command or via IDE

Step 2 : Hit url http://localhost:9090/api/getdetails using GET method in postman with request header "X-api-key" (check details of api-key related information in src\main\java\com\chavakula\ratelimiter\rules\PricingPlan.java)

Step 3 : Output should be "Hey Guys, the new rate limiting API"

Step 4 : Check response header "X-Rate-Limit-Remaining" for number of requests remaining.

Cheers!
