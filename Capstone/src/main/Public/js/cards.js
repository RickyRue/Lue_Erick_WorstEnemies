const quizQuestions = [
    [
        {title: "Kraft Blue Box", svgUrl: "./images/elbow-mac-01.svg", id: "kraft"},
        {title: "Velveeta Shells", svgUrl: "./images/shells-mac-01.svg", id: "shells"}
    ],
    [
        {title: "Coke", svgUrl: "./images/shells-mac-01.svg", id: "coke"},
        {title: "Pepsi", svgUrl: "./images/elbow-mac-01.svg", id: "pepsi"}
    ],
    [
        {title: "Pronounced 'gif'", svgUrl: "./images/elbow-mac-01.svg", id: "p-gif"},
        {title: "Pronounced 'jif'", svgUrl: "./images/shells-mac-01.svg", id: "p-jif"}
    ],
    [
        {title: "Wheels", svgUrl: "./images/shells-mac-01.svg", id: "wheels"},
        {title: "Doors", svgUrl: "./images/elbow-mac-01.svg", id: "doors"}
    ]
];

let currentQuestionPair = 0;

function refreshCardsDisplay() {
    const [q1, q2] = quizQuestions[currentQuestionPair];
    const cardsContainer = document.getElementById("cards-container");
    cardsContainer.innerHTML = `
            <div id="${q1.id}" class="d-flex justify-content-center align-items-center h-100">
                <div class="cards-bg cards-bg__svg border-3 border-primary card" style="background-image: url('${q1.svgUrl}')">
                    <div class="card-body m-5 p-5 text-center">
                        <h3>${q1.title}</h3>
                    </div>
                </div>
            </div>

            <div id="${q2.id}" class="d-flex justify-content-center align-items-center h-100">
                <div class="cards-bg cards-bg__svg border-3 border-primary card" style="background-image: url('${q2.svgUrl}')">
                    <div class="card-body m-5 p-5 text-center">
                        <h3>${q2.title}</h3>
                    </div>
                </div>
            </div>
       `;

    [q1.id, q2.id].forEach(id => {
        document.getElementById(id).addEventListener('click', (evt) => handleSelectCard(evt, currentQuestionPair, id));
    })
}

document.addEventListener('DOMContentLoaded', refreshCardsDisplay);

function handleSelectCard(evt, questionPairIndex, selectedCardId) {
    quizQuestions[questionPairIndex].find(question => question.id === selectedCardId).chosen = true;
    if (currentQuestionPair < quizQuestions.length - 1) {
        document.getElementById("post-selection-buttons").classList.remove("d-none");
    } else {
        const summaryDiv = document.getElementById("quiz-summary");

        let t = `
            <table>
                <thead>
                    <tr>
                        <th>Choice A</th>
                        <th>Choice B</th>
                    </tr>
                </thead>
                <tbody>
        `;

        for (const pair of quizQuestions) {
            t += `<tr>`;

            for (const q of pair) {
                if (q.chosen === true) t += `<td><b>${q.title}</b></td>`;
                else t += `<td>${q.title}</td>`;
            }

            t += `</tr>`;
        }

        t += `
                </tbody>
            </table>`

        summaryDiv.innerHTML = t;

        summaryDiv.classList.remove("d-none");
        document.getElementById("cards-container").classList.add("d-none");
    }
}

function nextQuestion() {
    currentQuestionPair++;
    refreshCardsDisplay();
    document.getElementById("post-selection-buttons").classList.add("d-none");
}