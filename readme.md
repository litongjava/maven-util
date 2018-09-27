1.使用mvn命令将jar包退推送到私服,后来发现,在pom.xml添加下面的配置即可

<dependency>
    <groupId>com.oracle</groupId>
	<artifactId>ojdbc6</artifactId>
	<version>12.1.0.1-atlassian-hosted</version>
</dependency>


