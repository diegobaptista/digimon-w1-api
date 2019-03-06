# digimon-api
---
![Digivolveto](https://66.media.tumblr.com/55fea3d7561974c47d8ff97f57823f27/tumblr_mnokgkDYNf1ru8lobo1_400.gif)

### About

Test api with Digimon Tematic. I'm inspiring myself at game Digimon World, Playstation 1 game. I used to play a lot this game at my childhood.

This incredible game

![Digimon World 1](https://66.media.tumblr.com/52c40535095a4c8f4bb6e46649893ec8/tumblr_ns6k3mM42o1scncwdo1_500.gif)

### You need to run the project

* [Docker](https://docs.docker.com/install/linux/docker-ce/ubuntu/)
* [Docker Compose](https://linuxize.com/post/how-to-install-and-use-docker-compose-on-ubuntu-18-04/)
* [Java SE Development Kit 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* An IDE, I recommend [IntelliJ](https://www.jetbrains.com/idea/)

### Running the application

After installing all the prerequisites

1. Import the project using your favorite IDE
2. Download all the maven dependencies
3. After you'll need to up the docker image, then tip the following command
```sh
$ sudo docker-compose up -d
```
4. Run the DigimonApiApplication
5. You can check the endpoints on swagger.io
```
http://localhost:8080/swagger-ui.html
```

### I suggest that you download too

* Postman (Test endpoints)
* DBeaver (Manage database)

### Some technologies

* Java
* Spring boot
* Swagger/ Swagger.io
* Flyway
* Spring boot Jpa
* Docker