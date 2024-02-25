## Single Node Setup

Using this docker compose, the single node setup can be established in local.

Once the single node setup is done, we can connect to console-producer and console-consumer as below.

> docker ps
> 
> get the container_id of the kafka container

#### Creating a topic (single partition)
> docker exec -it <container_id> /bin/kafka-topics --create --topic my-topic --bootstrap-server localhost:9092


#### Console Producer (comes with Kafka)
> docker exec -it <container_id> /bin/kafka-console-producer --topic my-topic --bootstrap-server localhost:9092

#### Console Consumer (comes with Kafka)
> docker exec -it <container_id> /bin/kafka-console-consumer --topic my-topic --from-beginning --bootstrap-server localhost:9092


#### Adding Partitions (Alter Topic)
After creating a topic, later if we want to change the number of partitions we can use the below command.
>docker exec -it <container_id> /bin/kafka-topics --alter --topic my-topic --bootstrap-server localhost:9092 --partitions 3


#### Console Consumer to different partitions of the topic 

Once we created multiple partitions in the same single node setup, we can access the partitions separately using the console-consumer utility as below.

> docker exec -it <container_id> /bin/kafka-console-consumer --topic my-topic --from-beginning --bootstrap-server localhost:9092 --partition 0
> 
> docker exec -it <container_id> /bin/kafka-console-consumer --topic my-topic --from-beginning --bootstrap-server localhost:9092 --partition 1
> 
> docker exec -it <container_id> /bin/kafka-console-consumer --topic my-topic --from-beginning --bootstrap-server localhost:9092 --partition 2






#### Reference
https://kafka.apache.org/quickstart