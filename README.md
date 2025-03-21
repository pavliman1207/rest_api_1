  # Название и назначение сервиса
- Демонстрационная версия для управления данными студентов 

## Основные функции:

- Добавление студентов в систему

- Изменение фамилии студента в системе

- Удаления студента из системы

- Просмотр всех студентов в системе

## Технологии и фреймворки

- Java 21 -язык программирования и платформа 

- Spring Boot 3.4.2 -фреймворк

- Maven -для управление зависимостями проекта

- Spring Web - предоставляет инструменты для обработки HTTP запросов 

- Spring Boot DevTools-для быстрой перезагрузки приложения

- Spring Data JPA-для работ с БД

- PostgreSQL-БД

- Hibernate-фреймворк для jpa по умолчанию

- Spring Cache-для кеширования
- Springdoc OpenAPI UI -для документирования

- Jackson-включен в spring boot по умолчанию для обработки JSON
## Способы запуска сервиса

### Локальный запуск через Docker

### Требования:

- Установлены Docker desctop.

 - Установка и настройка:

### Клонируйте репозиторий:

- git clone https://github.com/pavliman1207/rest_api_1.git

- cd ваш репозиторий

### Запуск:

 - docker-compose up -d

> Сервис будет доступен по адресу: http://localhost:8080/

### Альтернативный запуск:

- cd rest_api_1

- ./mvnw clean package

 - java -jar target/api1-0.0.1-SNAPSHOT.jar
 
> Сервис будет доступен по адресу: http://localhost:8080/
 
## API документация

 - OpenAPI / Swagger

 > Документация доступна по адресу: http://localhost:8080/swagger-ui/index.html

## Основные эндпоинты:

 # POST 
> url: http://localhost:8080/students
> 
Тип контента:application/json

- пример в документирование

- добавляет студента в систему 

 # GET
> url: http://localhost:8080/students
>
- получает список всех студентов в системе

 # GET
> url: http://localhost:8080/students/{ID]
>
- ищет студента в системе по id

# PATCH
> url: http://localhost:8080/students/{ID]
>
- изменяет фамилию студента в системе по id

# DELETE
 > url: http://localhost:8080/students/{ID]

- удаляет студента из системе по id


## Контакты
 - почта,с которой писал преподавателю
