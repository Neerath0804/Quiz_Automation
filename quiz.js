let category = localStorage.getItem("category");
let difficulty = localStorage.getItem("difficulty");

let quizQuestions = questions.filter(q =>
  q.category === category && q.difficulty === difficulty
);

let current = 0;
let score = 0;
let timer, timeLeft;
let timeSpent = [];

function loadQuestion() {
  clearInterval(timer);
  let q = quizQuestions[current];

  document.getElementById("question").innerText = q.question;

  document.getElementById("options").innerHTML =
    q.options.map(o =>
      `<label><input type="radio" name="opt" value="${o}"> ${o}</label>`
    ).join("");

  timeLeft = q.time;
  document.getElementById("timer").innerText = timeLeft;

  timer = setInterval(() => {
    timeLeft--;
    document.getElementById("timer").innerText = timeLeft;
    if (timeLeft === 0) nextQuestion();
  }, 1000);
}

function nextQuestion() {
  clearInterval(timer);

  let used = quizQuestions[current].time - timeLeft;
  timeSpent.push(used);

  let selected = document.querySelector('input[name="opt"]:checked');
  if (selected && selected.value === quizQuestions[current].correct) {
    score++;
  }

  current++;
  if (current < quizQuestions.length) loadQuestion();
  else {
    localStorage.setItem("score", score);
    localStorage.setItem("total", quizQuestions.length);
    localStorage.setItem("timeSpent", JSON.stringify(timeSpent));
    window.location.href = "result.html";
  }
}

loadQuestion();
