# WalletScanJavaTestApp

It's a microservice that allows to know, how many transactions went through your Etherium Wallet.
You can send GET-request to the address

# Running project
```aidl
git clone https://github.com/alexander-deb/WalletScanJavaTestApp.git
cd WalletScanJavaTestApp
```
First you need to install openjdk-17:
```aidl
sudo apt update
sudo apt install openjdk-17-jdk openjdk-17-jre
```
Then you need to compile project and copy .jre to the docker directory:
```aidl
cd microservice
./mvnw clean package -DskipTests
cp target/microservice-0.0.1-SNAPSHOT.jar src/main/docker
```
Then you can run docker-compose script:
```aidl
cd src/main/docker
sudo docker-compose up
```

# Testing app

Query: http://localhost:8080/request  
Parameters: "address" - address of your Ethereum Wallet

Query: http://localhost:8080/show_all_requests  
Without a parameters. Allows to see whole database with history of queries
