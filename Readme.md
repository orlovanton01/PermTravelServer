

## Сборка
1. (При необходимости) обновить версию сборки в ./build.gradle.kts/version = "0.0.3-SNAPSHOT"
2. Выполнить цель gradle bootJar. 
3. Проверить наличие актуального исполняемого файла ./build/libs/*.jar.
4. (При необходимости) обновить наименование исполняемого файла в файле Dockerfile/JAR_FILE=
5. Кроссплатформенная сборка под 2 платформы.
В команде ниже версию тега тоже надо актуализировать вручную.
```
docker buildx build --platform linux/amd64,linux/arm64 -t docker.yardtech.ru/permtravel-server:0.0.3 .
```
## Развёртывание в Docker
1. Публикация в репозитории образов.
```
docker push docker.yardtech.ru/permtravel-server:0.0.3
```
2. Перейти в папку проекта, где лежит файл docker-compose.yml.
3. Обновление образа на сервере.
```
docker-compose pull
docker-compose up --force-recreate --build -d
docker image prune -f
```