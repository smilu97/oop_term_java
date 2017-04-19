# OOP Term2 Java Application - Phonebook app Software Requirements Specification

## Introduction

본 어플리케이션은, 한양대학교 2017년 객체지향 프로그래밍 수업 2번째 팀프로젝트의 일환으로, 기존 스마트폰에 탑재되어있는 일반적인 전화번호부 어플리케이션의 기능을 그대로 재현해보기 위한 것이다.

기획 성격은 Android 모바일 운영체재에 기본적으로 동봉된 전화번호부 앱을 모방하는 것에 기초한다.

## Overview of document

[TOC]

### Purpose

전화는 사람들의 의사소통에 필요한 비용을 획기적으로 줄여주었으나, 국내 기준으로 11자리정도의 정수를 사람마다 외워야 한다는 단점이 있었다. 이를 극복하기 위해, 전화번호를 기록하는 데에 특화된 종이 기록지나 전자 프로그램들이 개발되다. 하지만 현재에는 전화 기능 자체가 스마트폰이라는 플랫폼 위에 놓여지게 되면서 전화번호를 외우고 다닐 필요가 없어졌으며, 이러한 변화에 가장 직접적인 영향을 준 것이 이 전화번호부 어플리케이션이다.

본 프로젝트에서는 이 전화번호부 어플리케이션을 개발한다.

### References

본 프로젝트에 있어서 참고하게 될 것으로 보이는 문서들은 아래와 같다.

* https://docs.oracle.com/javase/8/docs/api/
* https://developer.android.com/reference/packages.html

## System environment

* OS: Android 23
* Testing machine: Nexus 5X API 23 (1080 x 1920): 420dpi in AVD with HAXM

## Glossary

| Name         | Content          |
| ------------ | ---------------- |
| Caller       | 전화한 사람           |
| Recordee     | 전화번호부에 기록되는 사람   |
| Person       | 연락처              |
| SMS Record   | 문자 기록            |
| Call Record  | 통화 기록            |
| Sender       | 발신인              |
| Receiver     | 수신인              |
| Owner        | 주요 사용자. 핸드폰의 소유주 |
| Phone number | 전화번호             |
| Nickname     | 전화번호부에 저장되는 이름   |

## Functional requirements specification

### Add person

저장소에 Person를 추가한다. Phone number와 Nickname을 필수로 받는다.

### List up people

저장소의 Person리스트를 특정 순서로 나열한다.

나열 기준에는 `가나다(알파벳)순`, `전화번호순`, `최근 연락한 순` 등이 있다.

아래의 Find person기능과 동시에 적용될 수 있다.

### Find person

특정 정보와 부합하는 person만을 리스트업 한다.

위의 List up people기능과 동시에 적용될 수 있다.

### Update person

List up people에서 보여준 리스트에서 특정 Person를 선택하여, 정보를 수정할 수 있게 한다.

### Delete address

List up people에서 보여준 리스트에서 특정 Person를 선택하여, Person를 저장소에서 제외할 수 있도록 한다.



