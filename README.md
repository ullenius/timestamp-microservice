# TimeStamp Microservice API
REST Timestamp microservice using JSON.

My solution (and Java implementation) of freeCodeCamp's Timestamp Microservice
API project.


# Full description
[source](https://curse-arrow.glitch.me/)

1. The API endpoint is `GET url/timestamp/date_string?`

2. A date string is valid if can be successfully parsed by `new Date(date_string)`.
Note that the unix timestamp needs to be an **integer** (not a string) specifying **milliseconds**.
In our test we will use date strings compliant with ISO-8601 (e.g. "2016-11-20") because this will ensure an UTC timestamp.

3. If the date string is **empty** it should be equivalent to trigger `new Date()`, i.e. the service uses the current timestamp.

4. If the date string is **valid** the api returns a JSON having the structure:
```javascript
{
  "unix": <date.getTime()>,
  "utc" : <date.toUTCString()>
}
```
For example:
```javascript
{
  "unix": 1479663089000,
  "utc": "Sun, 20 Nov 2016 17:31:29 GMT"
}
```
5. If the date string is **invalid** the API returns a JSON having the structure:
```javascript
{
  "error" : "Invalid Date"
}.
```

## Building
```sh
mvn package
```

## Requirements
* Java EE 8
* Java 8 Oracle/openJDK

## Other
Tested and works fine using Wildfly
