package cn.syrena.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.syrena.**.mapper")
public class OjSystemAppllication {

    public static void main(String[] args) {
        SpringApplication.run(OjSystemAppllication.class, args);
    }
}
