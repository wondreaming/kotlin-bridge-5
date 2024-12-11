package bridge.controller

import bridge.controller.domain.UserInteractionController
import bridge.controller.validator.BridgeLengthValidator
import bridge.controller.validator.UpDownValidator

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val bridgeLengthValidator: BridgeLengthValidator = BridgeLengthValidator(),
    private val upDownValidator: UpDownValidator = UpDownValidator(),
) {
    fun run() {
        userInteractionController.handleStartMsg()
        val bridgeLength = getBrideLength()
        val upDown = getUpDown()
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
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move() {}

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
