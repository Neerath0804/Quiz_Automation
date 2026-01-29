// Get data from localStorage
let score = Number(localStorage.getItem("score"));
let total = Number(localStorage.getItem("total"));
let timeSpent = JSON.parse(localStorage.getItem("timeSpent"));

let incorrectCount = total - score;
let percentage = Math.round((score / total) * 100);

// Get DOM elements (IMPORTANT FIX)
let scoreEl = document.getElementById("score");
let correctEl = document.getElementById("correct");
let incorrectEl = document.getElementById("incorrect");
let performanceEl = document.getElementById("performance");

// Display text results
scoreEl.innerText = `Score: ${score} / ${total}`;
correctEl.innerText = `Correct Answers: ${score}`;
incorrectEl.innerText = `Incorrect Answers: ${incorrectCount}`;
performanceEl.innerText = `Overall Performance: ${percentage}%`;

// ----------- TIME SPENT BAR CHART -----------
const timeCtx = document.getElementById("timeChart").getContext("2d");

new Chart(timeCtx, {
  type: "bar",
  data: {
    labels: timeSpent.map((_, i) => `Q${i + 1}`),
    datasets: [{
      label: "Time Spent (seconds)",
      data: timeSpent,
      backgroundColor: "#667eea"
    }]
  },
  options: {
    responsive: true,
    plugins: {
      legend: { display: true }
    }
  }
});

// ----------- RESULT PIE CHART -----------
const resultCtx = document.getElementById("resultChart").getContext("2d");

new Chart(resultCtx, {
  type: "pie",
  data: {
    labels: ["Correct", "Incorrect"],
    datasets: [{
      data: [score, incorrectCount],
      backgroundColor: ["#48bb78", "#e53e3e"]
    }]
  },
  options: {
    responsive: true
  }
});
