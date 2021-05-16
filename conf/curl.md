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
