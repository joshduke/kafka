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


#### Describing the topic

> docker exec -it <container_id> /bin/kafka-topics --describe --topic my-topic --bootstrap-server localhost:9092
> 
> Topic: my-topic	TopicId: Lrf-QQSITrCtYGVILuxZTA	PartitionCount: 3	ReplicationFactor: 1	Configs:
> 
> Topic: my-topic	Partition: 0	Leader: 1	Replicas: 1	Isr: 1
> 
> Topic: my-topic	Partition: 1	Leader: 1	Replicas: 1	Isr: 1
> 
> Topic: my-topic	Partition: 2	Leader: 1	Replicas: 1	Isr: 1



#### Console Consumer to different partitions of the topic 

Once we created multiple partitions in the same single node setup, we can access the partitions separately using the console-consumer utility as below.

> docker exec -it <container_id> /bin/kafka-console-consumer --topic my-topic --from-beginning --bootstrap-server localhost:9092 --partition 0
> 
> docker exec -it <container_id> /bin/kafka-console-consumer --topic my-topic --from-beginning --bootstrap-server localhost:9092 --partition 1
> 
> docker exec -it <container_id> /bin/kafka-console-consumer --topic my-topic --from-beginning --bootstrap-server localhost:9092 --partition 2






#### Reference
https://kafka.apache.org/quickstart