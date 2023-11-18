package com.techguyash.gkeep;

import com.azure.security.keyvault.secrets.SecretClient;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Data
public class GoogleKeepCloneBackendApplication
{
    private final SecretClient secretClient;

    @Value("${user.test}")
    private String userString;

    public static void main(String[] args)
    {
        SpringApplication.run(GoogleKeepCloneBackendApplication.class, args);
    }

    @PostConstruct
    public void loadKV()
    {
        //String value = secretClient.getSecret("db-password").getValue();
        System.out.println("DB url retrieved :"+userString);
    }

}
