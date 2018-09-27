package com.litong.utils.maven;

import com.litong.utils.file.FileUtil;
import com.litong.utils.string.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by litong on 2018/9/26 0026.
 * maven 工具类
 */
public class MavenUtil {

  /**
   * 将 jar中的全路径转成成实体类
   *
   * @param jars
   * @return
   */
  public static List<Dependency> parse(List<String> jars, String repodir) {
    List<Dependency> dependencies = new ArrayList<>();
    for (String jar : jars) {
      Dependency dependency = getDependency(jar, repodir);
      dependencies.add(dependency);
    }
    return dependencies;
  }

  /**
   * get Dependency
   *
   * @param jarAbsolutePath absolute path
   * @param repodir         absolute path
   * @return
   */
  public static Dependency getDependency(String jarAbsolutePath, String repodir) {
    // 去除 jar absolute path 中repodir部分
    File jarFile = new File(jarAbsolutePath);
    File repodirFile = new File(repodir);
    String jarPath = FileUtil.getAbsolutePath(jarFile);
    String repodirPath = FileUtil.getAbsolutePath(repodirFile);
    String all = StringUtil.removePrefix(jarPath, repodirPath); //all = com\oracle\ojdbc14\10.2.0.4.0\ojdbc14-10.2.0.4.0
    // .jar
    String[] splits = StringUtil.splitPath(all);
    String jarNmae = splits[splits.length - 1];
    //获取 version and artifactid
    String version = getVersion(jarNmae);
    String artifactid = getArtifactid(jarNmae);
    // remote com.ojdbc14\10.2.0.4.0\ojdbc14-10.2.0.4.0.jar
    all = StringUtil.removeSuffix(all, "\\" + artifactid + "\\" + version + "\\" + jarNmae); //==> all = \com\ojdbc14
    all = StringUtil.removePrefix(all, "\\");
    String groupid = all.replace("\\", ".");//==> all= com.ojdbc4

    // 构造返回值返回
    Dependency dependency = new Dependency();
    dependency.setArtifactid(artifactid);
    dependency.setVarsion(version);
    dependency.setGruopid(groupid);
    dependency.setFilePath(jarPath);
    return dependency;
  }


  /**
   * 根据 jar包 全名 获取 artifactid
   *
   * @param jar ojdbc14-10.2.0.4.0.jar
   * @return
   */
  public static String getArtifactid(String jar) {
    String[] strings = jar.split("-");
    return strings[0];
  }

  /**
   * 根据jar包全名获取 Version
   *
   * @param jar ojdbc14-10.2.0.4.0.jar
   * @return
   */
  public static String getVersion(String jar) {
    String[] strings = jar.split("-");
    String version = StringUtil.removeSuffix(strings[1], ".jar");
    return version;
  }
}
