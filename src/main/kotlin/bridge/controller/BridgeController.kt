package bridge.controller

import bridge.controller.domain.UserInteractionController
import bridge.controller.validator.BridgeLengthValidator
import bridge.controller.validator.RestartQuitValidator
import bridge.controller.validator.UpDownValidator

class BridgeController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val bridgeLengthValidator: BridgeLengthValidator = BridgeLengthValidator(),
    private val upDownValidator: UpDownValidator = UpDownValidator(),
    private val restartQuitValidator: RestartQuitValidator = RestartQuitValidator(),
) {
    fun run() {
        userInteractionController.handleStartMsg()
        val bridgeLength = getBrideLength()
        val upDown = getUpDown()
        val restartQuit = getRestartQuit()
    }

    private fun getBrideLength(): Int {
        val bridgeLength = userInteractionController.handleBridgeLength()
        bridgeLengthValidator(bridgeLength)
        return bridgeLength.toInt()
    }

    private fun getUpDown(): String {
        val upDown = userInteractionController.handleUpDown()
        upDownValidator(upDown)
        return upDown
    }

    private fun getRestartQuit(): String {
        val restartQuit = userInteractionController.handleRestartQuit()
        restartQuitValidator(restartQuit)
        return restartQuit
    }
}