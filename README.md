# chaos-monkey-demo

To stress-test resilency and performance of a small-scale Spring Boot application.

## Usage

Add dependency to enable Chaos Monkey library

```
<dependency> 
    <groupId>de.codecentric</groupId>
    <artifactId>chaos-monkey-spring-boot</artifactId>
    <version>2.3.0-SNAPSHOT</version>
    <type>pom</type>
</dependency>
```

### Run application

From Maven 
```
./mvnw spring-boot:run
```

## More on the Chaos Engineering methodology

https://github.com/Netflix/chaosmonkey
</br>
https://github.com/pingcap/chaos-mesh
</br>
https://techcrunch.com/2018/02/04/the-rise-of-chaos-engineering/
</br>
[Why should chaos be part of your distributed systems engineering?](https://medium.com/@bbideep/why-should-chaos-be-part-of-your-distributed-systems-engineering-5bcb21497660)
</br>
[Break Things On Purpose podcast](https://podcasts.apple.com/us/podcast/break-things-on-purpose/id1460542551 )

