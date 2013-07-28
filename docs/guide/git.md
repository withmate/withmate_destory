Git Guide
================

> 기본적인 프로젝트에 필요한 git 사용법 입니다.  
> 프로젝트 참여에 있어 git를 잘 모르시면 한번 읽어볼만합니다.

1. 저장소에서 데이터 를 가져오는 방법 (clone)
해당 저장소로부터 소스를 가져옵니다.
```
git clone 저장소URL
```
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/clone.png?raw=true)  
  
2. 저장소에 원본 저장소를 추가하고 패치합니다.  
```
git remote add withmate https://github.com/withmate/withmate.git  
git fetch withmate
```  
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/remote_add.png?raw=true)  
  
3. 저장소에 작업을 진행 한 후 해당 파일을 add 합니다.  
add를 하지 않은 파일은 이처럼 빨간글씨로 나옵니다.  
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/no_add.png?raw=true)  
add를 할때는 실제 git status에 나온 해당 파일 경로대로 적어줘도 되고 . 을 쓸 경우 모든 파일을 add 합니다.  
```
git add .
```
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/all_add.png?raw=true)  
위의 사진처럼 초록글씨로 바뀌게 됩니다.  
  
4. 이제 커밋을 해보겠습니다.  
단 git는 svn과 달리 원격저장소와 더불어 로컬저장소를 갖고 있으며 커밋은 로컬저장소로 저장하는 행위를 말합니다.  
git : 소스 -> 로컬저장소 -> 중앙저장소  
svn : 소스 -> 중앙저장소  
```
git commit -m "메세지"  
```
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/commit_m.png?raw=true)  
  
5. 추가적으로 커밋을 합치는 작업을 해보겠습니다.  
실제로 git의 경우는 커밋을 합치는 행위를 자주 하기 때문에 알아두면 좋습니다.  
다시 한번 add & commit 작업을 진행한 상태입니다.  
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/onemore_addcommit.png?raw=true)  
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/log_commit2.png?raw=true)    
위와 같이 두개의 커밋으로 만들어지는데 사실 위의 두작업은 무의미하게 나누어진 작업이므로 하나의 단위로 합쳐보겠습니다.  
```
git rebase -i HEAD~2
```
현재 HEAD부터 2번째까지 커밋을 합치라는 의미 입니다.  
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/squash.png?raw=true)  
위의 사진형태의 텍스트 편집기가 열리는데 나머지를 전부 squash로 바꾸어주면 pick에 합쳐집니다. 다시 저장하고 커밋메세지를 수정해주고 저장하면 커밋이 합쳐집니다.  
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/rebase_i_log.png?raw=true)  
  
6. 마지막단계 입니다.  
이제 실제로 본인의 Github에 push 하도록 하겠습니다.  
그전에 원래 원본 Repository에 해당 브랜치가 변경사항이 있는지 반영해보겠습니다.  
```
git fetch withmate
```
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/fetch_before_push.png?raw=true)  
변경되어 있는 사항이 있어 저희 로컬저장소에 반영이 되었습니다. 이것을 제 소스에 반영 시켜보겠습니다. 보통 이때는 merge vs rebase 로 나누어지는데 이 부분은 너무 복잡하므로 차후 언급하기로 하고 여기서 저는 rebase를 주로 사용합니다. ( 충돌나면 merge )  
그전에 현재 로그 상태를 다시한번 보겠습니다.  
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/log_before_rebase.png?raw=true)  
이제 rebase를 진행하겠습니다.  
```
git rebase withmate/develop
```
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/rebase_before_push.png?raw=true)  
반영이 되었습니다. 다행히 충돌은 발생하지 않았지만 충돌이 발생할 경우 충돌을 해결해야합니다.  
그럴경우 사실상 merge가 속편한듯 합니다...  
이제 로그 상태를 보겠습니다.
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/log_before_push.png?raw=true)  
정상적으로 with/develop 에서 데이터를 반영한것을 알 수 가 있습니다.  
이제 본인의 github에 반영하겠습니다.  
```
git push origin develop
```
![git clone](https://github.com/withmate/withmate/blob/develop/docs/guide/image/git/push.png?raw=true)  
본인의 github사이트에서 확인에 보시면 되겠습니다.  
