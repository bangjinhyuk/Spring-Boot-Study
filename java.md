# JAVA

## 제네릭 클래스

클래스명<T> 로 넣어주어 나중에 선언했을때 명시 해줄수 있다.

하지만 제한이 없어 아무거나 넣을수 있음

따라서 다음과 같은 extends 방식으로 하는것을 추천

```java
    public abstract class Material{
        public abstract void doPrinting();
    }
    
    public class Powder extends Material{
        //내용
    
        @Override
        public void doPrinting(){
            //TODO 
        }
    }
    
    public class Plastic extends Material{
        //내용
    
        @Override
        public void doPrinting(){
            //TODO 
        }
    }
    public class Printer<T> {
        //내용
    
        @Override
        public void doPrinting(){
            T material;
            
            void setMaterial(T material){
                this.material = material; 
            }
        }
    }

```

제네릭 메서드 활용하기

public <자료형 매개 변수> 반환형 메서드 이름 (파라미터){}

# Iterator

컬렉션.iterator();

```java
    Iterator<Member> ir = arrayList.iterator();
    while(ir.hasNext()){
            Member member = ir.next();
            ...
    }
```

****Foreach****

• 컬렉션의 항목을 순회하기 위한 것

****Iterator****

• 컬렉션 프레임 워크에서 컬렉션을 탐색하고 컬렉션의 항목에 대한 순차적 액세스를 위해 제공하는 인터페이스

## 함수형 프로그래밍

매개 변수를 받아 함수를 실행하므로 side effect가 없음, 동일 한 자료에 동일한 결과를 보장

여러 함수가 실행되는 병렬처리가 가능해 진다.

### 람다식 문법

```java
    int add(int x, int y){
            return x+y;
    }
    
    //람다식
    (int x , int y) -> {return x+y;}
    
    //매개 변수가 하나인 경우 자료형과 왼쪽괄호 생략가능
    x -> {return x+y;}
    
    // 실행문이 한문장인 경우 중괄호 (오른쪽), return 생략 가능
    (int x , int y) -> x+y;
    
    Add 인터페이스에 
    int add(int x, int y) 라는 메서드 생성
    
    Add add = (x,y) -> {return x+y;};
    System.out.println(add)
```