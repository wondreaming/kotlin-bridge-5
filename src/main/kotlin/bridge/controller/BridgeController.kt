package bridge.controller

import bridge.controller.domain.UserInteractionController
import bridge.controller.validator.BridgeLengthValidator
import bridge.controller.validator.RestartQuitValidator
import bridge.controller.validator.UpDownValidator
import bridge.model.BridgeGame
import bridge.util.BridgeRandomNumberGenerator
import bridge.util.retryWhenNoException

class BridgeController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val bridgeLengthValidator: BridgeLengthValidator = BridgeLengthValidator(),
    private val upDownValidator: UpDownValidator = UpDownValidator(),
    private val restartQuitValidator: RestartQuitValidator = RestartQuitValidator(),
) {
    fun run() {
        userInteractionController.handleStartMsg()
        val bridgeLength = getBrideLength()
        startGame(bridgeLength)

    }

    private fun getBrideLength(): Int = retryWhenNoException {
        val bridgeLength = userInteractionController.handleBridgeLength()
        bridgeLengthValidator(bridgeLength)
        bridgeLength.toInt()
    }

    private fun getUpDown(): String = retryWhenNoException {
        val upDown = userInteractionController.handleUpDown()
        upDownValidator(upDown)
        upDown
    }

    private fun getRestartQuit(): String = retryWhenNoException {
        val restartQuit = userInteractionController.handleRestartQuit()
        restartQuitValidator(restartQuit)
        restartQuit
    }

    private fun startGame(bridgeLength: Int) {
        var rQ = true
        val up = mutableListOf<String>()
        val down = mutableListOf<String>()
        var round = 1
        var success = false
        while (rQ) {
            var count = 0
            while (count < bridgeLength) {
                var upMap: Boolean = true;
                var downMap: Boolean = true;
                val randomNumber = BridgeRandomNumberGenerator().generate()
                when (randomNumber) {
                    0 -> upMap = false
                    1 -> downMap = false
                }
                val userInput = getUpDown()
                when (userInput) {
                    "U" -> {
                        down.add(" ")
                        if (upMap) up.add("O") else up.add("X")
                    }

                    "D" -> {
                        up.add(" ")
                        if (downMap) down.add("O") else down.add("X")
                    }
                }
                userInteractionController.handleGameRound(up, down)
                if (up.last() == "X" || down.last() == "X") break else count++
            }

            if (count == bridgeLength) {
                success = true
                val gameResult = when (success) {
                    true -> "성공"
                    else -> "실패"
                }
                userInteractionController.handleResult(up, down, gameResult, round)
                break
            } else {
                val restartQuit = getRestartQuit()
                rQ = when (restartQuit) {
                    "R" -> true
                    else -> false
                }
                round++
            }
        }
    }
}