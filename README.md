# 🧠 Dynamic Quiz Application with Selenium Automation

## 📌 Project Overview

This project is a **Dynamic Quiz Application** built using **HTML, CSS, and JavaScript**, along with **end-to-end automation testing** using **Selenium WebDriver (Java)**.

The application allows users to customize their quiz experience by selecting categories and difficulty levels, answer timed questions, and view detailed performance analysis after quiz completion. The Selenium automation validates the complete workflow automatically.

---

## 🚀 Features

### 🔹 Quiz Application (Frontend)

* Category selection (Math, Logic)
* Difficulty levels (Easy, Medium, Hard)
* One question displayed at a time
* Countdown timer for each question
* Automatic navigation on timeout
* Result analysis page with:

  * Total score
  * Correct & incorrect answers
  * Overall performance percentage
  * Time spent per question
  * Graphical representation (Bar chart & Pie chart)
* Fully responsive UI (Desktop, Tablet, Mobile)

---

### 🔹 Automation Testing (Selenium)

* Automated using **Selenium WebDriver with Java**
* Tests complete end-to-end quiz flow
* Verifies:

  * Landing page load
  * Category & difficulty selection
  * Quiz start
  * Question navigation
  * Answer selection
  * Result page validation
* Captures:

  * Execution screenshots
  * Execution logs

---

## 🛠️ Technologies Used

| Layer      | Technology            |
| ---------- | --------------------- |
| Frontend   | HTML, CSS, JavaScript |
| Charts     | Chart.js              |
| Automation | Selenium WebDriver    |
| Language   | Java                  |
| Build Tool | Maven                 |
| IDE        | IntelliJ IDEA         |

---

## 📂 Project Structure

```
Dynamic-Quiz-Application/
│
├── index.html          # Quiz setup page
├── quiz.html           # Quiz questions page
├── result.html         # Result analysis page
│
├── style.css           # UI styling
├── script.js           # Quiz logic
│
├── pom.xml             # Maven configuration
├── QuizAutomationTest.java  # Selenium automation test
│
├── logs/               # Execution logs
├── screenshots/        # Automation screenshots
```

---

## ▶️ How to Run the Quiz Application

1. Open the project in **VS Code**
2. Right-click `index.html`
3. Select **Open with Live Server**
4. The app runs at:

   ```
   http://127.0.0.1:5500/index.html
   ```

---

## ▶️ How to Run Automation Tests

1. Open project in **IntelliJ IDEA**
2. Ensure **Chrome browser** is installed
3. Start **Live Server** for the quiz app
4. Run:

   ```
   QuizAutomationTest.java
   ```
5. Selenium will:

   * Launch Chrome automatically
   * Execute the quiz flow
   * Capture screenshots and logs
   * Close browser after completion

---

## 🧪 Test Evidence

* 📸 Screenshots stored in `screenshots/`
* 🪵 Execution logs stored in `logs/execution.log`
* 🎥 Screen recording captured separately
* 📄 Test report prepared and submitted

---

## ✅ Test Coverage Summary

* Landing page validation
* Quiz customization
* Timed question handling
* Answer selection
* Result calculation verification
* Graphical analysis verification

---

## 🎯 Conclusion

The Dynamic Quiz Application was successfully implemented and tested using Selenium automation. All major functionalities were validated, and the application performed as expected across all test scenarios.

---

## 👨‍💻 Author

**Name:** *Neerath Kumar*
**Role:** Software / Test Automation Enthusiast

---

## 📎 Notes

* No backend or database is used
* Quiz logic and score calculation are handled using JavaScript
* Automation uses Selenium 4 with automatic driver management


