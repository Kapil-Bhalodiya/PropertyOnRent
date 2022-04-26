package com.example.credential.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Hazelcastconfig {
    @Bean
    public Config Hconfig(){
        return new Config().setInstanceName("hazelcast-instance")
                .addMapConfig(new MapConfig().setName("OTPMap")
                .setTimeToLiveSeconds(120));
    }
}
