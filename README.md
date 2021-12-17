# 당근마켓 클론코딩

<!-- <p align="center"><img width="500"  alt="스크린샷 2021-12-09 오후 2 32 42" src="https://user-images.githubusercontent.com/90129613/145664148-ff6951db-040e-4b32-9a59-1e4a10b36c12.png">
 </p> -->

</br>

## 🤷 프로젝트 소개 
 <p> 당근마켓 클론 코딩입니다. </p>
 <p> 맛깔나게 소개글을 작성해주실 팀원 구합니다. </p>
 <p> </p>
 <p> </p>
  
  Web Site : 아직 웹사이트 개시를 안했습니다.
</br>

## 🧾 와이어 프레임

<p align="center"float="left">
  <img src="https://user-images.githubusercontent.com/90129613/146336900-ec5dc293-9097-4823-bbcd-4cdc781c743a.png" width="400" />
  <img src="https://user-images.githubusercontent.com/90129613/146336913-1561b07c-c192-4720-8dea-a132336ce5ba.png" width="400" /> 
  <img src="https://user-images.githubusercontent.com/90129613/146336917-d6dd74de-8a1b-475f-b6ed-aefc3c51f8ce.png" width="500" />
</p>

## 🎥 시연 영상
<!--  [![Hnet-image](https://user-images.githubusercontent.com/90129613/145665770-a2eb072f-3148-4e3b-afd9-0f9a8105c322.gif)](https://www.youtube.com/watch?v=n08_pEMKvvQ)<br> -->
유투브 편집자 구합니다.

## 🧑🏼‍💻 개발기간 및 팀원소개
### 기간: 2021.12.13 ~ 2021.12.18 (6일)  
</br>

### Front-end   
   <p><a href="https://github.com/hamkke" target="_blank"><img width="180"  src="https://img.shields.io/static/v1?label=React&message=이서현&color=61dafb&style=for-the-badge&>"/></a></p>
   <p><a href="https://github.com/cslim0527" target="_blank"><img width="180"  src="https://img.shields.io/static/v1?label=React&message=임찬수&color=61dafb&style=for-the-badge&>"/></a></p>
   <p><a href="https://github.com/keimindev" target="_blank"><img width="180"  src="https://img.shields.io/static/v1?label=React&message=정민경&color=61dafb&style=for-the-badge&>"/></a></p>
  
### Back-end
<p><a href="https://github.com/good4y" target="_blank"><img width="180"  src="https://img.shields.io/static/v1?label=Spring&message=김영철&color=08CE5D&style=for-the-badge&>"/></a></p>
   <p><a href="https://github.com/HundredCleanWater" target="_blank"><img width="180"  src="https://img.shields.io/static/v1?label=Spring&message=백정수&color=08CE5D&style=for-the-badge&>"/></a></p>
   <p><a href="https://github.com/sixthh-sense" target="_blank"><img width="180"  src="https://img.shields.io/static/v1?label=Spring&message=성해인&color=08CE5D&style=for-the-badge&>"/></a></p>
   

  
</br>



## 🏷 API Table
<details>
 <summary>자세히 보기</summary>


<p align="center"float="left">
  <img src="https://user-images.githubusercontent.com/90129613/146339824-1a6ab044-a7f5-4738-a3f2-f99bced644d5.png" width="600" />
  <img src="https://user-images.githubusercontent.com/90129613/146339833-a2246d8e-73e2-4f22-a4a9-bcf762897f07.png" width="600" /> 
  <img src="https://user-images.githubusercontent.com/90129613/146339840-b15bf4e0-4b26-4020-97b2-56f8c215aee8.png" width="600" />
</p>

<!-- |기능|Method|URL|Request|Response|
|:-----:|:----:|----|----|----|
|로그인 요청|POST|/user/login|{username: "iamuser",</br>password: "1234"}| |
|회원</br>가입|POST|/api/signup|{username:"iamuser"</br>,"password:"1234"</br>,passwordCheck:"1234"}||
|아이디 중복 검사|POST|/api/idCheck|{username:"iamuser"}|{result:false}|
|로그인 여부</br>확인|GET|/api/islogin||{userInfo:{username:"username"}</br>}|
|로그아웃|GET|/api/logout|||
|사진</br>업로드|POST|/api/images||{imageUrl:"/images/cancle.png"}|
|게시글 작성|POST|/api/posts|{title:"제목입니다",</br>content:"반가워요",</br>imageUrl:"/images/cancle.png"}||
|게시글 수정|PUT|/api/posts/{postId}|{content:"반갑습니다"}||
|게시글 삭제|DELETE||||
|랜덤</br>게시글 조회|GET|/api/posts||{postId:1,</br>title:"제목",</br>content:"글내용",</br>comments:[{</br>commentId:1,</br>comment:"댓글내용",</br>createdAt:LocalDateTime}]</br>}|
|내가</br>작성한 게시글 조회|GET|/api/comments/{postId}||{postId:1,</br>title:"제목",</br>content:"글내용",</br>comments:[{</br>commentId:1,</br>comment:"댓글내용",</br>createdAt:LocalDateTime},</br>{commentId:2,</br>comment:"댓글내용2",</br>createdAt:LocalDateTime}]</br>}|
|내가</br> 댓글을 작성한 게시글 조회|GET|/api/comments/{commentId}||{postId:1,</br>title:"제목",</br>content:"글내용",</br>comments:[{</br>commentId:1,</br>comment:"댓글내용",</br>createdAt:LocalDateTime},</br>{commentId:2,</br>comment:"댓글내용2",</br>createdAt:LocalDateTime}]</br>}|
|댓글</br> 작성|POST|/api/comments/{postId}|{comment:"댓글"}||
|피드</br>페이지|GET|/api/feeds||[myPosts:[{</br>postId:1</br>title:"제목",</br>content:"내용",},</br>{postId:2,</br>title:"제목2",</br>content"내용2"}],</br>myComments:[{</br>commentId:1,</br>comment:"댓글",</br>createdAt:LocalDateTime},</br>{commentId:2,</br>comment:"댓글2",</br>createdAt:LocaldateTime}]</br>]|
 -->
 
</details>



</br>


## 🔨사용한 기술 스택



<img width="866" alt="스크린샷 2021-12-09 오후 2 32 42" src="https://user-images.githubusercontent.com/90129613/146481690-f768fe7d-59b7-44fe-92c6-4311e3e2a436.png">



<code> Back-end </code>
 * Java 8
 * SpringBoot 2.5.3
 * Spring Security
 * Gradle
 * JPA
 * MySQL
 * JWT
 * CORS


<code> Front-end </code>
* [Front-end 개발Page](https://github.com/Team9-DaangnMarket/Team-9-Front)

</br>

<code>DevOps</code>
* AWS EC2
* AWS RDS(MySQL)
* FileZilla

<code>Tool</code>
* Git
* GitHub
* Notion
* Figma
* Postman

## ⚒️ ERD 설계

<img src="https://user-images.githubusercontent.com/90129613/146348534-965ca958-ba8b-439b-bb85-fe85409ad06c.png" width="600" height="500"/>


## ✌🏻 개인 역할 및 트러블 슈팅 해결과정

<code>김영철</code> 메인화면, 게시글 작성 & 수정 , 상세 게시글 조회, 찜하기, 찜하기 목록
</br>


<code>백정수</code> 회원가입, 로그인, 아이디 & 닉네임 중복 검사, 상세게시글 조회
</br>


<code>성해인</code> 메인화면, 게시글 작성 & 수정 & 삭제 , 상세 게시글 조회, 검색

<!-- <code>Trouble Shooting</code>  [트러블 슈팅 해결과정](https://chrome-armadillo-b80.notion.site/0c1dc754030248d88bf14c7d8570ddab) -->

</br>



## 📝 후기 및 팀 노션 페이지

<code>김영철</code> 
</br>

<code>백정수</code> 
</br>


<code>성해인</code>  
</br>


<code>팀 노션 페이지</code>  [당근마켓 클론코딩](https://exuberant-dart-a7f.notion.site/9-77ee6bd1f54245cdaf068c8312c44bf6)
