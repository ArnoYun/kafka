package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;



public class Producer_class {
    private static final String bootstrapServers = "192.168.56.102:9092";

    public static Producer<String,String> createProducer(int producerId) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "PRODUCER IDENTIFICATION NUMBER " + producerId);
        Producer<String,String> producer = new KafkaProducer<>(properties);
        System.out.println("Producer created\n");
        return producer;
    }

    public static void sendMessage(Producer<String,String> producer, String topic, String message){
//        try{
//            for(int i = 0; i < messages.size(); i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
                producer.send(record);
                System.out.println("Message has been sent\n");
//            }
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        finally {
//            producer.close();
//        }

    }





    }


