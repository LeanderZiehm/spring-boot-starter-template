APP_NAME=todo-app
IMAGE_NAME=todo-app:latest
CONTAINER_NAME=todo-app
PORT=8080

dev:
	@set -a && source ./.env && ./mvnw spring-boot:run

docker-run:
	docker build -t todo-app . && docker rm -f todo-app 2>/dev/null || true && docker run --env-file .env -p 8080:8080 --name todo-app todo-app

podman-run:
	podman build -t todo-app . && podman rm -f todo-app 2>/dev/null || true && podman run --env-file .env -p 8080:8080 --name todo-app todo-app -d

docker-compose-no-db:
	docker compose -f docker-compose.no-db.yml up 

podman-compose-no-db:
	podman-compose -f docker-compose.no-db.yml up -d

# build:
# 	docker build -t $(IMAGE_NAME) .

# run:
# 	docker run -d \
# 		--name $(CONTAINER_NAME) \
# 		-p $(PORT):8080 \
# 		-e SPRING_PROFILES_ACTIVE=local \
# 		$(IMAGE_NAME)

# stop:
# 	docker stop $(CONTAINER_NAME) || true

# rm:
# 	docker rm $(CONTAINER_NAME) || true

# restart: stop rm build run

# logs:
# 	docker logs -f $(CONTAINER_NAME)




# APP_NAME=todo-app

# .PHONY: build run up down logs clean

# build:
# 	mvn clean package -DskipTests

# run:
# 	mvn spring-boot:run

# docker-build:
# 	docker build -t $(APP_NAME) .

# up:
# 	docker compose up --build

# down:
# 	docker compose down

# logs:
# 	docker compose logs -f

# clean:
# 	docker compose down -v
# 	mvn clean
