package com.aveline.www.salary.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@PropertySource("classpath:application.properties")
public class Config extends AbstractCouchbaseConfiguration {
//
//    @Autowired
//    private ApplicationContext context;

    @Autowired
    Environment env;

    @Override
    public String getConnectionString() {
        return env.getProperty("app.db.bootstrap-hosts");
    }

    @Override
    public String getUserName() {
        return env.getProperty("app.db.username");
    }

    @Override
    public String getPassword() {
        return env.getProperty("app.db.password");
    }

    @Override
    public String getBucketName() {
        return env.getProperty("app.db.bucketName");
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Override
//    public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
//        try {
//            mapping.mapEntity(EmployeeLeaveEntity.class,  getCouchBaseTemplate("employeeleave"));
//            mapping.mapEntity(SalaryEntity.class,  getCouchBaseTemplate("salary"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private CouchbaseTemplate getCouchBaseTemplate(String bucketName) throws Exception {
//        CouchbaseTemplate couchbaseTemplate = new CouchbaseTemplate(couchbaseClientFactory(bucketName),
//                mappingCouchbaseConverter(couchbaseMappingContext(customConversions()),
//                        new CouchbaseCustomConversions(Collections.emptyList())));
//        couchbaseTemplate.setApplicationContext(context);
//
//        return couchbaseTemplate;
//    }
//
//    private CouchbaseClientFactory couchbaseClientFactory(String bucketName){
//        return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()), bucketName, this.getScopeName());
//    }
}


