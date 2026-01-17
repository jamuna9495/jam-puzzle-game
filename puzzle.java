let tiles = [1, 2, 3, 4, 5, 6, 7, 8, ""];
let moveCount = 0;
const board = document.getElementById('puzzle-board');
const moveDisplay = document.getElementById('moves');

function initGame() {
    board.innerHTML = "";
    tiles.forEach((num, i) => {
        const div = document.createElement('div');
        div.className = `tile ${num === "" ? "empty" : ""}`;
        div.innerText = num;
        div.onclick = () => swap(i);
        board.appendChild(div);
    });
}

function swap(i) {
    const emptyIdx = tiles.indexOf("");
    const isAdjacent = [i-1, i+1, i-3, i+3].includes(emptyIdx);

    if (isAdjacent) {
        [tiles[i], tiles[emptyIdx]] = [tiles[emptyIdx], tiles[i]];
        moveCount++;
        moveDisplay.innerText = moveCount;
        initGame();
        checkWin();
    }
}

function shuffleTiles() {
    tiles.sort(() => Math.random() - 0.5);
    moveCount = 0;
    moveDisplay.innerText = 0;
    initGame();
}

function checkWin() {
    if (tiles.join('') === "12345678") {
        alert("Mission Accomplished! 2026 Style!");
    }
}

initGame();
