# 🕵️‍♂️ 찾아드림 프로젝트

> 사용자 간 분실물, 습득물을 등록하여 서로 찾아주는 **웹 플랫폼**

---

## 📌 프로젝트 소개

**‘찾아드림’**은 분실물을 잃어버린 사람과 이를 도와줄 수 있는 사람(헌터/탐정)을 연결해주는 커뮤니티 기반의 플랫폼입니다.  
사용자는 자유롭게 분실물을 등록하고, 또 다른 사용자는 이를 탐색하여 서로 소통하며 물건을 되찾을 수 있습니다.

---

## 🗓️ 개발 기간

**2024. 09. 05 ~ 2024. 10. ~~**

---

## 🛠️ 기술 스택

### Frontend

- JavaScript  
- React

### Backend

- Spring Boot  
- Spring Data JPA  
- MySQL  
- AWS (EC2, RDS 등)

---

## 👩‍💻 기획 & 설계
[아줌마 개발일지](https://yunamom.tistory.com)
- [📄 기능 설명서](https://sly-grape-e30.notion.site/10611252aa9680f1b260e5b009581f2d)
- [⚙ 기능 명세서](http://sly-grape-e30.notion.site/10611252aa96800cb9d5c98875b98858?pvs=74)
- [☁ DB ERDCloud](https://www.erdcloud.com/d/26ggvtwpE5tjyn5D2)
- [📒 DB 명세서](https://sly-grape-e30.notion.site/DB-10611252aa96807fa75edc185c8f2cc3?pvs=74)
- [⌨ API 명세서](https://sly-grape-e30.notion.site/API-10611252aa9680fa836cc91eb3458b2e?pvs=74)
- [💾 API 문서](https://sly-grape-e30.notion.site/API-10611252aa9680f4bb77cd3e37e801b7?pvs=74)
- [🖥 페이지 기획서](https://www.figma.com/embed?embed_host=notion&url=https%3A%2F%2Fwww.figma.com%2Fdesign%2FUFaPGlMkod89eXuaj0VvGV%2FUntitled%3Fnode-id%3D0-1%26m%3Ddev%26t%3Da3DVGkoKB8wnGKmi-1)


---

## 📄 주요 기능

### 📌 분실물 게시판
- 최근 등록된 분실물 게시물을 한눈에 확인할 수 있는 메인 게시판

### 📝 분실물 의뢰 페이지 (의뢰자)
- **분실물 등록 폼**  
  - 분실물 종류, 색상, 분실 날짜, 설명 등을 입력
- **경로 선택 기능**  
  - 지도를 클릭하여 사용자가 다닌 경로를 직접 표시
- **파일 업로드**  
  - 분실물 사진 첨부 가능
- **제출 버튼**  
  - 모든 정보를 등록 후 제출 가능

### 🔍 분실물 상세 페이지
- 특정 분실물의 상세 정보 확인 가능
- 의뢰자가 선택한 경로를 지도에 시각적으로 표시
- 댓글/채팅 기능을 통해 의뢰자-탐정 간 소통

### 🧭 분실물 탐색 페이지 (탐정)
- 의뢰자가 등록한 분실물 목록 확인
- 각 분실물 상세 페이지로 이동 가능
- 탐정이 "탐색 시작" 버튼 클릭으로 활동 상태 표시

### 👤 사용자 대시보드
- **의뢰자 대시보드**  
  - 내가 등록한 분실물 목록 및 경로 확인
  - 현재 상태(탐색 중, 찾음 등) 업데이트 확인
- **탐정 대시보드**  
  - 현재 탐색 중인 분실물 목록 확인
  - 실시간 상태 파악 가능

### 🙋‍♂️ 회원 기능
- 회원가입 및 로그인
- 회원 정보 수정
- 소셜 로그인 기능 (가능 시 추가)

---

> 함께 만들어가는 분실물 찾기 플랫폼, **찾아드림**
