@echo off
set JAVA_HOME=C:\softwares\jdk1.8.0_101

set PATH=%JAVA_HOME%\bin;%PATH%;
java -jar "C:\workspace\sql-generator\target\sql-generator-1.0-SNAPSHOT-jar-with-dependencies.jar"
pause