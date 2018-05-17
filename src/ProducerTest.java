import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;


public class ProducerTest {
 
    public static final String KAFKA_SERVER_URL = "localhost";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final String CLIENT_ID = "SampleProducer";
    
	public static void main (String[] args){
		Properties props = new Properties();
		props.put("zk.connect", "localhost:2181");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("metadata.broker.list", "localhost:9092");
		props.put("bootstrap.servers", KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
		props.put("client.id", CLIENT_ID);
		props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		//ProducerConfig config = new ProducerConfig(prop);
		
		//Producer producer = new Producer(config);
		//KafkaProducer<String, String> producer = new KafkaProducer(new ProducerConfig(props));
		//Producer<String, String> producer = new KafkaProducer<>(props);
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		
		String msg = "welcome";
		//producer.send(new KeyedMessage<String, String>("test", msg));
		producer.send(new ProducerRecord<String, String>("test", msg));
		
		//JSON
		Student kha = new Student("exception 1", 1234);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json = ow.writeValueAsString(kha);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producer.send(new ProducerRecord<String, String>("test", json));
		
		producer.close();
	}
}
