package wzx.confige;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(EmbersMQProperties.class)
public class EmbersMQAutoConfiguration {

}
