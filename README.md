# innovation_camp_week3_assignment
이노베이션 캠프 3주차 과제

1. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 날짜를 조회하기
    - 작성 날짜 기준으로 내림차순 정렬하기
2. 게시글 작성 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 입력하기
3. 특정 게시글 조회 API
    - 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
4. 게시글 비밀번호 확인 API
    - 비밀번호를 입력 받아 해당 게시글의 비밀번호와 일치여부 판단하기
5. 게시글 수정 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 수정되게 하기
6. 게시글 삭제 API
    - 글이 삭제되게 하기
    
|기능|Method|URL|Return|
|------|---|---|---|
|게시글 목록 조회|GET|/api/notes|List<Note>|
|특정 게시글 조회|GET|/api/notes/{id}|List<Note>|
|게시글 작성|POST|/api/notes|Note|
|게시글 비밀번호 확인|POST|/api/notes/{id}|boolean|
|게시글 수정|PUT|/api/notes/{id}|Long|
|게시글 삭제|DELETE|/api/notes/{id}|Long|
