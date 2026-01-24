# TaskManager - Android Task Management App

A simple and intuitive task management application built with Kotlin for Android. This project serves as a learning exercise for Android development fundamentals.

## 📱 Project Overview

TaskManager is a lightweight mobile application that helps users organize their daily tasks efficiently. The app demonstrates core Android development concepts including RecyclerView implementation, Room database persistence, MVVM architecture, and modern Android UI patterns.

## ✨ Current Features (v0.2.0)

- ✅ Add new tasks with validation
- ✅ Mark tasks as complete/incomplete with checkboxes
- ✅ Visual strikethrough for completed tasks
- ✅ Delete tasks with delete button
- ✅ **Data persistence** - tasks survive app restarts
- ✅ Clean and simple Material Design UI
- ✅ Real-time task list updates with LiveData
- ✅ Empty state when no tasks exist
- ✅ Automatic task ID generation
- ✅ Task creation timestamps

## 🏗️ Architecture

The project follows MVVM (Model-View-ViewModel) architecture with Repository pattern:
```
app/
├── data/
│   ├── Task.kt              # Room Entity (data model)
│   ├── TaskDao.kt           # Data Access Object (database queries)
│   ├── TaskDatabase.kt      # Room Database (singleton)
│   └── TaskRepository.kt    # Repository (abstraction layer)
├── ui/
│   ├── MainActivity.kt      # Main screen (View)
│   └── TaskViewModel.kt     # ViewModel (business logic)
├── adapter/
│   └── TaskAdapter.kt       # RecyclerView adapter
└── utils/                   # Helper classes (future)
```

### Architecture Benefits:
- **Separation of Concerns**: Each component has a single responsibility
- **Testability**: Easy to unit test individual components
- **Lifecycle Awareness**: ViewModel survives configuration changes
- **Reactive UI**: LiveData automatically updates UI when data changes

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Minimum SDK:** API 24 (Android 7.0)
- **Target SDK:** API 34 (Android 14)
- **Architecture:** MVVM (Model-View-ViewModel)
- **Database:** Room Persistence Library
- **Async Operations:** Kotlin Coroutines
- **UI Updates:** LiveData
- **UI:** XML Layouts with Material Design Components

### Key Libraries:
- **Room** `2.6.1` - Local database
- **Lifecycle Components** `2.7.0` - ViewModel & LiveData
- **Coroutines** `1.7.3` - Asynchronous programming
- **Material Components** `1.11.0` - Modern UI

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17 or newer
- Android SDK with API 34
- KSP (Kotlin Symbol Processing) Plugin


2. Open the project in Android Studio

3. Wait for Gradle sync to complete

4. Run the app on an emulator or physical device

## 📋 Roadmap

### Phase 1: Core Functionality ✅ (Completed)
- [x] Project setup and architecture
- [x] Basic task CRUD operations
- [x] Task list display with RecyclerView
- [x] Task completion toggle
- [x] Task deletion
- [x] Material Design UI
- [x] Input validation

### Phase 2: Data Persistence ✅ (Completed)
- [x] Implement Room Database
- [x] Create Task DAO (Data Access Object)
- [x] Repository pattern implementation
- [x] Persist tasks across app restarts
- [x] ViewModel with LiveData
- [x] Kotlin Coroutines for async operations
- [x] Task timestamps

### Phase 3: Enhanced Features (Next)
- [ ] Add task categories/tags
- [ ] Add due dates and reminders
- [ ] Task priority levels (High, Medium, Low)
- [ ] Edit existing tasks
- [ ] Search and filter tasks
- [ ] Sort tasks by date/priority/status

### Phase 4: UI/UX Improvements
- [ ] Swipe to delete gesture
- [ ] Task animations (add/delete/complete)
- [ ] Dark mode support
- [ ] Custom themes and colors
- [ ] Empty state illustrations
- [ ] Splash screen
- [ ] Improved Material Design 3

### Phase 5: Advanced Features
- [ ] Task notifications and reminders
- [ ] Recurring tasks
- [ ] Task statistics and insights dashboard
- [ ] Export/Import tasks (JSON/CSV)
- [ ] Cloud backup (Firebase)
- [ ] Multi-language support (i18n)
- [ ] Task attachments

### Phase 6: Modern Android
- [ ] Migrate to Jetpack Compose
- [ ] Add Dependency Injection (Hilt)
- [ ] Unit and UI testing
- [ ] Database migrations
- [ ] WorkManager for background tasks
- [ ] Navigation Component

## 📱 App Features in Detail

### Task Management
- **Create Tasks**: Add tasks with a simple text input
- **Complete Tasks**: Check off tasks when done (visual strikethrough)
- **Delete Tasks**: Remove tasks you no longer need
- **Persistent Storage**: All tasks are saved to local database

### Technical Highlights
- **MVVM Pattern**: Clean separation between UI and business logic
- **LiveData Observers**: Automatic UI updates when data changes
- **Coroutines**: Non-blocking database operations
- **Room Database**: Type-safe SQL queries with compile-time verification
- **Material Design**: Modern, intuitive user interface

### Commit Message Convention
- `feat:` - New features
- `fix:` - Bug fixes
- `docs:` - Documentation changes
- `refactor:` - Code refactoring
- `test:` - Adding tests
- `chore:` - Maintenance tasks

## 🙏 Acknowledgments

- Android Developer Documentation
- Kotlin Documentation
- Material Design Guidelines
- Room Persistence Library Documentation
- Kotlin Coroutines Guide

---
**Status:** ✅ Active Development
