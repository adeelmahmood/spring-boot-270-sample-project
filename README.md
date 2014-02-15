spring-boot-270-sample-project
==============================


This is a sample project for spring boot issue 270

https://github.com/spring-projects/spring-boot/issues/270#issuecomment-33295910

The project uses spring boot for configuration and attemps to load a file from classpath. PropertyLauncher loader is used.

If you run the application from eclipse it works fine but if you compile a jar and run from command line it explicitly requires the application jar to be added to loader.path.

```
java -jar app-0.0.1-SNAPSHOT.jar
```
works fine

```
java -jar -Dloader.path=. app-0.0.1-SNAPSHOT.jar

Exception in thread "main" java.lang.NoClassDefFoundError: org/springframework/boot/CommandLineRunner
        at java.lang.ClassLoader.defineClass1(Native Method)
        at java.lang.ClassLoader.defineClass(Unknown Source)
        at java.security.SecureClassLoader.defineClass(Unknown Source)
        at java.net.URLClassLoader.defineClass(Unknown Source)
        at java.net.URLClassLoader.access$100(Unknown Source)
        at java.net.URLClassLoader$1.run(Unknown Source)
        at java.net.URLClassLoader$1.run(Unknown Source)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(Unknown Source)
        at org.springframework.boot.loader.LaunchedURLClassLoader.doLoadClass(LaunchedURLClassLoader.java:126)
        at org.springframework.boot.loader.LaunchedURLClassLoader.loadClass(LaunchedURLClassLoader.java:103)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:46)
        at java.lang.Thread.run(Unknown Source)
Caused by: java.lang.ClassNotFoundException: org.springframework.boot.CommandLineRunner
        at java.net.URLClassLoader$1.run(Unknown Source)
        at java.net.URLClassLoader$1.run(Unknown Source)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at org.springframework.boot.loader.LaunchedURLClassLoader.doLoadClass(LaunchedURLClassLoader.java:133)
        at org.springframework.boot.loader.LaunchedURLClassLoader.loadClass(LaunchedURLClassLoader.java:103)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        ... 14 more
```
doesnt works because it cant find the spring boot jar. changing that to

```
java -jar -Dloader.path=app-0.0.1-SNAPSHOT.jar app-0.0.1-SNAPSHOT.jar
```
works
