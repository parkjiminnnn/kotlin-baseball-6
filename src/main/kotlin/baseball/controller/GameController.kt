package baseball.controller

import baseball.model.GameModel
import baseball.view.GameView


class GameController {
    private val gameView = GameView()
    private val gameModel = GameModel()
    fun playGame() {
        gameView.gameStartMsg()
        while (gameView.errorCheck()) {
            gameView.gameRule()
            if (gameView.inputNumber == gameView.gameModel.randomNumbers) {
                gameView.gameEndMsg()
                val startOrEnd = readln()
                if (gameModel.endGameCheck(startOrEnd)) {
                    gameView.gameModel.randomNumbers = gameModel.randomNumbers
                    println(gameView.gameModel.randomNumbers)
                } else {
                    break
                }
            }
        }
    }
}