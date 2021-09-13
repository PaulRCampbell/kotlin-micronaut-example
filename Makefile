test:
	docker-compose -f docker-compose.test.yml up --build --abort-on-container-exit --exit-code-from kotlin-micronaut-example --force-recreate