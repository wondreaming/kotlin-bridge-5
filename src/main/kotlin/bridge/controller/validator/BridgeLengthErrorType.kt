package bridge.controller.validator

enum class BridgeLengthErrorType(
    private val errorMessage: String
) {
    EMPTY_INPUT("빈 값입니다. 다시 입력해 주세요."),
    INTEGER("정수가 아닙니다"),
    LENGTH("다리 길이는 3~20만 입력할 수 있습니다.");

    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}
