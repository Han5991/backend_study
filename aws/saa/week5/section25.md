- Organizations
    - 조직 계정 관리
    - 결제도 혼자서 관리 가능
    - 할인도 전체 조직에 적용 가능
    - 장점
        - 관리자를 여러 목적으로 생성 가능
    - 시큐리티
        - 혼자서 iam 생성해서 관리 가능
    - 조직안에 또 조직을 만들어서 관리가 가능 root 가 있는 방식
    - 전략
        - 블랙 리스트
        - 화이트 리스트
- Iam 정책 vs 리소스 기본 정책
    - Iam 내가 필요한 권한만 획득 나머진 포기
    - 기본은 내가 원하든 원하지 않는거든 일단 다 획득
    - 아마존 이벤트 브릿지
        - 리소스 기반 정책
            - 람다, sns, sqs, 게이트 웨이
        - Iam 정책
            - 데이터 분석
- Iam 권한 바운더리 경계
    - 유효한 권한은 두개 이상의 권한이 겹치는 것만 가능 
- Iam 확인 센터
    - Id 센터 포털을 통해 로그인 가능
    - 이걸로 sso 로그인 가능
    - 오피스 프로그램들 하고 연동하기 좋을 듯 
-  디렉토리 서비스
    - 그냥 뭐 연결 관리 해주는거 ???
    - 양방향 신뢰관계 형성????
    - Ad 커넥터?? 중간에 프록시 껴넣어서 하는거 같음

- 컨트롤 타워
    - Was 환경을 설정하고 관리하는 서비스
    - 예방 경계
        - 모든 계정의 지역을 관리함
    - 비호환 하는 것만 관리
- 보안 설정 (시험 많이 나옴)
    - 암호화 tls/ssl
- Kim 키관리
    - 시멘트릭 키 aes 256
    - 1년 마다 키를 자동으로 돌려줌
    - 지역마다 범위가 정해져있음

> You have strong regulatory requirements to only allow fully internally audited AWS services in production. You still want to allow your teams to experiment in a development environment while services are being audited. How can you best set this up?
> (내부적으로 완전히 감사된 AWS 서비스만 프로덕션 환경에서 허용하도록 하는 강력한 규제 요구 사항이 있습니다. 서비스가 감사되는 동안에도 팀이 개발 환경에서 실험할 수 있도록 허용하고 싶습니다. 어떻게 하면 가장 잘 설정할 수 있나요?)
> 1. Provide the Dev team with a completely independent AWS account.
> 2. Apply a global IAM policy your Prod account
> 3. **Create an AWS Organization and create two Prod and Dev OUs, then Apply an SCP to the Prod OU**
> 4. Create an AWS Config Rule

> You are managing the AWS account for your company, and you want to give one of the developers access to read files from an S3 bucket. You have updated the bucket policy to this, but he still can't access the files in the bucket. What is the problem?
> (귀하는 회사의 AWS 계정을 관리하고 있으며 개발자 중 한 명에게 S3 버킷에서 파일을 읽을 수 있는 액세스 권한을 부여하려고 합니다. 이에 대해 버킷 정책을 업데이트했지만 해당 사용자는 여전히 버킷의 파일에 액세스할 수 없습니다. 문제는 무엇입니까?)
```json
{
  "Version": "2012-10-17",
  "Statement": [{
    "Sid": "AllowsRead",
    "Effect": "Allow",
    "Principal": {
      "AWS": "arn:aws:iam::123456789012:user/Dave"
    },
    "Action": "s3:GetObject",
    "Resource": "arn:aws:s3:::static-files-bucket-xxx"
  }]
}
```
> 1. Everything is okay, he just needs to logout and login again
> 2. The bucket does not contain any files yet
> 3. **You should change the resource to <code>arn:aws:s3:::static-files-bucket-xxx/*</code>, because this is an object-level permission**

> You have 5 AWS Accounts that you manage using AWS Organizations. You want to restrict access to certain AWS services in each account. How should you do that?
> (AWS Organizations를 사용하여 관리하는 AWS 계정이 5개 있습니다. 각 계정의 특정 AWS 서비스에 대한 액세스를 제한하려고 합니다. 어떻게 해야 할까요?)
> 1. Using IAM Roles
> 2. **Using AWS Organizations SCP**
> 3. Using AWS Config

> Which of the following IAM condition key you can use only to allow API calls to a specified AWS region?
> (다음 중 지정된 AWS 리전에 대한 API 호출을 허용하는 데에만 사용할 수 있는 IAM 조건 키는 무엇입니까?)
> 1. aws:RequiredRegion
> 2. aws:SourceRegion
> 3. aws:InitialRegion
> 4. **aws:RequestedRegion**

> When configuring permissions for EventBridge to configure a Lambda function as a target you should use ………………….. but when you want to configure a Kinesis Data Streams as a target you should use …………………..
> (Lambda 함수를 대상으로 구성하기 위해 EventBridge에 대한 권한을 구성할 때는 …………………..을 사용해야 하지만 Kinesis Data Streams를 대상으로 구성하려면 …………………..을 사용해야 합니다.)
> 1. Identity-Based Policy, Resource-based Policy
> 2. **Resource-Based Policy, Identity-based Policy**
> 3. Identity-Based Policy, Identity-based Policy
> 4. Resource-Based Policy, Resource-based Policy
