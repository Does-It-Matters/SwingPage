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
