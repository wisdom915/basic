package com.basic;

import org.mybatis.generator.api.ShellRunner;

/**
 * @author wangzhi
 * @date 2018/10/26.
 * @email 1164760152@qq.com
 */
public class MybatisGenerator {

  public static void main(String[] args) {
    args = new String[] { "-configfile", "basic-web\\src\\main\\resources\\auto-config\\mybatis-generator.xml", "-overwrite" };
    ShellRunner.main(args);
  }

}
