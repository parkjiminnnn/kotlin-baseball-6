package baseball.controller

import baseball.view.GameView


class GameController() {
    private val gameView = GameView()
    fun playGame() {
        gameView.gameStart()
        while (true) {
            gameView.gameRule()
            if (gameView.inputNumber == gameView.gameModel.randomNumbers) {
                gameView.gameEnd()
                break
            }
        }
    }
}