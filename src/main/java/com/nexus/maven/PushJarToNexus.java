package com.nexus.maven;

import com.litong.utils.file.FileUtil;
import com.litong.utils.file.JavaFileUtil;
import com.litong.utils.maven.Dependency;
import com.litong.utils.maven.MavenUtil;
import com.litong.utils.nexus.NexusUtil;

import java.net.URL;
import java.util.List;

/**
 * Created by litong on 2018/9/25 0025.
 */
public class PushJarToNexus {
  /**
   * 将jar包添加到nexus中
   * @param args
   */
  public static void main(String[] args) {
    //1.获取 resurces/jar下所有jar包的路径
    URL loaderPath = PushJarToNexus.class.getClassLoader().getResource("//");
    String jarFolerPath=loaderPath.toString()+"jar";
    // 获取文件的正确路径
    String absolutePath = FileUtil.getAbsolutePath(jarFolerPath);
    System.out.println(absolutePath);
    // 获取路径下的所有jar包
    List<String> jars = JavaFileUtil.findJar(absolutePath);
    System.out.println(jars);
    List<Dependency> dependencies = MavenUtil.parse(jars, absolutePath);
    for (Dependency dependency : dependencies) {
      String deployCommand = NexusUtil.getDeployCommand(dependency);
      System.out.println(deployCommand);
    }
    /*
将输出的命令复制到命令行

[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-deploy-plugin:2.7:deploy-file (default-cli) @ standalone-pom ---
Uploading: http://nexus.uairobot.com/nexus/content/repositories/thirdparty/com/oracle/ojdbc14/10.2.0.4.0/ojdbc14-10.2.0.4.0.jar
Uploaded: http://nexus.uairobot.com/nexus/content/repositories/thirdparty/com/oracle/ojdbc14/10.2.0.4.0/ojdbc14-10.2.0.4.0.jar (1520 KB at 4442.2 KB/sec)
Uploading: http://nexus.uairobot.com/nexus/content/repositories/thirdparty/com/oracle/ojdbc14/10.2.0.4.0/ojdbc14-10.2.0.4.0.pom
Uploaded: http://nexus.uairobot.com/nexus/content/repositories/thirdparty/com/oracle/ojdbc14/10.2.0.4.0/ojdbc14-10.2.0.4.0.pom (395 B at 11.7 KB/sec)
Downloading: http://nexus.uairobot.com/nexus/content/repositories/thirdparty/com/oracle/ojdbc14/maven-metadata.xml
Uploading: http://nexus.uairobot.com/nexus/content/repositories/thirdparty/com/oracle/ojdbc14/maven-metadata.xml
Uploaded: http://nexus.uairobot.com/nexus/content/repositories/thirdparty/com/oracle/ojdbc14/maven-metadata.xml (307 B at 9.1 KB/sec)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.583 s
[INFO] Finished at: 2018-09-27T09:05:04+08:00
[INFO] Final Memory: 9M/155M
     */

  }
}
