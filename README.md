# 1. Project Overview (프로젝트 개요)
- 프로젝트 이름: ZIPTE 알림센터 서비스
- 프로젝트 설명: 헥사곤 아키텍쳐 기반 MSA 프로젝트 중 알림센터 서비스 담당
- 프로젝트 기간 : 2025.03.23 ~ (1인 개발)
- [MVP 프로젝트 구경하기](https://github.com/ZipTe/ZipTe_MVP)


# 2. Team Member (팀원 소개)
| 이도연 |
|:------:|
| <img src="https://github.com/user-attachments/assets/653c94e3-5837-4e40-8ee9-b0ff135b59e7" alt="이도연" width="150"> | 
| BE |
| [GitHub](https://github.com/doup2001) | 


# 3. Key Features (주요 기능)
- **알림센터** :
  - 나의 알림을 쌓아두는 보관함이 존재.
  - 보관함에 알림이 존재하면 빨간 불 제공   
  - 관심 아파트 매물, 가격 변동, 커뮤니티 등 주요 이벤트 발생 시 알림을 제공


# 4. Technology Stack (기술 스택)
## 5. Backend
|  |  |  |
|-----------------|-----------------|-----------------|
| SpringBoot    |  <img src="https://github.com/user-attachments/assets/43d80a85-2060-4475-95a8-fc402f837aa0" alt="SpringBoot" width="100">    | 3.2.4  |
| MongoDB | <img src= "https://github.com/user-attachments/assets/82e9e7a5-c3e7-4998-8ea0-2bf25a8a93d2" alt="SpringBoot" width="100"> ||
| Kafka | <img src = "https://github.com/user-attachments/assets/841067aa-94e3-4766-b9f0-d7e721a64835" alt="SpringBoot" width="100"> | |
| Docker | <img src = "https://github.com/user-attachments/assets/f4646cfa-43f7-4e3d-8d07-a35bb89ccdad" alt="SpringBoot" width="100"> | |

## 6. Cooperation
|  |  |
|-----------------|-----------------|
| Git    |  <img src="https://github.com/user-attachments/assets/483abc38-ed4d-487c-b43a-3963b33430e6" alt="git" width="100">    |
| Notion    |  <img src="https://github.com/user-attachments/assets/34141eb9-deca-416a-a83f-ff9543cc2f9a" alt="Notion" width="100">    |


# 7. Project Structure (프로젝트 구조)
```
      └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       └── zipte
        │   │           └── notifications
        │   │               ├── NotificationsApplication.java
        │   │               ├── core
        │   │               │   ├── config
        │   │               │   │   ├── mongo
        │   │               │   │   └── redis
        │   │               │   ├── exception
        │   │               │   ├── response
        │   │               │   │   └── pageable
        │   │               │   └── utils
        │   │               └── server
        │   │                   ├── adapter
        │   │                   │   ├── in
        │   │                   │   │   ├── consumer
        │   │                   │   │   └── web
        │   │                   │   └── out
        │   │                   │       ├── kafka
        │   │                   │       │   └── event
        │   │                   │       └── mongo
        │   │                   │           ├── base
        │   │                   │           ├── comment
        │   │                   │           ├── favorite
        │   │                   │           └── property
        │   │                   ├── application
        │   │                   │   ├── port
        │   │                   │   │   ├── in
        │   │                   │   │   │   └── task
        │   │                   │   │   └── out
        │   │                   │   │       └── task
        │   │                   │   └── service
        │   │                   │       └── task
        │   │                   └── domain
        │   └── resources
        │       ├── application-dev.yml
        │       ├── application-event.yml
        │       ├── application-test.yml
        │       ├── application.yml
```

# 8. Development Workflow (개발 워크플로우)
## 브랜치 전략 (Branch Strategy)
우리의 브랜치 전략은 Git Flow를 기반으로 하며, 다음과 같은 브랜치를 사용합니다.

- Main Branch
  - 배포 가능한 상태의 코드를 유지합니다.
  - 모든 배포는 이 브랜치에서 이루어집니다.
 
- Devlop Branch
  - 만든 기능들이 작동하는지 코드를 합병합니다.
  
- {feat} Branch
  - 모든 기능 개발은 feat 브랜치에서 이루어집니다.

# 9. 커밋 컨벤션

## type 종류
```
feat : 새로운 기능 추가
fix : 버그 수정
docs : 문서 수정
style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
refactor : 코드 리펙토링
test : 테스트 코드, 리펙토링 테스트 코드 추가
chore : 설정 추가
```

# 10. ERD
