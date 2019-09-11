GREEN := \033[0;32m
NC := \033[0;m

database:
	@bash -c "echo -e \"${GREEN}Run infrastructure${NC}\""
	@docker-compose up -d
	@printf "${GREEN}Mysql running"
	@bash ./config/mysql/mysql_check.sh ${PROJECT_NAME}-mysql root ${MYSQL_ROOT_PASSWORD}