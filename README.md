
# Password Manager

generate secure passwords and maintain them securely 


## Features

- Generate random and secure passwords(using passy library)
- add user pass manager account
- encode user account password to sha256 (using guava library)
- get all passwords



## Tech Stack

**Client:** Swagger UI

**Server:** Java, Spring boot

**Database** MySql


## API Reference

#### Get all generated passwords for a particular user

```http
  GET /passwords/${username}/${password}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | **Required**. Your username |
| `password` | `string` | **Required**. Your password |

#### Get random password

```http
  PUT /random/password/${username}/${password}
```

Inputs are like the previous API.

#### add a new user password manager account 

```http
  POST /add/user/${username}/${password}
```
Inputs are like the previous API.


## Documentation

[Documentation](http://localhost:8080/password-manager/swagger.html)


## Run Locally

Clone the project

```bash
  git clone https://github.com/Fatemehjj/password-manager.git
```

Go to the project directory

make sure maven installed and correctly added to your environment variable

also make sure to configure your database in application.properties

```bash
  mvn spring-boot:run
```


## License

[MIT](https://choosealicense.com/licenses/mit/)

