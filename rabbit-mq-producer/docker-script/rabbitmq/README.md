
## 참고자료 
- docker script<br>
  - [docker hub](https://hub.docker.com/_/rabbitmq)<br>
- docker compose<br>
  - [Learning RabbitMQ](https://kdevkr.github.io/learning-rabbitmq/)<br>

## Overview
> 참고) [RabbitMQ docker hub](https://hub.docker.com/_/rabbitmq) 의 내용을 요약함
RabbitMQ 이미지의 디폴트 포트는 5672 이다. RabbitMQ 의 어드민 플러그인 같은 존재인 Management Plugin 의 디폴트 포트는 15672 이다.<br>
<br>
만약 [Management Plugin](https://www.rabbitmq.com/management.html) 이 적용된 이미지를 적용하려면 뒤에 '-management'라는 이름이 붙은 태그를 사용하면 된다. Management Plugin 이 적용된 이미지의 디폴트 ID/PW 는 guest/guest 이다.<br>
<br>
만약 디폴트 ID/PW 를 변경하고 싶다면, `RABBITMQ_DEFAULT_USER` , `RABBITMQ_DEFAULT_PASS` 에 대한 값들을 환경변수로 지정하여 넘겨주면 된다.<br>
<br>

나의 경우는 디폴트 어드민이 있는 것을 활용했다.<br>


## 로그인
mqadmin/1111 을 ID/PW 로 지정해서 로그인이 가능하도록 지정해두었다.<br>
`http://localhost:15672` 로 접속해보면 아래와 같은 화면이 나타나는데, 로그인을 하면 어드민 화면으로 넘어가게 된다.<br>
<br>



