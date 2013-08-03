withmate [![Build Status](https://travis-ci.org/withmate/withmate.png?branch=develop)](https://travis-ci.org/withmate/withmate)  
========
협업도구 withmate입니다.  
해당 프로젝트는 @changhwa , @jinhyun 의 재미나게 진행해보기 위한 프로젝트 입니다.  
개발 하시고 싶은 기능이 있는 경우 issue 란에 추가하시거나 new feature 라벨에 ing 라벨을 붙이셔서  
작업을 진행 하시면 됩니다.  
fork후 해당 기능을 개발완료 하신 후 Pull Request 주시면 감사하겠습니다.
  
실행방법
--------
```
mvn compile
mvn grails:run-app
```
  
참여방법
--------
참여할 경우 issue란에 new feature 라벨을 선택하신 후 ing 라벨을 붙이고 댓글에 진행하겠다는 멘트를 적어주세요.  
그런 후에 withmate 프로젝트를 fork 하신후 개발이 완료 되시면 develop 브랜치에 pull request 를 주시면  
리뷰 하고 반영 하도록 하겠습니다.
```
intellij프로젝트로 변경
> grails integerate-with --intellij
도메인 생성
> grails create-domain-class net.withmate.기능명.도메인명
ex) User기능 개발시
grails create-domain-class net.withmate.user.users
.. 도메인 설계 후 ..
grails generate-all net.withmate.user.Users
```
  
