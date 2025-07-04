# 🌍 Kountries – Android Kotlin App

**Kountries** is a modern Android application built with **Kotlin**, **Jetpack Libraries**, **Retrofit**, **Room**, **LiveData**, and **RxJava**. It fetches country data from a remote JSON API, caches it using Room, and displays it with intuitive UI using **Data Binding** and **MVVM** architecture.

> 📱 Features both list and detail screens, with offline caching and swipe-to-refresh capability.

---

## 📸 Screenshots

| Feed Screen | Detail Screen |
|-------------|---------------|
| ![Feed](https://github.com/bugrahankaramollaoglu/kountries/blob/main/readme_files/photo_1.png) | ![Detail](https://github.com/bugrahankaramollaoglu/kountries/blob/main/readme_files/photo_2.png) |

## 🚀 Features

- 🌐 **Remote Fetch**: Uses Retrofit and RxJava to fetch data from a GitHub-hosted JSON dataset.
- 🧠 **MVVM Architecture**: Clean separation of View, ViewModel, Repository, and Model layers.
- 🧩 **Navigation Component**: Handles screen transitions with Safe Args.
- 🗄️ **Room Persistence**: Local SQLite caching for offline support.
- 🔄 **Swipe Refresh**: Pull to refresh the country list.
- ⚡ **View/Data Binding**: Efficient and clean UI updates.
- 🌈 **Glide**: Loads country flags efficiently.

---

## 🧱 Tech Stack

| Layer        | Library/Tool                            |
|--------------|-----------------------------------------|
| Language     | Kotlin                                  |
| UI Binding   | ViewBinding + DataBinding               |
| Architecture | MVVM + LiveData                         |
| Networking   | Retrofit2 + Gson + RxJava               |
| Caching      | Room (with SQLite)                      |
| Image Loading| Glide                                   |
| Navigation   | Jetpack Navigation Component + Safe Args|
| Background   | Coroutines (launch block)               |
| Preferences  | SharedPreferences (Custom Wrapper)      |

---

## 🧠 Architecture Overview

- **FeedFragment**: Displays list of countries with RecyclerView.
- **CountryFragment**: Shows detailed info about a selected country.
- **ViewModels**: `FeedViewModel`, `CountryViewModel`
- **Model**: `Country` (Room Entity + Gson Mapping)
- **Service**: `CountryApiService` + `CountryAPI` (interface)
- **Persistence**: `CountryDatabase`, `CountryDao`

