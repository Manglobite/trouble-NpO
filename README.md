# Основные запросы

## Заполнить тестовые данные

curl --location 'localhost:8888/api/v1/fill'

## Повторение проблемы N+1

curl --location 'localhost:8888/api/v1/bannersNpO'

## Решение проблемы N+1 через EntityGraph

curl --location 'localhost:8888/api/v1/bannersNoProblem1'

## Результат работы выводятся в консоль
