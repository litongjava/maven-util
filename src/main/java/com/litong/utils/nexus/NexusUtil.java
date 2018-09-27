package com.litong.utils.nexus;

import com.litong.utils.maven.Dependency;

/**
 * Created by litong on 2018/9/26 0026.
 */
public class NexusUtil {

  // url: nexus地址
  private static String url="http://nexus.uairobot.com/nexus/content/repositories/thirdparty/";
  // repositoryId : 仓库
  private static String repositoryId="thirdparty";

  public static String getUrl() {
    return url;
  }

  public static void setUrl(String url) {
    NexusUtil.url = url;
  }

  public static String getRepositoryId() {
    return repositoryId;
  }

  public static void setRepositoryId(String repositoryId) {
    NexusUtil.repositoryId = repositoryId;
  }

  /**
   * mvn deploy:deploy-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.4.0 \
   * -Dpackaging=jar -Dfile=ojdbc14.jar
   * -Durl=http://192.168.28.214:8082/nexus/content/repositories/thirdparty/ -DrepositoryId=thirdparty
   * @param dependency
   * @return 执行的命令
   */
  public static String getDeployCommand(Dependency dependency){
    StringBuffer stringBuffer=new StringBuffer();
    stringBuffer.append("mvn deploy:deploy-file")
            .append(" -DgroupId="+dependency.getGruopid())
            .append(" -DartifactId="+dependency.getArtifactid())
            .append(" -Dversion="+dependency.getVarsion())
            .append(" -Dpackaging=jar ")
            .append(" -Dfile="+dependency.getFilePath())
            .append(" -Durl="+url)
            .append(" -DrepositoryId="+repositoryId);
    String command = stringBuffer.toString();
    return command;
  }
}
