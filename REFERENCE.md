# CallRecord

```java
public class CallRecord {
  Integer id; // 고유번호
  String fromNunber; // 발신자 번호
  String toNumber; // 수신자 번호
  ...
}
```

각각의 자료에 대해서 Getter는 public, Setter는 protected로 되어있다.

## CallRecordComparator

id를 기준으로 하는 Comparator

## CallRecordContainer

`CallRecord`를 저장한다. `id`, `fromNumber`, `toNumber` 로 인덱싱한다.

인덱싱된 트리의 순회는 각각 `iterator`, `fromNumberIterator`, `toNumberIterator`를 이용해 `Iterator` 객체를 이용하면 된다.

### add (Method)

추가 메소드

### del (Method)

삭제 메소드

### find~ (Method) : NavigableSet<~>

어떤 한 개의 컬럼을 기준으로 탐색하여 `NavigableSet<~>`를 반환한다. 

# Person

```java
public class Person {
  Integer id; // 고유번호
  String nickname; // 이름
  String phoneNumber; // 전화번호
  Date recent; // 최근 이벤트 일자
  ...
}
```

각각의 자료에 대해서 Getter는 public, Setter는 protected로 되어있다.

## PersonComparator

id를 기준으로 하는 Comparator

## PersonContainer

`PersonRecord`를 저장한다. `id`, `nickname`, `phoneNumber`, `recent` 로 인덱싱한다.

인덱싱된 트리의 순회는 각각 `iterator`, `nicknameIterator`, `phoneNumberIterator`, `recentIterator`를 이용해 `Iterator` 객체를 이용하면 된다.

### add (Method)

추가 메소드

### del (Method)

삭제 메소드

### find~ (Method) : NavigableSet<~>

어떤 한 개의 컬럼을 기준으로 탐색하여 `NavigableSet<~>`를 반환한다.

# SMSRecord

```java
public class SMSRecord {
	Integer id;
	String fromNumber;
	String toNumber;
	String content;
  ...
}
```

각각의 자료에 대해서 Getter는 public, Setter는 protected로 되어있다.

## SMSRecordComparator

id를 기준으로 하는 Comparator

## SMSRecordContainer

`SMSRecord`를 저장한다. `id`, `fromNumber`, `toNumber` 로 인덱싱한다.

인덱싱된 트리의 순회는 각각 `iterator`, `fromNumberIterator`, `toNumberIterator`를 이용해 `Iterator` 객체를 이용하면 된다.

### add (Method)

추가 메소드

### del (Method)

삭제 메소드

### find~ (Method) : NavigableSet<~>

어떤 한 개의 컬럼을 기준으로 탐색하여 `NavigableSet<~>`를 반환한다.