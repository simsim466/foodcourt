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
## Пояснения
  ### в проекте 4 основных сущности (пользователь(user), еда(meal), ресторан(restaurant), голосование(vote)) и одна вспомогательная (блюдо(dish))
  ### функции админа:
     -создавать/изменять/удалять свои рестораны
     -добавлять еду на день (если уже поздно, то на следующий день) в свой ресторан
  ### возможности юзера:
     -голосовать за еду, просматривать еду/рестораны
     -изменить/отменить свой голос до 11
     -просмотреть результаты голосования по дате

## Список curl команд (планируются значительные дополнения)

###ProfileController
#### get User 1001  
`curl -s http://localhost:8080/foodcourt/profile/1001`
#### delete User 1001
`curl -s -X DELETE http://localhost:8080/foodcourt/profile/1003`
#### create User (registration) as an admin
`curl -s -X POST -d '{"name": "Альберт", "password": "Эйнштейн"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/foodcourt/profile/register/admin`
#### create User (registration) as an user
`curl -s -X POST -d '{"name": "Альберт", "password": "Эйнштейн"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/foodcourt/profile/register/user`
#### update User 1010
`curl -s -X PUT -d '{"id":1010,"name": "Jack","password": "Daniels","roles": ["USER", "ADMIN"]}' -H 'Content-Type: application/json' http://localhost:8080/foodcourt/profile/1010`

###AdminRestaurantController
#### delete Restaurant 1017 by owner 1012
`curl -s -X DELETE http://localhost:8080/foodcourt/admin/1012/restaurants/1017`
#### get all restaurants which belong to user 1012
`curl -s http://localhost:8080/foodcourt/admin/1012/restaurants`
#### get restaurant 1017 which belongs to user 1012
`curl -s http://localhost:8080/foodcourt/admin/1012/restaurants/1017`
#### create restaurant Boemi by the admin 1012
`curl -s -X POST -d '{"name": "Boemi"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/foodcourt/admin/1012/restaurants`
#### update restaurant 1017 by its owner 1012
`curl -s -X PUT -d '{"id":1017,"name": "Цибуля"}' -H 'Content-Type: application/json' http://localhost:8080/foodcourt/admin/1012/restaurants/1017`

###RestaurantController
#### get restaurant 1016 for a user
`curl -s http://localhost:8080/foodcourt/restaurants/1016`
#### get all restaurants for a user
`curl -s http://localhost:8080/foodcourt/restaurants`

###UserMealController
#### get all meals on 2021-05-01
`curl -s http://localhost:8080/foodcourt/user/meals?date=2021-05-01`
#### get meal in the restaurant on 2021-05-22
`curl -s http://localhost:8080/foodcourt/user/meals/1017?date=2021-05-22`
#### get all meals in the restaurant 1017
`curl -s http://localhost:8080/foodcourt/user/meals/by-restaurant/1017`
#### get election results on 22-05-2021
`curl -s http://localhost:8080/foodcourt/user/meals/results?date=2021-05-22`

###AdminMealController

###VoteController

## Вопрос
Для наличия в БД актуальных на сегоднящний день данных рекомендуется использовать команду now при популировании. Я ее использовал, но репозиторий перестал распознавать такие данные как сегодняшние. Поэтому пришлось вернуться к исходному варианту,т. е. заменить команду now на введенные в ручную значения. Что было сделано не так в данном аспекте?

## Примечание
команды для VoteController и AdminMealController пока не загружены
