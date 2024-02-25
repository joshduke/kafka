## Single Node Setup

Using this docker compose, the single node setup can be established in local.

Once the single node setup is done, we can connect to console-producer and console-consumer as below.

> docker ps
> 
> get the container_id of the kafka container
> 
> docker exec -it <container_id> /bin/kafka-topics --create --topic my-topic --bootstrap-server localhost:9092
> 
> docker exec -it <container_id> /bin/kafka-console-producer --topic my-topic --bootstrap-server localhost:9092
> 
> docker exec -it <container_id> /bin/kafka-console-consumer --topic my-topic --from-beginning --bootstrap-server localhost:9092


Using the above commands we can
- Create a topic
- Connect to broker as producer (using the console-producer utility)
- Connect to broker as consumer (using the console-consumer utility)


#### Reference
https://kafka.apache.org/quickstart