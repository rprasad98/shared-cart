# Shared Cart

Shared Cart is a collaborative shopping cart application that enables family members or friends to create, manage, and share a common cart for group purchases. Built with Java and Spring Boot, this project allows multiple users to add, update, or remove items in a shared cart, making group shopping experiences seamless and organized.

## Features

- **Collaborative Carts:** Create carts that can be shared among multiple users (family, friends, or teams).
- **User Management:** Register, update, and delete users with different user types (e.g., admin).
- **Item Management:** Add, update, and remove items from a cart.
- **Cart Administration:** Assign admin users to each cart, with permissions to manage members and items.
- **REST API:** Exposes endpoints for cart and user operations, designed for integration with web or mobile frontends.
- **Spring Boot & JPA:** Leverages modern Java frameworks for scalable and maintainable backend development.

## Prerequisites

- Java 21
- Maven
- Spring Boot 3.x

## Getting Started

1. **Clone the repository**
    ```bash
    git clone https://github.com/rprasad98/shared-cart.git
    cd shared-cart
    ```

2. **Configure application properties**

    Update `src/main/resources/application.properties` with your database and environment configuration.

3. **Build and Run**
    ```bash
    mvn spring-boot:run
    ```

## API Documentation

### User APIs

- `GET /api/v1/user` — Get all users or filter by userName
- `POST /api/v1/user` — Add a new user
- `PUT /api/v1/user/{userName}` — Update an existing user
- `DELETE /api/v1/user/{userName}` — Remove a user

### Cart APIs

- `POST /addItems/{cartId}` — Add items to a cart
- (Additional cart and item APIs can be added as the project grows)

*For detailed request/response examples, refer to the controller classes in the `src/main/java/com/example/demo/contoller/` directory.*

## Project Structure

- `Entity/` — JPA entities for Users, Carts, CartItems, etc.
- `Repository/` — Spring Data JPA repositories for database operations.
- `Service/` — Business logic and service implementations.
- `contoller/` — REST API controllers.
- `config/` — Additional configuration classes.

## Contributing

Contributions are welcome! Please open issues or submit pull requests for bug fixes, improvements, or new features. Before contributing, ensure your code:

- Follows project structure and code conventions
- Includes relevant tests
- Passes all existing tests

## License

[MIT](LICENSE) (Replace with your chosen license)
