package com.litong.utils.string;

import org.junit.Test;

/**
 * Created by litong on 2018/9/26 0026.
 */
public class StringUtilTest {

  @Test
  public void removePrefix() throws Exception {
    String jarPath="D:\\dev_workspace\\java\\litong_prject\\maven-util\\target\\classes\\jar\\com\\oracle\\ojdbc14" +
            "\\10.2.0.4.0\\ojdbc14-10.2.0.4.0.jar";
    String repodir="D:\\dev_workspace\\java\\litong_prject\\maven-util\\target\\classes\\jar\\";
    String s = StringUtil.removePrefix(jarPath, repodir);
    System.out.println(s);

  }
}