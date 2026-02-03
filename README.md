# Android Activity Lifecycle Explorer 🚀

This project is a minimal Android application built to **experiment with and understand the Android Activity Lifecycle**, back stack behavior, and back button handling.

It uses **three activities (A, B, C)** and logs lifecycle callbacks to demonstrate how Android manages activities in real scenarios.

---

## 🧠 What This App Demonstrates

- Activity lifecycle callbacks (`onCreate`, `onStart`, `onResume`, etc.)
- Back stack behavior across multiple activities
- Difference between:
    - Navigating back from an activity
    - Explicitly calling `finish()`
- How Android behaves when an app goes to background vs is destroyed
- Effect of screen rotation (configuration change)
- Custom back handling using `OnBackPressedDispatcher`

---

## 🏗️ App Structure

MainActivity (Activity A)

├─ Button → Activity B (calls finish())

└─ Button → Activity C (keeps A alive


---

## 🔍 Experiment Scenarios & Observations

### 1️⃣ App Launch
- `onCreate → onStart → onResume`

### 2️⃣ Navigate A → C → Back
- Activity A resumes
- Random number remains unchanged

### 3️⃣ Navigate A → B → Back
- Activity A is destroyed using `finish()`
- App exits
- Reopening regenerates data

### 4️⃣ Screen Rotation
- Activity is destroyed and recreated
- Demonstrates configuration change behavior

### 5️⃣ Back Press Handling
- `OnBackPressedDispatcher` is used to explicitly call `finish()`
- Ensures predictable lifecycle termination

---

## 📂 Logcat Evidence

<img width="1877" height="757" alt="Screenshot 2026-02-03 121604" src="https://github.com/user-attachments/assets/045857a2-8f5a-4547-bc16-38d0937dea3d" />


<img width="1886" height="751" alt="Screenshot 2026-02-03 121621" src="https://github.com/user-attachments/assets/7edf599f-0973-442f-b4e9-9417d477c9cf" />


<img width="1738" height="759" alt="Screenshot 2026-02-03 124821" src="https://github.com/user-attachments/assets/6ce1f7c2-ce95-49d9-8125-47b36c32da1e" />

These logs validate the lifecycle transitions discussed above.

---

## 🛠️ Tech Stack

- Kotlin
- Jetpack Compose
- Android Activity Lifecycle
- Logcat

---

## 🎯 Key Learnings

- Android does NOT destroy activities unless required
- BACK ≠ DESTROY
- `finish()` gives explicit lifecycle control
- Configuration changes recreate activities
- Lifecycle awareness is crucial for state management

---

## ✨ Why This Matters

Understanding activity lifecycle behavior is fundamental for:
- Correct state handling
- Performance optimization
- Preventing memory leaks
- Building predictable navigation flows

---

Built as a learning and experimentation project.


---
Medium article link: https://medium.com/@kritstudy15/activity-and-activity-lifecycles-in-android-5c0e8b747847
