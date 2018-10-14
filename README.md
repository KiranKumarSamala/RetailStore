# RetailStore Application

The application is to provide discount for the products available at the retail store

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

# Installing / Getting started

```shell
https://github.com/KiranKumarSamala/RetailStore.git
cd RetailStore
mvn install -Dmaven.test.skip=false
```

## Functionality

Calculate discount based on the below rules
* if user is staff provide 30% discount
* if user is affiliate provide 10% discount
* other users who are having more than 2 years of relation with the store will avail 5% discount
* any type of user cant avail discount on grocery products
