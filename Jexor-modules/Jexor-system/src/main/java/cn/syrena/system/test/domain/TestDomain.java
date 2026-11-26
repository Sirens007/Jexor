package cn.syrena.system.test.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_test")
public class TestDomain {
    private Integer testId;
    private String title;
    private String content;
}
