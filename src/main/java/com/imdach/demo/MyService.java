package com.imdach.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import groovy.lang.GroovyClassLoader;
import org.apache.commons.io.FileUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.UUID;

/**
 * Created By Arthur Zhang at 2022/3/15
 */

@Service
public class MyService {
    @Resource
    private MongoTemplate mongoTemplate;

    void insert() {

        GroovyClassLoader groovyClassLoader = null;
        try {
            groovyClassLoader = new GroovyClassLoader();
            File f = new File("/Users/arthur/cvt_dev/java/groovy-demo-project/src/main/test.groovy");

            Class<? extends BaseClazz> dataModelClazz = groovyClassLoader.parseClass(FileUtils.readFileToString(f));
            JSONObject data = new JSONObject();
            data.put("id", UUID.randomUUID().toString());
            data.put("enterpriseCode", "foo");

            System.out.println(dataModelClazz);
            BaseClazz model = JSON.toJavaObject(data, dataModelClazz);
//            System.out.println(model);
//            BaseClazz newModel = mongoTemplate.insert(model, "test_ya");
            JSONObject toInsert = JSONObject.parseObject(JSONObject.toJSONString(model));
//
            JSONObject newObj = mongoTemplate.insert(toInsert, "test_ya");
            System.out.println("insert done " + newObj);
//            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
//            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
//            MongoClientSettings clientSettings = MongoClientSettings.builder()
//                    .applyConnectionString(new ConnectionString("mongodb://localhost:27017"))
//                    .codecRegistry(codecRegistry)
//                    .build();
//
//            try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
//                MongoDatabase mongoDatabase = mongoClient.getDatabase("seewo_easi_pass");
//                MongoCollection collection = mongoDatabase.getCollection("test_ya", dataModelClazz);
//                InsertOneResult result = collection.insertOne(model);
//                System.out.println(result);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            groovyClassLoader.clearCache();
//            SerializeConfig.getGlobalInstance().clearSerializers();
//            ParserConfig.getGlobalInstance().clearDeserializers();
        }
    }
}
