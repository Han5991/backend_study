- EC2
  - aws의 가상 서버
  - os
    - linux
    - windows
    - mac
  - cpu
  - ram
  - ebs & efs
  - ip
  - security group
  - start script : ec2 user data
    - ec2 인스턴스를 시작할 때 실행할 스크립트 -> 부트스트랩
    - 루트 권한으로 실행
  - type
    - m5.2xlarge
      - m: 인스턴스 유형
      - 5: 세대
      - 2xlarge: 크기
    - 계산 최적화 -> c class
    - 메모리 최적화 -> r class
    - 스토리지 최적화 -> i class
  - security group
    - 방화벽
    - 인바운드, 아웃바운드 설정 가능
    - ip 범위, 종류
    - 흐름 상 인스턴스 앞에서 걸림
    - port ssh, ftp, sftp, http, https, rdp(3389)
  - ssh
    - secure shell
  - role
    - aws 키를 직접 ec2안에서 입력하는건 지양하자
    - iam role을 사용하자
    - 보안 탭에 들어가서 iam role을 선택
  - 구매 옵션
    - 온디맨드
      - 시간당 요금
    - 예약
      - 1년, 3년
      - 할인
    - 스팟
      - 경매
      - 시간당 요금
    - 전용
      - 전용 물리 서버
