# 프로그램 만드는 과정

```
요건 수집
분석
기획(검토 repeat)
UI
DB 설계   -- client
API 설계

DB 구축
API 개발
API 문서
Client

단위테스트
통합테스트

출시
```

# 배포

## docker image pull
sudo docker run -d -p 5022:22 --name test_sshd rastasheep/ubuntu-sshd:lates

## create container
docker run -d -p 6022:22 --name jenkins1 rastasheep/ubuntu-sshd:latest
docker run -d -p 6023:22 --name app1 rastasheep/ubuntu-sshd:latest

## docker 포트 매핑 인하여, 현재까지 작업중인거 커밋 후 재구동
- docker ps 로 컨테이너 ID 확인
- docker stop <CONTAINER ID>
- docker commit jenkins1 jenkins2
- docker run -d -p 6022:22 -p 58080:8080 -td jenkins2

## jenkins server
connect to jenkiins1

### install jenkins
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | apt-key add -
sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > \
/etc/apt/sources.list.d/jenkins.list'
apt-get update
apt-get install jenkins -y

### jenkins plugins
GitHub Integration Plugin
Publish over SSH

### install git in jenkins server
- apt-get install git
- witch git
- jenkins git path 등록

### install jdk
apt install openjdk-11-jdk

## app server
connect to app1

### install sdkman
apt-get install curl -y

apt-get install unzip zip -y

curl -s "https://get.sdkman.io" | bash

source "/root/.sdkman/bin/sdkman-init.sh"

### install java by sdkman
sdk install java 8.0.282.j9-adpt


### Jenkins Job

### Build

### Deploy