set LIB_PATH=user-service-test\target\lib
set LIB=%LIB_PATH%\commons-io-2.7.jar;^
%LIB_PATH%\commons-lang3-3.11.jar;^
%LIB_PATH%\jackson-annotations-2.14.0.jar;^
%LIB_PATH%\jackson-core-2.14.0.jar;^
%LIB_PATH%\jackson-databind-2.14.0.jar;^
%LIB_PATH%\jackson-datatype-jdk8-2.13.4.jar;^
%LIB_PATH%\jackson-datatype-jsr310-2.13.4.jar;^
%LIB_PATH%\jackson-module-parameter-names-2.13.4.jar;^
%LIB_PATH%\jakarta.annotation-api-1.3.5.jar;^
%LIB_PATH%\jul-to-slf4j-1.7.36.jar;^
%LIB_PATH%\log4j-api-2.17.2.jar;^
%LIB_PATH%\log4j-to-slf4j-2.17.2.jar;^
%LIB_PATH%\logback-classic-1.2.11.jar;^
%LIB_PATH%\logback-core-1.2.11.jar;^
%LIB_PATH%\netty-buffer-4.1.85.Final.jar;^
%LIB_PATH%\netty-codec-4.1.85.Final.jar;^
%LIB_PATH%\netty-codec-dns-4.1.85.Final.jar;^
%LIB_PATH%\netty-codec-http-4.1.85.Final.jar;^
%LIB_PATH%\netty-codec-http2-4.1.85.Final.jar;^
%LIB_PATH%\netty-codec-socks-4.1.85.Final.jar;^
%LIB_PATH%\netty-common-4.1.85.Final.jar;^
%LIB_PATH%\netty-handler-4.1.85.Final.jar;^
%LIB_PATH%\netty-handler-proxy-4.1.85.Final.jar;^
%LIB_PATH%\netty-resolver-4.1.85.Final.jar;^
%LIB_PATH%\netty-resolver-dns-4.1.85.Final.jar;^
%LIB_PATH%\netty-resolver-dns-classes-macos-4.1.85.Final.jar;^
%LIB_PATH%\netty-resolver-dns-native-macos-4.1.85.Final-osx-x86_64.jar;^
%LIB_PATH%\netty-transport-4.1.85.Final.jar;^
%LIB_PATH%\netty-transport-classes-epoll-4.1.85.Final.jar;^
%LIB_PATH%\netty-transport-native-epoll-4.1.85.Final-linux-x86_64.jar;^
%LIB_PATH%\netty-transport-native-unix-common-4.1.85.Final.jar;^
%LIB_PATH%\reactive-streams-1.0.4.jar;^
%LIB_PATH%\reactor-core-3.4.25.jar;^
%LIB_PATH%\reactor-netty-core-1.0.25.jar;^
%LIB_PATH%\reactor-netty-http-1.0.25.jar;^
%LIB_PATH%\resilience4j-annotations-1.5.0.jar;^
%LIB_PATH%\resilience4j-bulkhead-1.5.0.jar;^
%LIB_PATH%\resilience4j-circuitbreaker-1.5.0.jar;^
%LIB_PATH%\resilience4j-circularbuffer-1.5.0.jar;^
%LIB_PATH%\resilience4j-consumer-1.5.0.jar;^
%LIB_PATH%\resilience4j-core-1.5.0.jar;^
%LIB_PATH%\resilience4j-framework-common-1.5.0.jar;^
%LIB_PATH%\resilience4j-micrometer-1.5.0.jar;^
%LIB_PATH%\resilience4j-ratelimiter-1.5.0.jar;^
%LIB_PATH%\resilience4j-retry-1.5.0.jar;^
%LIB_PATH%\resilience4j-spring-1.5.0.jar;^
%LIB_PATH%\resilience4j-spring-boot2-1.5.0.jar;^
%LIB_PATH%\resilience4j-timelimiter-1.5.0.jar;^
%LIB_PATH%\slf4j-api-1.7.30.jar;^
%LIB_PATH%\snakeyaml-1.30.jar;^
%LIB_PATH%\spring-aop-5.3.24.jar;^
%LIB_PATH%\spring-beans-5.3.24.jar;^
%LIB_PATH%\spring-boot-2.7.6.jar;^
%LIB_PATH%\spring-boot-autoconfigure-2.7.6.jar;^
%LIB_PATH%\spring-context-5.3.24.jar;^
%LIB_PATH%\spring-core-5.3.24.jar;^
%LIB_PATH%\spring-expression-5.3.24.jar;^
%LIB_PATH%\spring-jcl-5.3.24.jar;^
%LIB_PATH%\spring-web-5.3.24.jar;^
%LIB_PATH%\spring-webflux-5.3.24.jar;^
%LIB_PATH%\vavr-0.10.2.jar;^
%LIB_PATH%\vavr-match-0.10.2.jar

set CP=user-service-test\target\classes;%LIB%
set volume=%1

if "%volume%" == "" set volume=10

for /l %%a in (1, 1, %volume%) do (
  start /b one-test.cmd
)

exit /b 0

