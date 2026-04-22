APP_NAME=todo-app
IMAGE_NAME=todo-app:latest
CONTAINER_NAME=todo-app
PORT=8080

run:
	@set -a && . ./.env && ./mvnw spring-boot:run

database: 
	podman run --replace -d --name postgres -e POSTGRES_PASSWORD=secretpassword -p 5432:5432 -v pgdata:/var/lib/postgresql docker.io/library/postgres:18 && podman ps


create-env:
	cp -n .env.example .env


delete-db:
	@read -p "Delete pgdata volume? [y/N] " ans; \
	if [ "$$ans" = "y" ] || [ "$$ans" = "Y" ]; then \
		echo "Stopping/removing container..."; \
		podman rm -f postgres >/dev/null 2>&1 || true; \
		echo "Removing volume..."; \
		if podman volume rm pgdata; then \
			echo "Volume deleted"; \
		else \
			echo "Failed to delete volume"; \
			exit 1; \
		fi; \
	else \
		echo "Aborted"; \
	fi




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
