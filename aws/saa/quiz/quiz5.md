> Scaling an EC2 instance from r4.large to r4.4xlarge is called ...
> 1. Horizontal Scalability
> 2. **Vertical Scalability**
> <br/> 수직 스케일링은 기존의 컴퓨팅 리소스를 증가시키거나 감소시키는것을 의미

> Running an application on an Auto Scaling Group that scales the number of EC2 instances in and out is called .....................
> 1. **Horizontal Scalability**
> 2. Vertical Scalability

> Elastic Load Balancers provide a .......................
> 1. static IPv4 we can use in our application
> 2. **static DNS name we can use in our application**
> 3. static IPv6 we can use in our application
> <br/> Network Load Balancer만 고정 DNS 이름과 고정 IP를 모두 제공합니다. 반면 Application Load Balancer는 고정 DNS 이름을 제공하지만 고정 IP는 제공하지 않습니다. 그 이유는 AWS가 관리하는 기본 인프라가 변경되더라도 AWS는 정적 엔드포인트를 사용하여 Elastic Load Balancer에 액세스할 수 있기를 원하기 때문입니다.

> You are running a website on 10 EC2 instances fronted by an Elastic Load Balancer. Your users are complaining about the fact that the website always asks them to re-authenticate when they are moving between website pages. You are puzzled because it's working just fine on your machine and in the Dev environment with 1 EC2 instance. What could be the reason?
> <br/> (Elastic Load Balancer가 앞에 있는 10개의 EC2 인스턴스에서 웹 사이트를 실행하고 있습니다. 귀하의 사용자는 웹사이트 페이지 간에 이동할 때 웹사이트에서 항상 재인증을 요청한다는 사실에 대해 불평하고 있습니다. 1개의 EC2 인스턴스가 있는 개발 환경과 컴퓨터에서 제대로 작동하기 때문에 의아해합니다. 이유가 무엇일까요?)
> 1. Your website must have an issue when hosted on multiple EC2 instances
> 2. The EC2 instances log out users as they can't see their IP addresses, instead, they receive ELB IP addresses.
> 3. **The Elastic Load Balancer does not have Sticky Sessions enabled**
> <br/> ''Sticky Sessions''은 사용자가 동일한 EC2 인스턴스로 요청을 보내도록 하는 기능입니다. 사용자가 로그인한 후에는 동일한 EC2 인스턴스로 요청을 보내도록 하는 것이 좋습니다. 그렇지 않으면 사용자가 로그인한 후에 다른 EC2 인스턴스로 요청을 보내면 로그인 정보가 유실될 수 있습니다.

> For compliance purposes, you would like to expose a fixed static IP address to your end-users so that they can write firewall rules that will be stable and approved by regulators. What type of Elastic Load Balancer would you choose?
> <br> 규정 준수를 위해 최종 사용자가 안정적이고 규제 기관의 승인을 받는 방화벽 규칙을 작성할 수 있도록 고정 IP 주소를 최종 사용자에게 노출하려고 합니다. 어떤 유형의 Elastic Load Balancer를 선택하시겠습니까?
> 1. Application Load Balancer with an Elastic IP attached to it
> 2. **Network Load Balancer**
> 3. Classic Load Balancer
> <br> Network Load Balancer에는 AZ당 하나의 고정 IP 주소가 있으며 여기에 탄력적 IP 주소를 연결할 수 있습니다. Application Load Balancer와 Classic Load Balancer에는 정적 DNS 이름이 있습니다.

> You have an application hosted on a set of EC2 instances managed by an Auto Scaling Group that you configured both desired and maximum capacity to 3. Also, you have created a CloudWatch Alarm that is configured to scale out your ASG when CPU Utilization reaches 60%. Your application suddenly received huge traffic and is now running at 80% CPU Utilization. What will happen?
> <br/> 원하는 용량과 최대 용량을 모두 3으로 구성한 Auto Scaling 그룹에서 관리하는 EC2 인스턴스 세트에서 호스팅되는 애플리케이션이 있습니다. 또한 CPU 사용률이 60%에 도달하면 ASG를 확장하도록 구성된 CloudWatch 경보를 생성했습니다. . 귀하의 애플리케이션이 갑자기 엄청난 양의 트래픽을 수신하여 현재 80%의 CPU 사용률로 실행되고 있습니다. 무슨 일이 일어날 것?
> 1. **Nothing**
> 2. The desired capacity will go up to 4 and the maximum capacity will stay at 3
> 3. The desired capacity will go up to 4 and the maximum capacity will stay at 4
> <br> 자동 확장 그룹은 스케일아웃 이벤트 중에 (사용자가 구성한) 최대 용량을 초과할 수 없습니다.

> You have an Auto Scaling Group fronted by an Application Load Balancer. You have configured the ASG to use ALB Health Checks, then one EC2 instance has just been reported unhealthy. What will happen to the EC2 instance?
> <br> Application Load Balancer가 앞에 있는 Auto Scaling 그룹이 있습니다. ALB 상태 확인을 사용하도록 ASG를 구성한 후 EC2 인스턴스 하나가 비정상으로 보고되었습니다. EC2 인스턴스는 어떻게 되나요?
> 1. The ASG will keep the instance running and re-start the application
> 2. The ASG will detach the EC2 instance and leave it running
> 3. **The ASG will terminate the EC2 instance**
> <br>EC2 상태 확인(기본값) 대신 Application Load Balancer 상태 확인을 기반으로 EC2 인스턴스의 상태를 확인하도록 Auto Scaling 그룹을 구성할 수 있습니다. EC2 인스턴스가 ALB 상태 확인에 실패하면 비정상으로 표시되고 ASG가 새 EC2 인스턴스를 시작하는 동안 종료됩니다.
