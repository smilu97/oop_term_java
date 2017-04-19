# Term Project2

## Author

* 김영진 2016025241
* 이진명 2016024979

## Introduction

핸드폰의 전화번호부와 관련된 기능들을 구현하는 데 필요한 API를 구현하였습니다.

## Dependency

* Gradle
* Gauva (Container package made by google)
* JSON (org.json package)

## Classes

중요한 클래스들만 설명합니다

### CallRecordContainer

CallRecord클래스 객체들을 저장하는 클래스입니다 fromNumber(String), toNumber(String)으로 인덱싱 합니다.

### SMSRecordContainer

SMSRecord클래스 객체들을 저장하는 클래스입니다 fromNumber(String), toNumber(String)으로 인덱싱 합니다.

### PersonContainer

Person클래스 객체들을 저장하는 클래스입니다. nickname(String), recent(Date), phoneNumber(String)으로 인덱싱합니다.

### Phone

CallRecordContainer, SMSRecordContainer, PersonContainer객체를 하나씩 가지고 입출력과 관련된 것들을 수행합니다.

## Save to local storage

JSON Format으로 변환하여 저장합니다. org.json 패키지를 사용합니다

## SRS

* [SRS](SRS.md)

## UML

![UML](/Users/gim-yeongjin/eclipse/workspace/OOPTerm/UML.png)