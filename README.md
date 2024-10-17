
# Rick & Morty

An Android app built with **Jetpack Compose**, following the **Clean Architecture** and **MVVM** principles, to explore characters from the *Rick and Morty* series.

## Features

- Browse a list of Rick & Morty characters
- View character details upon selection
- Smooth navigation between screens
- Dependency injection with **Koin**
- Asynchronous network calls with **Retrofit** and **Coroutines**
- Image loading with **Coil**
- State management with **ViewModel** and **Kotlin Flows**
- Clean Architecture with multiple modules for scalability and maintainability

## Architecture

This app is structured using **Clean Architecture**, ensuring separation of concerns and testability:

- **Presentation Layer**: Contains UI code built with **Jetpack Compose** and **ViewModels**.
- **Domain Layer**: Holds use cases and business logic.
- **Data Layer**: Manages network requests and repositories.
  
Each layer communicates with one another via well-defined interfaces.

## Tech Stack

- **Kotlin** for programming
- **Jetpack Compose** for UI
- **Koin** for Dependency Injection
- **Retrofit** for network requests
- **Coroutines** for asynchronous operations
- **Coil** for image loading
- **Navigation Component** for screen transitions
- **MVVM** architecture
- **Multi-module** project structure
