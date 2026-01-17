# TaskManager - Android Task Management App

A simple and intuitive task management application built with Kotlin for Android. This project serves as a learning exercise for Android development fundamentals.

## 📱 Project Overview

TaskManager is a lightweight mobile application that helps users organize their daily tasks efficiently. The app demonstrates core Android development concepts including RecyclerView implementation, data handling, and modern Android UI patterns.

## ✨ Current Features (v0.1.0)

- ✅ Add new tasks
- ✅ Mark tasks as complete/incomplete with checkboxes
- ✅ Delete tasks with long-press
- ✅ Clean and simple Material Design UI
- ✅ Real-time task list updates

## 🏗️ Architecture

The project follows a clean architecture pattern:
```
app/
├── data/           # Data models and entities
├── ui/             # Activities and Fragments
├── adapter/        # RecyclerView adapters
└── utils/          # Helper classes and utilities
```

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Minimum SDK:** API 24 (Android 7.0)
- **Target SDK:** API 34 (Android 14)
- **Architecture:** MVVM (planned)
- **UI:** XML Layouts with Material Components

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17 or newer
- Android SDK with API 34


## 📋 Roadmap

### Phase 1: Core Functionality ✅ (Current)
- [x] Project setup and architecture
- [x] Basic task CRUD operations
- [x] Task list display with RecyclerView
- [x] Task completion toggle
- [x] Task deletion

### Phase 2: Data Persistence (Next)
- [ ] Implement Room Database
- [ ] Create Task DAO (Data Access Object)
- [ ] Repository pattern implementation
- [ ] Persist tasks across app restarts

### Phase 3: Enhanced Features
- [ ] Add task categories/tags
- [ ] Add due dates and reminders
- [ ] Task priority levels (High, Medium, Low)
- [ ] Edit existing tasks
- [ ] Search and filter tasks
- [ ] Sort tasks by date/priority

### Phase 4: UI/UX Improvements
- [ ] Swipe to delete gesture
- [ ] Task animations
- [ ] Dark mode support
- [ ] Custom themes and colors
- [ ] Empty state illustrations
- [ ] Splash screen

### Phase 5: Advanced Features
- [ ] Task notifications
- [ ] Recurring tasks
- [ ] Task statistics and insights
- [ ] Export/Import tasks
- [ ] Cloud backup (Firebase)
- [ ] Multi-language support

### Phase 6: Modern Android
- [ ] Migrate to Jetpack Compose
- [ ] Implement MVVM with ViewModel
- [ ] Use Kotlin Coroutines for async operations
- [ ] Add Dependency Injection (Hilt)
- [ ] Unit and UI testing


## 🙏 Acknowledgments

- Android Developer Documentation
- Kotlin Documentation
- Material Design Guidelines

---
