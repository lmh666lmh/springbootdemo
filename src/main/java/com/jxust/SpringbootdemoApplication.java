package com.jxust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//排除自动注入数据源的配置（取消数据库配置）
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
//@SpringBootApplication已经包含了@Configuration、@EnableAutoConfiguration、@ComponentScan了。
//@ComponentScan(basePackages="com.jxust")
//解决问题的关键就是，要了解spring jpa的运行机制，
// 默认情况下spring jpa只会扫描启动类所在的包和子包中的Dao类。
// 所以如果Dao类不在启动类的包或者子包中，就需要用到@EnableJpaRepositories注解了。
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}

