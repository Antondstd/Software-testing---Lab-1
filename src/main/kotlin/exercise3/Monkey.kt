package exercise3

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class Monkey(
    override var name: String,
    override var condition: HumanoidCondition = HumanoidCondition.Calm,
    override var handsStatus: HandsStatus = HandsStatus.Clean,
    override var actionStatus: Pair<ActionType, Any?> = Pair(ActionType.Chilling, null),
    val type: TypeMonkey,
    var wool: TypeWool
) : Humanoid() {
    override val voiceType: VoiceType

    init {
        when (type) {
            TypeMonkey.Gorilla -> voiceType = VoiceType.baritone
            TypeMonkey.Mandarill -> voiceType = VoiceType.tnin
            else -> voiceType = VoiceType.tenor
        }
    }
}

enum class TypeMonkey {
    Gorilla,
    Baboon,
    Tamarin,
    Mandarill
}

enum class TypeWool {
    Furry,
    Short,
    Bold
}