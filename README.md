# 이마트 AdTech, 개발 스터디

## 1. [스터디 가이드](./guide.md)

## 2. 개발 환경

- Spring boot - WebFlux 환경에서 구현
- 미들웨어 연동에 Docker 사용
- MacOS (M1 Mac)

## 3. 진행 사항

- MongoDB / Redis 연동
    - [1주차 회고](https://medium.com/@underwater2/webflux-1주차-스터디-975c82b774a2)
- MariaDB 연동 / Pagination 구현
    - [2주차 회고](https://medium.com/@underwater2/webflux-2주차-스터디-bd4e55ceb176)
- Kafka 연동
    - [Spring boot에서 Kafka cluster 사용하여 pub/sub 예제 구현하기](https://medium.com/@underwater2/spring-boot에서-kafka-cluster-사용하여-pub-sub-예제-구현하기-7c701f8ca0c4)
    - [[Kafka] Spring boot에서 @KafkaListener 동작하지 않는 오류 해결](https://medium.com/@underwater2/kafka-spring-boot에서-kafkalistener-동작하지-않는-오류-해결-77977a056197)
    - [[Kafka] 카프카 순서 보장 구현— 파티션키 지정](https://medium.com/@underwater2/kafka-카프카-순서-보장-구현-파티션키-지정-b532b7856df8)
- Resilience4j 적용
    - [[Resilience4j] Spring Webflux에서 Circuit breaker, Retry 모듈 적용, Actuator로 모니터링](https://medium.com/@underwater2/resilience4j-spring-webflux에서-circuit-breaker-모듈-적용하기-b29dfc93760d)
- Logging 구현
    - 메서드 시작 전, 후에 Logging
    - [[ELK Stack 에러] Kibana server is not ready yet.](https://medium.com/@underwater2/elk-stack-에러-kibana-server-is-not-ready-yet-0b3314b488f4)
    - [[MDC/Filebeat/ELK stack] Webflux에서 로그에 UUID 표기 후 ELK stack으로 전송하기 (1)](https://medium.com/@underwater2/mdc-filebeat-elk-stack-webflux에서-로그에-uuid-표기-후-elk-stack으로-전송하기-1-3c68cfd891ce)
    - [[MDC/Filebeat/ELK stack] Webflux에서 로그에 UUID 표기 후 ELK stack으로 전송하기 (2)](https://medium.com/@underwater2/mdc-filebeat-elk-stack-webflux에서-로그에-uuid-표기-후-elk-stack으로-전송하기-2-e2e017c33090)
    - [[MDC/Filebeat/ELK stack] Webflux에서 로그에 UUID 표기 후 ELK stack으로 전송하기 (3)](https://medium.com/@underwater2/mdc-filebeat-elk-stack-webflux에서-로그에-uuid-표기-후-elk-stack으로-전송하기-3-4cc4e6b7e87a)
- Kafka 메시지 객체로 Protobuf 적용
    - [[Protobuf/Kafka] Docker-compose로 구성된 Kafka Cluster에 Schema Registry 추가하기](https://medium.com/@underwater2/kafka-docker-compose로-구성된-kafka-cluster에-schema-registry-추가하기-011700ed488d)
    - [[Protobuf/Kafka] Spring Webflux에서 Kafka 메시지 전달에 Protobuf 사용하기 (Schema Registry 미사용)](https://medium.com/@underwater2/protobuf-kafka-spring-webflux에서-kafka-메시지-전달에-protobuf-사용하기-schema-registry-미사용-250ffc4f6fda)
    - [[Protobuf] 상속(inheritance) 구현](https://medium.com/@underwater2/protobuf-상속-inheritance-구현-9ff28b6bbcb8)