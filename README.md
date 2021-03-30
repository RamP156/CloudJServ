# CloudJServe
A multi-threaded Java Web Server

## Build
`mvn clean install`

## Usage 1
By default, it runs on port 8080 with thread pool size 5.
`java -jar CloudJServ-1.0-SNAPSHOT.jar`
## Usage 2
Run with specific port with default thread pool.
`java -jar CloudJServ-1.0-SNAPSHOT.jar <port>`

## Usage 3
Run with specific port and thread pool size.
`java -jar CloudJServ-1.0-SNAPSHOT.jar <port> <threadPoolSize>`