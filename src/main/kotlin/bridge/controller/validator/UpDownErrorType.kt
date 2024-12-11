package bridge.controller.validator

enum class UpDownErrorType(
    private val errorMessage: String
) {
    EMPTY_INPUT("빈 값입니다. 다시 입력해 주세요."),
    UP_DOWN("U나 D가 아닙니다");

    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}
