package com.roncoo.eshop.cache.kafka;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;



public class KafkaConsumer implements Runnable{
	
	private static String locationConsumer = "consumer.properties";//配置文件位置
	private ConsumerConnector consumerConnector;
	private String topic;

	public KafkaConsumer(String topic) {
		this.consumerConnector = Consumer.createJavaConsumerConnector(createConsumerConfig());
		this.topic = topic;
	}
	
	@SuppressWarnings("rawtypes")
	public void run() {
		
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, 1);

		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector
				.createMessageStreams(topicCountMap);
		List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
		
		for (KafkaStream stream : streams) {
			new Thread(new KafkaMessageProcessor(stream)).start();
		}
		
	}
	
	/**
	 * 创建kafka cosumer config
	 * @return
	 */
	private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "192.168.1.210:2181,192.168.1.211:2181,192.168.1.212:2181");
        props.put("zookeeper.session.timeout.ms", "40000");
		props.put("zookeeper.connection.timeout.ms", "1000000");
        props.put("zookeeper.sync.time.ms", "200");
		props.put("group.id", "eshop-cache-group");
        props.put("auto.commit.interval.ms", "1000");
        return new ConsumerConfig(props);
    }
	

	/**
	 * 创建kafka cosumer config
	 * @return
	 * @throws IOException 
	 */
	private static ConsumerConfig createConsumerConfig2() throws IOException {
		Properties props = new Properties();
		props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(locationConsumer));
		return new ConsumerConfig(props);
	}
	
	private static Properties initProperties() {
		
        Properties props = new Properties();
        props.put("zookeeper.connect", "192.168.1.210:2181,192.168.1.211:2181,192.168.1.212:2181");
        props.put("zookeeper.session.timeout.ms", "40000");
		props.put("zookeeper.connection.timeout.ms", "1000000");
        props.put("zookeeper.sync.time.ms", "200");
		props.put("group.id", "eshop-cache-group");
        props.put("auto.commit.interval.ms", "1000");
        
        return props;
	}
	
	public static void main(String[] args) throws IOException {
		initProperties();
		
		Properties props = new Properties();
		props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(locationConsumer));
		System.out.println(props);
	}
	
	
}
