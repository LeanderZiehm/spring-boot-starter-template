

database: 
	podman run --replace -d --name postgres -e POSTGRES_PASSWORD=secretpassword -p 5432:5432 -v pgdata:/var/lib/postgresql docker.io/library/postgres:18 && podman ps


# to get psql you need to install postgres locally
test:
	psql -h 127.0.0.1 -p 5432 -U postgres