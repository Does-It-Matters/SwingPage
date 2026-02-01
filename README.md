# SwingPage
## 프레임워크를 파헤쳐보다 
개발자가 시스템에 로직을 전달해주면 시스템이 해결한다. 

## Framework 모듈 
- core(역할 정의) 
  - event: 각 페이지에 매핑되는 이벤트 역할 정의
  - page
    - presentation
      - page: 제목과 패널을 가진 '페이지' 정의
      - controller: 서비스 객체에게 도메인 작업 처리를 맡기고 결과에 대한 이벤트 발행
    - cookie: 페이지 간 데이터를 공유 (옵션)  
    - application (옵션)
      - service
  - loader
    - event publisher: 이벤트 발행 
    - event listener: 수신자 역할 정의 
    - event bus: 이벤트 발행자와 수신자의 Observer (pub-sub 패턴)
    - page loader: 이벤트에 매핑되는 화면 표현 
    - page registry: 페이지와 이벤트 매핑 저장소 
- loader(역할 수행)
  - event publisher: 생성자로 이벤트 버스를 받고, 이벤트를 발행
  - page loader with listener: 이벤트를 수신하고, 페이지 로더를 활용하여 해당 페이지 표현
  - page event bus: 발행자와 수신자 매개체 
  - page loader provider: 이벤트와 페이지 매핑을 빌더 패턴으로 수행
  - page registry: 매핑을 실제로 수행 

## 개발자가 개발할 파트 
- 구체적인 이벤트 
- 컨트롤러와 페이지 
- (프레임워크 모듈의) page loader provider에 이벤트와 페이지 조립 

## 배포 단위 분리

본 프로젝트는 Gradle 멀티 모듈 구조를 사용하며,
각 모듈은 독립적인 배포 단위(JAR)로 빌드된다.

### 개발자 영역
- dev_event 모듈: 개발자가 정의하는 이벤트 계층
- dev_page 모듈: 개발자가 정의하는 페이지 계층

### 프레임워크 영역
- framework 모듈: 페이지 전환, 이벤트 디스패치 등
  프레임워크 내부 동작을 담당

## 스택 활용
- 개발자 화면 코드는 그대로인 채 앞으로 가기, 뒤로 가기 구현 