# How to Run 
Please download the project and import it in spring STS and click on Run as SpringBoot application

# API to Check 
api follow the standard structure of appname/api/version/resourcename?queryParm
Ex : http://localhost:8080/searchApp/api/v1/search?geocode=40.41956,-3.69196

2 types of Query parms are supported 
1) geocode of location 
2) or cityname 

# Cahcing is supported and memcached is the cache used in this application
You can check the info logs for caching activity

