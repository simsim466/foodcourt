# Фудкорт
Разработка и реализация через REST API на стеке Hibernate/Spring/SpringMVC, исключая фронтенд.
## Задание
Реализовать систему, предоставляющую возможность голосования за предложенное меню:
  - два типа юзеров
  - админы могут создавать рестораны и обновлять им меню на день (меню состоит из 2 - 5 блюд с указанием цены)
  - админы загружают меню ежедневно "своим" ресторанам
  - юзеры голосуют за то меню, где сегодня желают обедать
  - один юзер - один голос в день
  - если в определенный день юзер снова голосует,
      мы даем ему возможность поменять свое мнение, если в текущий момент менее 11 часов утра;
      отзыв голоса невозможен, если сейчас позже 11 часов утра;
## Пояснения к текущей версии проекта
  - в проекте 4 основных сущности (пользователь(user), еда(meal), ресторан(restaurant), голосование(vote)) и одна вспомогательная (блюдо(dish))
  - на данный момент отсутствуют, но будут планируются к добавлению:
      - transfer objects;
      - обработка ошибок через exception handlers;
      - валидация (по возможности)
  - файл curl команд будет в значительной мере дополнен. На данный момент он находится в папке conf
  - слой service планируется доработать, использовав для валидации входящих/исходящих данных и переместив, по возможности, логику из репозитория. Не успел это сделать к текущему моменту. 
## Вопрос
Для наличия в БД актуальных на сегоднящний день данных рекомендуется использовать команду now при популировании. Я ее использовал, но репозиторий перестал распознавать такие данные как сегодняшние. Поэтому пришлось вернуться к исходному варианту,т. е. заменить команду now на введенные в ручную значения. Что было сделано не так в данном аспекте?
## Список curl команд (планируются значительные дополнения)
#### get All Users
`curl -s http://localhost:8080/foodcourt/superadmin/users`

#### get User 1005
`curl -s http://localhost:8080/foodcourt/superadmin/users/1005`

#### delete User 1003
`curl -s -X DELETE http://localhost:8080/foodcourt/superadmin/users/1003`

#### create User 
`curl -s -X POST -d '{"name": "Альберт", "password": "Эйнштейн", "roles": ["USER"]}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/foodcourt/superadmin/users`

#### update User 1010
`curl -s -X PUT -d '{"id":1010,"name": "Jack","password": "Daniels","roles": ["USER", "ADMIN"]}' -H 'Content-Type: application/json' http://localhost:8080/foodcourt/superadmin/users/1010`

#### get authorized User 1003
`curl -s http://localhost:8080/foodcourt/profile`

#### delete authorized User 1003
`curl -s http://localhost:8080/foodcourt/profile`

#### register Users
`curl -s -i -X POST -d '{"name": "Альберт","password": "Эйнштейн","roles": ["USER"]}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/topjava/rest/profile/register`
