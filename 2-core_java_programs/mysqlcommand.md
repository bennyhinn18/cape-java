
1. `docker start mysql-container`
2. `docker exec -it mysql-container mysql -u root -p`
3. `docker exec -i mysql-container mysql -u root -prootpassword < /workspaces/cape-java/2-core_java_programs/db/create_missing_tables.sql`
4. `docker inspect mysql-container | grep -A 10 -B 5 "Env"`