package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// root-context.xml 대체 클래스
@Configuration
@ComponentScan(basePackages = {"web"})
public class RootConfig {

}
