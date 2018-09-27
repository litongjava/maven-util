package com.litong.utils.maven;

import org.junit.Test;

import java.io.File;

/**
 * Created by litong on 2018/9/26 0026.
 */
public class MavenUtilTest {

  @Test
  public void testSplit(){
    String separator= File.separator;
    System.out.println(separator);
  }

  String jar="ojdbc14-10.2.0.4.0.jar";
  @Test
  public void getArtifactid(){
    String artifactid = MavenUtil.getArtifactid(jar);
    System.out.println(artifactid);
  }
  @Test
  public void getVersion(){
    String version = MavenUtil.getVersion(jar);
    System.out.println(version);
  }

  @Test
  public void getDependency(){
    String jarPath="D:\\dev_workspace\\java\\litong_prject\\maven-util\\target\\classes\\jar\\com\\oracle\\ojdbc14" +
            "\\10.2.0.4.0\\ojdbc14-10.2.0.4.0.jar";
    String repodir="D:\\dev_workspace\\java\\litong_prject\\maven-util\\target\\classes\\jar\\";
    Dependency dependency = MavenUtil.getDependency(jarPath, repodir);
    System.out.println(dependency);
  }
}