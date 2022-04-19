# Spring-Boot-Study

### Entity cache flush 발생 조건
 - flush함수를 호출 했을때
 - 한 transaction이 끝났을때 
 - JPQL가 실행될때

### DB 트랜젝션내에 exception 처리 
 - runtimeException은 트랙젝션이 commit  되지 않아서 캐치를 안해도 된다.
 - checkedExceptiondms 트랜젝션이 커밋 되므로 롤백등의 기능은 캐치문을 통해 처리한다. 


### Stream 스터디
[함수형 프로그래밍 with Stream](https://aquatic-cord-161.notion.site/with-Stream-ddbf1574dec34b69bb4c33519e55df7b)

### 참고 자료

[DAO, DTO, Entity Class 개념](https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html)
