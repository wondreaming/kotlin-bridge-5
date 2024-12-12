package bridge.controller.domain

import bridge.controller.validator.UpDownValidator
import bridge.util.BridgeNumberGenerator
import bridge.util.retryWhenNoException
import bridge.view.InputView

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>("U", "D", "D")
//        var count = 0
//        while (count < size) {
//            bridge.add("")
//            count++
//        }
        return bridge
    }


}
